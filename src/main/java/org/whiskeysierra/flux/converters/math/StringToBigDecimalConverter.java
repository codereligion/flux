package org.whiskeysierra.flux.converters.math;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import java.math.BigDecimal;

public final class StringToBigDecimalConverter implements Converter<String, BigDecimal> {

    @Override
    public <V extends String> BigDecimal convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        return new BigDecimal(value);
    }

}
