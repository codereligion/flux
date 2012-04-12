package org.whiskeysierra.flux.converters.primitives;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

public final class StringToBooleanConverter implements Converter<String, Boolean> {

    @Override
    public Boolean convert(String input, ConversionContext context) {
        return Boolean.valueOf(input);
    }

}
