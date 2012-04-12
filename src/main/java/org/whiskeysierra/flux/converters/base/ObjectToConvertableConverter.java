package org.whiskeysierra.flux.converters.base;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.ConvertableFactory;
import org.whiskeysierra.flux.Converter;

public final class ObjectToConvertableConverter implements Converter<Object, Convertable> {

    private final ConvertableFactory factory;

    public ObjectToConvertableConverter(ConvertableFactory factory) {
        this.factory = factory;
    }

    @Override
    public Convertable convert(Object input, ConversionContext context) {
        return factory.transform(input);
    }

}
