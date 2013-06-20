package com.codereligion.flux.converters.io;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;
import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;
import java.nio.charset.Charset;

public final class StringToCharsetConverter implements Converter<String, Charset> {

    @Nullable
    @Override
    public <V extends String> Charset convert(V value, TypeToken<V> input, Capacitor capacitor) {
        return Charset.forName(value);
    }

}
