package org.whiskeysierra.flux.converters.net;

import com.google.common.net.InetAddresses;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class StringToInetAddressConverter implements Converter<String, InetAddress> {

    @Nullable
    @Override
    public <V extends String> InetAddress convert(V value, TypeToken<V> input, Capacitor capacitor) {
        if (InetAddresses.isInetAddress(value)) {
            // suppresses dns lookups for ip-based addresses
            return InetAddresses.forString(value);
        } else if ("*".equals(value)) {

            @SuppressWarnings("PMD.AvoidUsingHardCodedIP")
            final String anyLocal = "0.0.0.0";

            return InetAddresses.forString(anyLocal);
        } else {
            try {
                return InetAddress.getByName(value);
            } catch (UnknownHostException e) {
                throw new ConversionException(String.format("'%s' is no valid InetAddress", value));
            }
        }
    }

}
