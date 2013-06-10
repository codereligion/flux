package org.whiskeysierra.flux.converters.date;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.TimeZone;

public final class StringToTimeZoneConverter implements Converter<String, TimeZone> {

    @Nullable
    @Override
    public <V extends String> TimeZone convert(V input, TypeToken<V> type, TypeToken<? extends TimeZone> output,
        Capacitor capacitor) {
        return TimeZone.getTimeZone(input);
    }

}
