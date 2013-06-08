package org.whiskeysierra.flux.converters.collections;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;

public final class CollectionsBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new IterableToConvertableIterableConverter<Object>());
        convert.using(new MapToConvertableMapConverter<Object, Object>());
    }

}
