package com.codereligion.flux.converters.date;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;
import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;
import java.text.SimpleDateFormat;

public final class StringToSimpleDateFormatConverter implements Converter<String, SimpleDateFormat> {

    @Nullable
    @Override
    public <V extends String> SimpleDateFormat convert(V value, TypeToken<V> input, Capacitor capacitor) {
        return new SimpleDateFormat(value);
    }

}
