package org.whiskeysierra.flux.converters.primitives;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToByteConverter implements Converter<String, Byte> {

    @Override
    public <V extends String> Byte convert(V input, TypeToken<V> type, Capacitor capacitor) {
        Preconditions.checkNotNull(input, "Input");
        return Byte.valueOf(input);
    }

}
