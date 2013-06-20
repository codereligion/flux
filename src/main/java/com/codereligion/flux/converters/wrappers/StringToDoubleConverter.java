package com.codereligion.flux.converters.wrappers;

import com.codereligion.flux.Capacitor;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.spi.Converter;

public final class StringToDoubleConverter implements Converter<String, Double> {

    @Override
    public <V extends String> Double convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        return Double.valueOf(value);
    }

}
