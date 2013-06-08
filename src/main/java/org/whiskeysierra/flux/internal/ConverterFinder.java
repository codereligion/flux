package org.whiskeysierra.flux.internal;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;

public interface ConverterFinder {

    <I, O> Converter<I, O> search(Class<I> input, Class<O> output);

    <I, O> Converter<I, O> search(Class<I> input, TypeToken<O> output);

    <I, O> Converter<I, O> search(TypeToken<I> input, Class<O> output);

    /**
     *
     * @param input
     * @param output
     * @return
     */
    @Nullable
    <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output);

}
