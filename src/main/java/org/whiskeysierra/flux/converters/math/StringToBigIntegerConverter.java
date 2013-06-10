package org.whiskeysierra.flux.converters.math;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import java.math.BigInteger;

public final class StringToBigIntegerConverter implements Converter<String, BigInteger> {

    @Override
    public <V extends String> BigInteger convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Input");
        return new BigInteger(value);
    }

}
