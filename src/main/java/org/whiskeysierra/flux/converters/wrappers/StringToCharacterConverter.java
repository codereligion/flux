package org.whiskeysierra.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToCharacterConverter implements Converter<String, Character> {

    @Override
    public <V extends String> Character convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Input");
        if (value.length() == 1) {
            return value.charAt(0);
        } else {
            throw new ConversionException(String.format("'%s' can't be converted into a char", value));
        }
    }

}
