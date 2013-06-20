package com.codereligion.flux.converters.date;

import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.ConversionException;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Rfc822StringToDateConverter implements Converter<String, Date> {

    private final ThreadLocal<DateFormat> format = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US);
        }
    };

    @Nullable
    @Override
    public <V extends String> Date convert(V value, TypeToken<V> input, Capacitor capacitor) {
        try {
            return format.get().parse(value);
        } catch (ParseException e) {
            throw new ConversionException(e);
        }
    }

}
