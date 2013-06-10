package org.whiskeysierra.flux.converters.util;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.UUID;

public final class StringToUuidConverter implements Converter<String, UUID> {

    @Nullable
    @Override
    public <V extends String> UUID convert(V input, TypeToken<V> type, TypeToken<? extends UUID> output, Capacitor capacitor) {
        return UUID.fromString(input);
    }

}
