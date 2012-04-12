package org.whiskeysierra.flux.converters.math;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

import java.math.BigDecimal;

public final class StringToBigDecimalConverter implements Converter<String, BigDecimal> {

    @Override
    public BigDecimal convert(String input, ConversionContext context) {
        return new BigDecimal(input);
    }

}
