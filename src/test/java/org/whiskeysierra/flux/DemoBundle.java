package org.whiskeysierra.flux;

import org.whiskeysierra.flux.converters.math.StringToBigIntegerConverter;

import java.math.BigInteger;

final class DemoBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.from(String.class).to(BigInteger.class).using(new StringToBigIntegerConverter());
    }

    @Converts
    public boolean parse(int i) {
        return i != 0;
    }

}
