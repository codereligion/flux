package org.whiskeysierra.flux.converters.collect;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;

public final class CollectBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new IterableToConvertableIterableConverter<Object>());
        convert.using(new MapToConvertableMapConverter<Object, Object>());
    }

}
