package org.whiskeysierra.flux.converters.primitives;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

public final class StringToByteConverter implements Converter<String, Byte> {

    @Override
    public Byte convert(String input, ConversionContext context) {
        return Byte.valueOf(input);
    }

}
