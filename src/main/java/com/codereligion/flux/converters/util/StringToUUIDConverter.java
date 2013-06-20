package com.codereligion.flux.converters.util;

import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.UUID;

public final class StringToUUIDConverter implements Converter<String, UUID> {

    @Nullable
    @Override
    public <V extends String> UUID convert(V value, TypeToken<V> input, Capacitor capacitor) {
        return UUID.fromString(value);
    }

}
