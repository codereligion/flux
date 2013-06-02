package org.whiskeysierra.flux.converters.primitives;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToShortConverter implements Converter<String, Short> {

    @Override
    public <V extends String> Short convert(V input, TypeToken<V> type, Capacitor capacitor) {
        Preconditions.checkNotNull(input, "Input");
        return Short.valueOf(input);
    }

}
