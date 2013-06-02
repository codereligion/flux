package org.whiskeysierra.flux.transitive;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

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
    public O convert(I input, TypeToken<I> type, Capacitor capacitor) {
        Object value = input;

        for (Converter<Object, Object> converter : converters) {
            value = converter.convert(, value, , capacitor);
        }

        return cast(value);
    }

}
