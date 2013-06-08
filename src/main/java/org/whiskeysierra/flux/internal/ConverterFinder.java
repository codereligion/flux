package org.whiskeysierra.flux.internal;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;

public interface ConverterFinder {

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
