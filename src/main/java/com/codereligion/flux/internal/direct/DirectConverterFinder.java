package com.codereligion.flux.internal.direct;

import com.codereligion.flux.Feature;
import com.codereligion.flux.FeatureSet;
import com.codereligion.flux.Key;
import com.codereligion.flux.internal.AbstractConverterFinder;
import com.codereligion.flux.spi.Converter;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.TypeToken;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public final class DirectConverterFinder extends AbstractConverterFinder {

    private final ConcurrentMap<Key<?, ?>, Converter<?, ?>> mapping = Maps.newConcurrentMap();

    public DirectConverterFinder(FeatureSet features, Map<Key<?, ?>, Converter<?, ?>> map) {
        super(features);

        this.mapping.putAll(Preconditions.checkNotNull(map, "Map"));

        if (features.contains(Feature.AUTOBOXING)) {
            for (Map.Entry<Key<?, ?>, Converter<?, ?>> entry : map.entrySet()) {
                final Key<?, ?> key = entry.getKey();
                final Class<?> input = key.getInput().getRawType();
                final Class<?> output = key.getOutput().getRawType();
                final Converter<?, ?> converter = entry.getValue();

                if (Primitives.allWrapperTypes().contains(input)) {
                    tryPut(Primitives.unwrap(input), key.getOutput(), converter);
                }

                if (Primitives.allPrimitiveTypes().contains(output)) {
                    tryPut(key.getInput(), Primitives.wrap(output), converter);
                }
            }
        }

        if (features.contains(Feature.UNBOXING)) {
            for (Map.Entry<Key<?, ?>, Converter<?, ?>> entry : map.entrySet()) {
                final Key<?, ?> key = entry.getKey();
                final Class<?> input = key.getInput().getRawType();
                final Class<?> output = key.getOutput().getRawType();
                final Converter<?, ?> converter = entry.getValue();

                if (Primitives.allPrimitiveTypes().contains(input)) {
                    tryPut(Primitives.wrap(input), key.getOutput(), converter);
                }

                if (Primitives.allWrapperTypes().contains(output)) {
                    tryPut(key.getInput(), Primitives.unwrap(output), converter);
                }
            }
        }

        if (features.contains(Feature.SUPER_TYPING)) {
            for (Map.Entry<Key<?, ?>, Converter<?, ?>> entry : map.entrySet()) {
                final Key<?, ?> key = entry.getKey();

                for (TypeToken<?> output : key.getOutput().getTypes()) {
                    tryPut(key.getInput(), output, entry.getValue());
                }
            }
        }
    }

    private void tryPut(Class<?> input, TypeToken<?> output, Converter<?, ?> converter) {
        tryPut(TypeToken.of(input), output, converter);
    }

    private void tryPut(TypeToken<?> input, Class<?> output, Converter<?, ?> converter) {
        tryPut(input, TypeToken.of(output), converter);
    }

    @edu.umd.cs.findbugs.annotations.SuppressWarnings("RV_RETURN_VALUE_OF_PUTIFABSENT_IGNORED")
    private void tryPut(TypeToken<?> input, TypeToken<?> output, Converter<?, ?> converter) {
        mapping.putIfAbsent(Key.of(input, output), converter);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <I, O> Converter<I, O> find(TypeToken<? super I> input, TypeToken<O> output) {
        return (Converter<I, O>) mapping.get(Key.of(input, output));
    }

}
