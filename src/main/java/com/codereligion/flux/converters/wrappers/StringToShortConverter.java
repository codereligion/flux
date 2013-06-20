package com.codereligion.flux.converters.wrappers;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;

public final class StringToShortConverter implements Converter<String, Short> {

    @Override
    public <V extends String> Short convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        return Short.valueOf(value);
    }

}
