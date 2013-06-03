package org.whiskeysierra.flux.spi;

import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;

public interface ConverterMapping {

    <I, O> void register(Converter<I, O> converter) throws IllegalArgumentException;

    <I, O> void register(Class<I> input, Class<O> output, Converter<? super I, ? extends O> converter)
        throws IllegalArgumentException;

    <I, O> void register(Class<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter)
        throws IllegalArgumentException;

    <I, O> void register(TypeToken<I> input, Class<O> output, Converter<? super I, ? extends O> converter)
        throws IllegalArgumentException;

    <I, O> void register(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter)
        throws IllegalArgumentException;

    <I, O> void tryRegister(Converter<I, O> converter);

    <I, O> void tryRegister(Class<I> input, Class<O> output, Converter<? super I, ? extends O> converter);

    <I, O> void tryRegister(Class<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter);

    <I, O> void tryRegister(TypeToken<I> input, Class<O> output, Converter<? super I, ? extends O> converter);

    <I, O> void tryRegister(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter);

    <I, O> void forceRegister(Converter<I, O> converter);

    <I, O> void forceRegister(Class<I> input, Class<O> output, Converter<? super I, ? extends O> converter);

    <I, O> void forceRegister(Class<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter);

    <I, O> void forceRegister(TypeToken<I> input, Class<O> output, Converter<? super I, ? extends O> converter);

    <I, O> void forceRegister(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter);

    <I, O> Converter<I, O> search(Class<I> input, Class<O> output);

    <I, O> Converter<I, O> search(Class<I> input, TypeToken<O> output);

    <I, O> Converter<I, O> search(TypeToken<I> input, Class<O> output);

    /**
     * TODO define if returns null of lazy-evaluating and re-querying live-converter
     *
     * TODO define super-type search for input and sub-type search for output?!
     * i.e. when searching for Integer->Object a valid return would be Number->String
     *
     *
     * @param input
     * @param output
     * @return
     */
    @Nullable
    <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output);

}
