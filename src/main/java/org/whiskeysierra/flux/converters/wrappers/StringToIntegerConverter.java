package org.whiskeysierra.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public <V extends String> Integer convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Input");
        return Integer.valueOf(value);
    }

}
