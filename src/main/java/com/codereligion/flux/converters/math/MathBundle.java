package com.codereligion.flux.converters.math;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;

public final class MathBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new StringToBigDecimalConverter());
        convert.using(new StringToBigIntegerConverter());
    }

}
