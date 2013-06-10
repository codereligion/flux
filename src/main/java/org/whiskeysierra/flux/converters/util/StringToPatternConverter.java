package org.whiskeysierra.flux.converters.util;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.regex.Pattern;

public final class StringToPatternConverter implements Converter<String, Pattern> {

    @Nullable
    @Override
    public <V extends String> Pattern convert(V input, TypeToken<V> type, TypeToken<? extends Pattern> output,
        Capacitor capacitor) {
        return Pattern.compile(input);
    }

}
