package com.codereligion.flux.internal;

import com.codereligion.flux.Key;
import com.codereligion.flux.OutputBindingBuilder;
import com.codereligion.flux.spi.Converter;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;

import java.util.Map;

final class DefaultOutputBindingBuilder<I, O> implements OutputBindingBuilder<I, O> {

    private final Map<Key<?, ?>, Converter<?, ?>> mapping;
    private final TypeToken<I> input;
    private final TypeToken<O> output;

    public DefaultOutputBindingBuilder(Map<Key<?, ?>, Converter<?, ?>> mapping, TypeToken<I> input, TypeToken<O> output) {
        this.mapping = Preconditions.checkNotNull(mapping, "Mapping");
        this.input = Preconditions.checkNotNull(input, "Input");
        this.output = Preconditions.checkNotNull(output, "Output");
    }

    @Override
    public void using(Converter<I, O> converter) {
        Preconditions.checkNotNull(converter, "Converter");

        // TODO check return value or use ConcurrentMap
        mapping.put(Key.of(input, output), converter);
    }

}
