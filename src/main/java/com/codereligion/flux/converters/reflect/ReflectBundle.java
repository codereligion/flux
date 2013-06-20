package com.codereligion.flux.converters.reflect;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;

public final class ReflectBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new StringToClassConverter());
        convert.from(String.class).to(Enum.class).using(new StringToEnumConverter());
        convert.using(new StringToTypeTokenConverter());
    }

}
