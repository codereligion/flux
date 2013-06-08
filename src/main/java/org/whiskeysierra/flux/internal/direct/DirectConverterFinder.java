package org.whiskeysierra.flux.internal.direct;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Feature;
import org.whiskeysierra.flux.FeatureSet;
import org.whiskeysierra.flux.Key;
import org.whiskeysierra.flux.internal.AbstractConverterFinder;
import org.whiskeysierra.flux.spi.Converter;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public final class DirectConverterFinder extends AbstractConverterFinder {

    private final ConcurrentMap<Key<?, ?>, Converter<?, ?>> mapping = Maps.newConcurrentMap();
    private final ConcurrentMap<Key<?, ?>, Converter<?, ?>> implicit = Maps.newConcurrentMap();
    private final FeatureSet features;

    public DirectConverterFinder(FeatureSet features, Map<Key<?, ?>, Converter<?, ?>> map) {
        this.features = Preconditions.checkNotNull(features, "Features");
        this.mapping.putAll(Preconditions.checkNotNull(map, "Map"));

        if (features.contains(Feature.SUPER_TYPING)) {
            for (Map.Entry<Key<?, ?>, Converter<?, ?>> entry : map.entrySet()) {
                final Key<?, ?> key = entry.getKey();
                tryRegisterOutputSuperTypes(key, entry.getValue());
            }
        }
    }

    @edu.umd.cs.findbugs.annotations.SuppressWarnings("RV_RETURN_VALUE_OF_PUTIFABSENT_IGNORED")
    private void tryRegisterOutputSuperTypes(Key<?, ?> key, Converter<? ,?> converter) {
        final TypeToken<?> input = key.getInput();
        final TypeToken<?> output = key.getOutput();

        for (TypeToken<?> type : output.getTypes()) {
            implicit.putIfAbsent(Key.of(input, type), converter);
        }
    }

    public <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");

        if (features.containsAll(EnumSet.of(Feature.SUPER_TYPING, Feature.SUB_TYPING))) {
            for (TypeToken<? super I> type : input.getTypes()) {
                final Key<? super I, O> key = Key.of(type, output);
                final Converter<?, ?> converter = mapping.get(key);

                if (converter == null) {
                    final Converter<?, ?> alternative = implicit.get(key);
                    if (alternative != null) {
                        return cast(alternative);
                    }
                } else {
                    return cast(converter);
                }
            }

            return null;
        } else if (features.contains(Feature.SUB_TYPING)) {
            for (TypeToken<? super I> type : input.getTypes()) {
                final Converter<?, ?> converter = mapping.get(Key.of(type, output));
                if (converter != null) {
                    return cast(converter);
                }
            }

            return null;
        } else {
            final Key<I, O> key = Key.of(input, output);
            final Converter<?, ?> converter = mapping.get(key);

            if (converter == null && features.contains(Feature.SUPER_TYPING)) {
                return cast(implicit.get(key));
            } else {
                return cast(converter);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <I, O> Converter<I, O> cast(Converter<?, ?> converter) {
        return (Converter<I, O>) converter;
    }

}
