package org.whiskeysierra.flux.converters.primitives;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

public final class StringToDoubleConverter implements Converter<String, Double> {

    @Override
    public Double convert(String input, ConversionContext context) {
        return Double.valueOf(input);
    }

}
