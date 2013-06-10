package org.whiskeysierra.flux.converters.collect;

import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.Tokens;
import org.whiskeysierra.flux.Tokens.Wildcard;
import org.whiskeysierra.flux.spi.Converter;

import java.util.Map;

public final class CollectBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new CollectionToConvertableCollectionConverter<Object>());
        convert.using(new IterableToConvertableIterableConverter<Object>());
        convert.using(new ListToConvertableListConverter<Object>());

        @SuppressWarnings("unchecked")
        final Converter<Map<?, ?>, Map<Object, Convertable>> mapConverter = new MapToConvertableMapConverter();
        convert.from(Wildcard.MAP).to(Tokens.forMap(Object.class)).using(mapConverter);
    }

}
