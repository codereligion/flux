package org.whiskeysierra.flux.converters.primitives;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

public final class StringToLongConverter implements Converter<String, Long> {

    @Override
    public Long convert(String input, ConversionContext context) {
        return Long.valueOf(input);
    }

}
