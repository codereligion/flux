package org.whiskeysierra.flux.transitive;

import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;

import java.util.List;

final class CompoundConverter<I, O> implements Converter<I, O> {

    private final List<Converter<Object, Object>> converters;

    public CompoundConverter(List<Converter<Object, Object>> converters) {
        this.converters = converters;
    }

    @SuppressWarnings("unchecked")
    private <O> O cast(Object value) {
        return (O) value;
    }

    @Override
    public O convert(I input, ConversionContext context) {
        Object value = input;

        for (Converter<Object, Object> converter : converters) {
            value = converter.convert(value, context);
        }

        return cast(value);
    }

}
