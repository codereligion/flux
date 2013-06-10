package org.whiskeysierra.flux.converters.io;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.nio.charset.Charset;

public final class StringToCharsetConverter implements Converter<String, Charset> {

    @Nullable
    @Override
    public <V extends String> Charset convert(V input, TypeToken<V> type, TypeToken<? extends Charset> output,
        Capacitor capacitor) {
        return Charset.forName(input);
    }

}
