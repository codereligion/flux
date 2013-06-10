package org.whiskeysierra.flux.converters.io;

import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamToBase64StringConverter implements Converter<InputStream, String> {

    private final BaseEncoding encoding = BaseEncoding.base64();

    @Nullable
    @Override
    public <V extends InputStream> String convert(V value, TypeToken<V> input, Capacitor capacitor) {
        try {
            final byte[] bytes = ByteStreams.toByteArray(value);
            return encoding.encode(bytes);
        } catch (IOException e) {
            throw new ConversionException(e);
        }
    }

}
