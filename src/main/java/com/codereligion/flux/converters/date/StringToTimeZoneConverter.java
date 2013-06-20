package com.codereligion.flux.converters.date;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;
import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;
import java.util.TimeZone;

public final class StringToTimeZoneConverter implements Converter<String, TimeZone> {

    @Nullable
    @Override
    public <V extends String> TimeZone convert(V value, TypeToken<V> input, Capacitor capacitor) {
        return TimeZone.getTimeZone(value);
    }

}
