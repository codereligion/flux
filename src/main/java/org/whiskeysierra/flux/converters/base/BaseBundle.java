package org.whiskeysierra.flux.converters.base;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;

public final class BaseBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new ObjectToStringConverter());
    }

}
