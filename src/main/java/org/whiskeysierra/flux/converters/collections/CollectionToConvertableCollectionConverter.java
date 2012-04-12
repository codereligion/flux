package org.whiskeysierra.flux.converters.collections;

import com.google.common.collect.Collections2;
import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.ConvertableFactory;
import org.whiskeysierra.flux.Converter;

import java.util.Collection;

public final class CollectionToConvertableCollectionConverter implements Converter<Collection<Object>, Collection<Convertable>> {

    private final ConvertableFactory factory;

    public CollectionToConvertableCollectionConverter(ConvertableFactory factory) {
        this.factory = factory;
    }

    @Override
    public Collection<Convertable> convert(Collection<Object> input, ConversionContext context) {
        return Collections2.transform(input, factory.asFunction());
    }

}
