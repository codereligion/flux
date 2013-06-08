package org.whiskeysierra.flux.converters.primitives;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToLongConverter implements Converter<String, Long> {

    @Override
    public <V extends String> Long convert(V input, TypeToken<V> type, Capacitor capacitor) {
        Preconditions.checkNotNull(input, "Input");
        return Long.valueOf(input);
    }

}