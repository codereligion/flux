package org.whiskeysierra.flux.converters.primitives;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

public final class StringToShortConverter implements Converter<String, Short> {

    @Override
    public Short convert(String input, ConversionContext context) {
        return Short.valueOf(input);
    }

}
