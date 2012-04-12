package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;

public abstract class AbstractConverterMapping implements ConverterMapping {

    @Override
    public <I> Converter<I, Object> searchByInput(TypeToken<I> input) {
        return search(input, TypeToken.of(Object.class));
    }

    @Override
    public <O> Converter<Object, O> searchByOutput(TypeToken<O> output) {
        return search(TypeToken.of(Object.class), output);
    }

}
