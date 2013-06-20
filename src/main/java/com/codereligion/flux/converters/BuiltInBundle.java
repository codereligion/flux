package com.codereligion.flux.converters;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;
import com.codereligion.flux.converters.base.BaseBundle;
import com.codereligion.flux.converters.collect.CollectBundle;
import com.codereligion.flux.converters.math.MathBundle;
import com.codereligion.flux.converters.wrappers.StringToWrappersBundle;

public final class BuiltInBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.install(new BaseBundle());
        convert.install(new CollectBundle());
        convert.install(new MathBundle());
        convert.install(new StringToWrappersBundle());
    }

}
