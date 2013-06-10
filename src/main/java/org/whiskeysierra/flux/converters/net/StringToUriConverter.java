package org.whiskeysierra.flux.converters.net;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.net.URI;
import java.net.URISyntaxException;

public final class StringToUriConverter implements Converter<String, URI> {

    @Nullable
    @Override
    public <V extends String> URI convert(V input, TypeToken<V> type, TypeToken<? extends URI> output, Capacitor capacitor) {
        try {
            return new URI(input);
        } catch (URISyntaxException e) {
            throw new ConversionException(e);
        }
    }

}
