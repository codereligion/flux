package org.whiskeysierra.flux.converters.base;

import com.google.common.base.Charsets;
import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

import javax.annotation.Nullable;
import java.nio.charset.Charset;

public final class ByteArrayToStringConverter implements Converter<byte[], String> {

    private final Charset charset;

    public ByteArrayToStringConverter() {
        this(Charsets.UTF_8);
    }

    public ByteArrayToStringConverter(Charset charset) {
        this.charset = charset;
    }

    @Override
    public String convert(@Nullable byte[] input, ConversionContext context) {
        return new String(input, charset);
    }

}
