package com.codereligion.flux.converters.net;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Dependency;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Dependency(input = String.class, output = InetAddress.class)
public final class StringToInetSocketAddressConverter implements Converter<String, InetSocketAddress> {

    private final Pattern pattern = Pattern.compile("^([^:]+):(\\d+)$");

    @Nullable
    @Override
    public <V extends String> InetSocketAddress convert(V value, TypeToken<V> input, Capacitor capacitor) {
        final Matcher matcher = pattern.matcher(value);
        Preconditions.checkArgument(matcher.matches(), "%s does not match %s", value, pattern);
        final InetAddress host = capacitor.convert(matcher.group(1)).to(InetAddress.class);
        final int port = Integer.parseInt(matcher.group(2));
        return new InetSocketAddress(host, port);
    }

}
