package org.whiskeysierra.flux.converters.math;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class StringToBigIntegerConverter implements Converter<String, BigInteger> {

    @Override
    public BigInteger convert(String input, ConversionContext context) {
        return new BigInteger(input);
    }

}
