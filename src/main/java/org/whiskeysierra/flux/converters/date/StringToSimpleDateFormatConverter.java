package org.whiskeysierra.flux.converters.date;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.text.SimpleDateFormat;

public final class StringToSimpleDateFormatConverter implements Converter<String, SimpleDateFormat> {

    @Nullable
    @Override
    public <V extends String> SimpleDateFormat convert(V input, TypeToken<V> type, TypeToken<? extends SimpleDateFormat> output,
        Capacitor capacitor) {
        return new SimpleDateFormat(input);
    }

}
