package org.whiskeysierra.flux.direct;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Feature;
import org.whiskeysierra.flux.FeatureSet;
import org.whiskeysierra.flux.spi.AbstractConverterMapping;
import org.whiskeysierra.flux.spi.Converter;

import java.util.EnumSet;
import java.util.concurrent.ConcurrentMap;

public final class DirectConverterMapping extends AbstractConverterMapping {

    private final ConcurrentMap<ConversionKey<?, ?>, Converter<?, ?>> mapping = Maps.newConcurrentMap();
    private final ConcurrentMap<ConversionKey<?, ?>, Converter<?, ?>> implicit = Maps.newConcurrentMap();
    private final FeatureSet features;

    public DirectConverterMapping(FeatureSet features) {
        this.features = Preconditions.checkNotNull(features, "Features");
    }

    @edu.umd.cs.findbugs.annotations.SuppressWarnings("RV_RETURN_VALUE_OF_PUTIFABSENT_IGNORED")
    private <I, O> void tryRegisterOutputSuperTypes(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter) {
        if (features.contains(Feature.SUPER_TYPING)) {
            for (TypeToken<? super O> type : output.getTypes()) {
               implicit.putIfAbsent(ConversionKey.of(input, type), converter);
            }
        }
    }

    @Override
    public <I, O> void register(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter)
            throws IllegalArgumentException {

        final ConversionKey<I, O> key = ConversionKey.of(input, output);
        final Converter<?, ?> current = mapping.putIfAbsent(key, converter);
        Preconditions.checkState(current == null, "A binding for '%s' already existed: %s", key, current);
        tryRegisterOutputSuperTypes(input, output, converter);
    }

    @Override
    public <I, O> void tryRegister(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter) {
        final Converter<?, ?> current = mapping.putIfAbsent(ConversionKey.of(input, output), converter);

        if (current == null) {
            tryRegisterOutputSuperTypes(input, output, converter);
        }
    }

    @Override
    public <I, O> void forceRegister(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter) {
        mapping.put(ConversionKey.of(input, output), converter);
        tryRegisterOutputSuperTypes(input, output, converter);
    }

    public <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");

        if (features.containsAll(EnumSet.of(Feature.SUPER_TYPING, Feature.SUB_TYPING))) {
            for (TypeToken<? super I> type : input.getTypes()) {
                final ConversionKey<? super I, O> key = ConversionKey.of(type, output);
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
                final Converter<?, ?> converter = mapping.get(ConversionKey.of(type, output));
                if (converter != null) {
                    return cast(converter);
                }
            }

            return null;
        } else {
            final ConversionKey<I, O> key = ConversionKey.of(input, output);
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
