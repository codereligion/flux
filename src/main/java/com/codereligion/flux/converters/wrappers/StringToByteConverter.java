package com.codereligion.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;

public final class StringToByteConverter implements Converter<String, Byte> {

    @Override
    public <V extends String> Byte convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        return Byte.valueOf(value);
    }

}
