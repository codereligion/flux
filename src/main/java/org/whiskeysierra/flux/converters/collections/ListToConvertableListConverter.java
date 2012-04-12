package org.whiskeysierra.flux.converters.collections;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.ConvertableFactory;
import org.whiskeysierra.flux.Converter;

import java.util.List;

public final class ListToConvertableListConverter implements Converter<List<Object>, List<Convertable>> {

    private final ConvertableFactory factory;

    public ListToConvertableListConverter(ConvertableFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Convertable> convert(List<Object> input, ConversionContext context) {
        return factory.transform(input);
    }

}
