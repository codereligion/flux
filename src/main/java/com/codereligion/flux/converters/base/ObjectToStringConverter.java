package com.codereligion.flux.converters.base;

import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;

public final class ObjectToStringConverter implements Converter<Object, String> {

    @Override
    public <V extends Object> String convert(@Nullable V value, TypeToken<V> input, Capacitor capacitor) {
        return String.valueOf(value);
    }

}
