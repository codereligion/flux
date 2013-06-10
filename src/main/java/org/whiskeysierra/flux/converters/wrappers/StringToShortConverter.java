package org.whiskeysierra.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToShortConverter implements Converter<String, Short> {

    @Override
    public <V extends String> Short convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Input");
        return Short.valueOf(value);
    }

}
