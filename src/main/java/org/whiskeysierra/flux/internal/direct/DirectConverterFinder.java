package org.whiskeysierra.flux.internal.direct;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Feature;
import org.whiskeysierra.flux.FeatureSet;
import org.whiskeysierra.flux.Key;
import org.whiskeysierra.flux.internal.AbstractConverterFinder;
import org.whiskeysierra.flux.spi.Converter;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public final class DirectConverterFinder extends AbstractConverterFinder {

    private final ConcurrentMap<Key<?, ?>, Converter<?, ?>> mapping = Maps.newConcurrentMap();

    public DirectConverterFinder(FeatureSet features, Map<Key<?, ?>, Converter<?, ?>> map) {
        super(features);

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
            mapping.putIfAbsent(Key.of(input, type), converter);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <I, O> Converter<I, O> find(TypeToken<? super I> input, TypeToken<O> output) {
        return (Converter<I, O>) mapping.get(Key.of(input, output));
    }

}
