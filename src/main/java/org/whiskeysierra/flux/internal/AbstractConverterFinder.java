package org.whiskeysierra.flux.internal;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.spi.Converter;

public abstract class AbstractConverterFinder implements ConverterFinder {

    @Override
    public <I, O> Converter<I, O> search(Class<I> input, Class<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return search(TypeToken.of(input), TypeToken.of(output));
    }

    @Override
    public <I, O> Converter<I, O> search(Class<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return search(TypeToken.of(input), output);
    }

    @Override
    public <I, O> Converter<I, O> search(TypeToken<I> input, Class<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return search(input, TypeToken.of(output));
    }

}
