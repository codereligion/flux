package org.whiskeysierra.flux.converters;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;
import org.whiskeysierra.flux.converters.base.BaseBundle;
import org.whiskeysierra.flux.converters.collect.CollectBundle;
import org.whiskeysierra.flux.converters.math.MathBundle;
import org.whiskeysierra.flux.converters.wrappers.StringToWrappersBundle;

public final class BuiltInBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.install(new BaseBundle());
        convert.install(new CollectBundle());
        convert.install(new MathBundle());
        convert.install(new StringToWrappersBundle());
    }

}
