package org.whiskeysierra.flux.converters.reflect;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;

@SuppressWarnings("rawtypes")
public final class StringToEnumConverter implements Converter<String, Enum> {

    @Nullable
    @Override
    public <V extends String> Enum convert(V value, TypeToken<V> input, Capacitor capacitor) {
        throw new UnsupportedOperationException();
    }

}
