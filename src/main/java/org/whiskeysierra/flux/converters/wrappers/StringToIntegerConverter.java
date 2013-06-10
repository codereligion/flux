package org.whiskeysierra.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public <V extends String> Integer convert(V input, TypeToken<V> type, TypeToken<? extends Integer> output,
        Capacitor capacitor) {
        Preconditions.checkNotNull(input, "Input");
        return Integer.valueOf(input);
    }

}
