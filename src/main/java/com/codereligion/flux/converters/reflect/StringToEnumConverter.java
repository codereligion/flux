package com.codereligion.flux.converters.reflect;

import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;

@SuppressWarnings("rawtypes")
public final class StringToEnumConverter implements Converter<String, Enum> {

    @Nullable
    @Override
    public <V extends String> Enum convert(V value, TypeToken<V> input, Capacitor capacitor) {
        throw new UnsupportedOperationException();
    }

}
