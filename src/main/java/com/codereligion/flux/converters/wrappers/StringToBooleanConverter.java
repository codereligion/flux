package com.codereligion.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;

public final class StringToBooleanConverter implements Converter<String, Boolean> {

    @Override
    public <V extends String> Boolean convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        return Boolean.valueOf(value);
    }

}
