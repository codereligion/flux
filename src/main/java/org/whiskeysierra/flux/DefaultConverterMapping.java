package org.whiskeysierra.flux;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;

import java.util.Map;

public final class DefaultConverterMapping extends AbstractConverterMapping {

    private final Map<ConversionKey<?, ?>, Converter<?, ?>> map;

    public DefaultConverterMapping() {
        this(Maps.<ConversionKey<?, ?>, Converter<?, ?>>newHashMap());
    }

    public DefaultConverterMapping(Map<ConversionKey<?, ?>, Converter<?, ?>> map) {
        this.map = map;
    }

    @Override
    public <I, O> void register(TypeToken<I> input, TypeToken<O> output, Converter<I, O> converter) {
        final ConversionKey<I, O> key = ConversionKey.of(input, output);
        final Converter<?, ?> old = map.get(key);
        Preconditions.checkState(old == null, "A binding for %s already existed: %s", key, old);
        map.put(key, converter);
    }

    @Override
    public <I, O> void tryRegister(TypeToken<I> input, TypeToken<O> output, Converter<I, O> converter) {
        final ConversionKey<I, O> key = ConversionKey.of(input, output);
        final Converter<?, ?> old = map.get(key);
        if (old == null) return;
        map.put(key, converter);
    }

    @SuppressWarnings("unchecked")
    public <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output) {
        return (Converter<I, O>) map.get(ConversionKey.of(input, output));
    }

}
