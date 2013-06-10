package org.whiskeysierra.flux.converters.date;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ThreadSafe
public final class Rss20StringToDateConverter implements Converter<String, Date> {

    private final ThreadLocal<DateFormat> format = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        }
    };

    @Nullable
    @Override
    public <V extends String> Date convert(V input, TypeToken<V> type, TypeToken<? extends Date> output, Capacitor capacitor) {
        try {
            return format.get().parse(input);
        } catch (ParseException e) {
            throw new ConversionException(e);
        }
    }

}
