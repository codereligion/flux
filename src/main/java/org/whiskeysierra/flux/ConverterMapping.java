package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;

public interface ConverterMapping {

    <I, O> void register(Class<I> input, Class<O> output, Converter<I, O> converter);

    <I, O> void register(TypeToken<I> input, TypeToken<O> output, Converter<I, O> converter);

    <I, O> void tryRegister(Class<I> input, Class<O> output, Converter<I, O> converter);

    <I, O> void tryRegister(TypeToken<I> input, TypeToken<O> output, Converter<I, O> converter);

    <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output);

    <I> Converter<I, Object> searchByInput(TypeToken<I> input);

    <O> Converter<Object, O> searchByOutput(TypeToken<O> output);

}
