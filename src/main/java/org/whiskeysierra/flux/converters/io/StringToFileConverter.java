package org.whiskeysierra.flux.converters.io;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.io.File;

public final class StringToFileConverter implements Converter<String, File> {

    @Nullable
    @Override
    public <V extends String> File convert(V input, TypeToken<V> type, TypeToken<? extends File> output, Capacitor capacitor) {
        return new File(input);
    }

}
