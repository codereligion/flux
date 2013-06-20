package com.codereligion.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.ConversionException;
import com.codereligion.flux.spi.Converter;

public final class StringToCharacterConverter implements Converter<String, Character> {

    @Override
    public <V extends String> Character convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        if (value.length() == 1) {
            return value.charAt(0);
        } else {
            throw new ConversionException(String.format("'%s' can't be converted into a char", value));
        }
    }

}
