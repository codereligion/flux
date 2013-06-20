package com.codereligion.flux.converters.net;

import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.ConversionException;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.net.URI;
import java.net.URISyntaxException;

public final class StringToURIConverter implements Converter<String, URI> {

    @Nullable
    @Override
    public <V extends String> URI convert(V value, TypeToken<V> input, Capacitor capacitor) {
        try {
            return new URI(value);
        } catch (URISyntaxException e) {
            throw new ConversionException(e);
        }
    }

}
