package org.whiskeysierra.flux.converters.primitives;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToCharacterConverter implements Converter<String, Character> {

    @Override
    public <V extends String> Character convert(V input, TypeToken<V> type, Capacitor capacitor) {
        Preconditions.checkNotNull(input, "Input");
        if (input.length() == 1) {
            return input.charAt(0);
        } else {
            throw new ConversionException(String.format("'%s' can't be converted into a char", input));
        }
    }

}
