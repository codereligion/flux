package com.codereligion.flux.converters.util;

import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.regex.Pattern;

public final class StringToPatternConverter implements Converter<String, Pattern> {

    @Nullable
    @Override
    public <V extends String> Pattern convert(V value, TypeToken<V> input, Capacitor capacitor) {
        return Pattern.compile(value);
    }

}
