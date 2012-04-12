package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;

public interface ConverterMapping {

    <I, O> void register(Converter<I, O> converter) throws IllegalArgumentException;

    <I, O> void tryRegister(Converter<I, O> converter);

    <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output);

    <I> Converter<I, Object> searchByInput(TypeToken<I> input);

    <O> Converter<Object, O> searchByOutput(TypeToken<O> output);

}
