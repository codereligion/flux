package org.whiskeysierra.flux.converters.reflect;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;

public final class ReflectBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new StringToClassConverter());
        convert.from(String.class).to(Enum.class).using(new StringToEnumConverter());
    }

}
