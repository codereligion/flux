package org.whiskeysierra.flux.converters.collections;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.ConvertableFactory;
import org.whiskeysierra.flux.Converter;

import java.util.Map;

public final class MapToConvertableMapConverter<K> implements Converter<Map<K, Object>, Map<K, Convertable>> {

    private final ConvertableFactory factory;

    public MapToConvertableMapConverter(ConvertableFactory factory) {
        this.factory = factory;
    }

    @Override
    public Map<K, Convertable> convert(Map<K, Object> input, ConversionContext context) {
        return factory.transform(input);
    }

}
