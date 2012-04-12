package org.whiskeysierra.flux.converters.primitives;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

public final class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String input, ConversionContext context) {
        return Integer.valueOf(input);
    }

}
