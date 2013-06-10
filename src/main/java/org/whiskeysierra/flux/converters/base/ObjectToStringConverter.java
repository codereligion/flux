package org.whiskeysierra.flux.converters.base;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;

public final class ObjectToStringConverter implements Converter<Object, String> {

    @Override
    public <V extends Object> String convert(@Nullable V input, TypeToken<V> type, TypeToken<? extends String> output,
        Capacitor capacitor) {
        return String.valueOf(input);
    }

}
