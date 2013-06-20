package com.codereligion.flux.converters.io;

import com.codereligion.flux.Capacitor;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.io.File;

public final class StringToFileConverter implements Converter<String, File> {

    @Nullable
    @Override
    public <V extends String> File convert(V value, TypeToken<V> input, Capacitor capacitor) {
        return new File(value);
    }

}
