package org.whiskeysierra.flux.converters.collections;

import com.google.common.collect.Iterables;
import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.ConvertableFactory;
import org.whiskeysierra.flux.Converter;

public final class IterableToConvertableIterableConverter implements Converter<Iterable<Object>, Iterable<Convertable>> {

    private final ConvertableFactory factory;

    public IterableToConvertableIterableConverter(ConvertableFactory factory) {
        this.factory = factory;
    }

    @Override
    public Iterable<Convertable> convert(Iterable<Object> input, ConversionContext context) {
        return Iterables.transform(input, factory.asFunction());
    }

}
