package org.whiskeysierra.flux.converters.date;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.Calendar;
import java.util.Date;

public final class DateToCalendarConverter implements Converter<Date, Calendar> {

    @Nullable
    @Override
    public <V extends Date> Calendar convert(V value, TypeToken<V> input, Capacitor capacitor) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        return calendar;
    }

}
