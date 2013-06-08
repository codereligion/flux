package org.whiskeysierra.flux.converters.math;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;

public final class MathBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new StringToBigDecimalConverter());
        convert.using(new StringToBigIntegerConverter());
    }

}
