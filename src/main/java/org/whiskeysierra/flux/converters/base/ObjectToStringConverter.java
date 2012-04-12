package org.whiskeysierra.flux.converters.base;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

public final class ObjectToStringConverter implements Converter<Object, String> {

    @Override
    public String convert(Object input, ConversionContext context) {
        return input.toString();
    }

}
