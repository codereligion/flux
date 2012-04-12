package org.whiskeysierra.flux.converters.primitives;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

public final class StringToCharacterConverter implements Converter<String, Character> {

    @Override
    public Character convert(String input, ConversionContext context) {
        if (input.length() == 1) {
            return input.charAt(0);
        } else {
            context.post("%s.length was %s", input, input.length());
            return null;
        }
    }

}
