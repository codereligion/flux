package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;

public abstract class AbstractConverterMapping implements ConverterMapping {

    public <I, O> void register(Class<I> input, Class<O> output, Converter<I, O> converter) {
        register(TypeToken.of(input), TypeToken.of(output), converter);
    }

    public <I, O> void tryRegister(Class<I> input, Class<O> output, Converter<I, O> converter) {
        tryRegister(TypeToken.of(input), TypeToken.of(output), converter);
    }

    public <I> Converter<I, Object> searchByInput(TypeToken<I> input) {
        return search(input, TypeToken.of(Object.class));
    }

    public <O> Converter<Object, O> searchByOutput(TypeToken<O> output) {
        return search(TypeToken.of(Object.class), output);
    }

}
