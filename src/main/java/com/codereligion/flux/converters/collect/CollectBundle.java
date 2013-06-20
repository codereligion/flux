package com.codereligion.flux.converters.collect;

import com.codereligion.flux.Bundle;
import com.codereligion.flux.Convert;
import com.codereligion.flux.Tokens;
import com.codereligion.flux.Tokens.Wildcard;
import com.codereligion.flux.spi.Converter;
import com.codereligion.flux.Convertable;

import java.util.Map;

public final class CollectBundle implements Bundle {

    @Override
    public void configure(Convert convert) {
        convert.using(new CollectionToConvertableCollectionConverter<Object>());
        convert.using(new IterableToConvertableIterableConverter<Object>());
        convert.using(new ListToConvertableListConverter<Object>());

        @SuppressWarnings({"unchecked", "rawtypes"})
        final Converter<Map<?, ?>, Map<Object, Convertable>> mapConverter = new MapToConvertableMapConverter();
        convert.from(Wildcard.MAP).to(Tokens.forMap(Object.class)).using(mapConverter);
    }

}
