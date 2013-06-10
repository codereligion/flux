package org.whiskeysierra.flux.converters.io;

import com.google.common.io.ByteStreams;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamToBase64StringConverter implements Converter<InputStream, String> {

    @Nullable
    @Override
    public <V extends InputStream> String convert(V input, TypeToken<V> type, TypeToken<? extends String> output,
        Capacitor capacitor) {
        try {
            final byte[] bytes = ByteStreams.toByteArray(input);
            return DatatypeConverter.printBase64Binary(bytes);
        } catch (IOException e) {
            throw new ConversionException(e);
        }
    }

}
