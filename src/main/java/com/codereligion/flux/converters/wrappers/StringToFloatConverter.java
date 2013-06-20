package com.codereligion.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;

public final class StringToFloatConverter implements Converter<String, Float> {

    @Override
    public <V extends String> Float convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        return Float.valueOf(value);
    }

}
