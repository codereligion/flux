package org.whiskeysierra.flux.converters.net;

import com.google.common.base.Joiner;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;

public final class StringToInetAddressConverter implements Converter<String, InetAddress> {

    // "0.0.0.0"
    private final String anyLocal = Joiner.on('.').join(Collections.nCopies(4, "0"));

    @Nullable
    @Override
    public <V extends String> InetAddress convert(V input, TypeToken<V> type, TypeToken<? extends InetAddress> output,
        Capacitor capacitor) {
        try {
            return "*".equals(input) ? InetAddress.getByName(anyLocal) : InetAddress.getByName(input);
        } catch (UnknownHostException e) {
            throw new ConversionException(e);
        }
    }

}
