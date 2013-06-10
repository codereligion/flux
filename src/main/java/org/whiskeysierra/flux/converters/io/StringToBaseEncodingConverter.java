package org.whiskeysierra.flux.converters.io;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.Map;

public final class StringToBaseEncodingConverter implements Converter<String, BaseEncoding> {

    private final Map<String, BaseEncoding> encodings = ImmutableMap.<String, BaseEncoding>builder().
        put("base16", BaseEncoding.base16()).
        put("base32", BaseEncoding.base32()).
        put("base32hex", BaseEncoding.base32Hex()).
        put("base64", BaseEncoding.base64()).
        put("base64url", BaseEncoding.base64Url()).
        build();

    @Nullable
    @Override
    public <V extends String> BaseEncoding convert(V value, TypeToken<V> input, Capacitor capacitor) {
        final BaseEncoding encoding = encodings.get(value);

        if (encoding == null) {
            throw new ConversionException(String.format("Unknown base encoding '%s'", value));
        } else {
            return encoding;
        }
    }

}
