package org.whiskeysierra.flux.converters.primitives;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

public final class StringToFloatConverter implements Converter<String, Float> {

    @Override
    public Float convert(String input, ConversionContext context) {
        return Float.valueOf(input);
    }

}
