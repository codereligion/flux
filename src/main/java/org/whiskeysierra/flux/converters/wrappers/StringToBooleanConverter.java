package org.whiskeysierra.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToBooleanConverter implements Converter<String, Boolean> {

    @Override
    public <V extends String> Boolean convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Input");
        return Boolean.valueOf(value);
    }

}
