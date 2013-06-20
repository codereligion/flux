package com.codereligion.flux.converters.reflect;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;
import com.codereligion.flux.spi.Dependency;
import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;

@Dependency(input = String.class, output = Class.class)
@SuppressWarnings("rawtypes")
public final class StringToTypeTokenConverter implements Converter<String, TypeToken> {

    @Nullable
    @Override
    public <V extends String> TypeToken convert(V value, TypeToken<V> input, Capacitor capacitor) {
        final Class<?> type = capacitor.convert(value).to(Class.class);
        return TypeToken.of(type);
    }

}
