package com.codereligion.flux.converters.base;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;

public final class BaseBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new ObjectToStringConverter());
    }

}
