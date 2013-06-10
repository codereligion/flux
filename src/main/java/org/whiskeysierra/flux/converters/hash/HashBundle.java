package org.whiskeysierra.flux.converters.hash;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;

public final class HashBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new StringToHashFunctionConverter());
    }

}
