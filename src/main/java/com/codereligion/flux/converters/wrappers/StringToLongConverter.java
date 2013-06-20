package com.codereligion.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;

public final class StringToLongConverter implements Converter<String, Long> {

    @Override
    public <V extends String> Long convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        return Long.valueOf(value);
    }

}
