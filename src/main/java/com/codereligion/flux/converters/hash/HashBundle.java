package com.codereligion.flux.converters.hash;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;

public final class HashBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new StringToHashFunctionConverter());
    }

}
