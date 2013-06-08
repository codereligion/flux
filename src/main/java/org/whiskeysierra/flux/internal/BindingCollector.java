package org.whiskeysierra.flux.internal;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Convert;
import org.whiskeysierra.flux.InputBindingBuilder;
import org.whiskeysierra.flux.Key;
import org.whiskeysierra.flux.spi.Converter;

import java.lang.reflect.TypeVariable;
import java.util.Map;

public final class BindingCollector implements Convert {

    private final Map<Key<?, ?>, Converter<?, ?>> mapping = Maps.newHashMap();

    @Override
    public void install(Bundle bundle) {
        Preconditions.checkNotNull(bundle, "Bundle");
        bundle.configure(this);
    }

    @Override
    public <I> InputBindingBuilder<I> from(Class<I> input) {
        Preconditions.checkNotNull(input, "Input");
        return from(TypeToken.of(input));
    }

    @Override
    public <I> InputBindingBuilder<I> from(TypeToken<I> input) {
        Preconditions.checkNotNull(input, "Input");
        return new DefaultInputBindingBuilder<I>(mapping, input);
    }

    @Override
    public <I, O> void using(Converter<I, O> converter) {
        final TypeToken<?> token = TypeToken.of(converter.getClass()).getSupertype(Converter.class);
        final TypeVariable<Class<Converter>>[] typeParameters = Converter.class.getTypeParameters();

        @SuppressWarnings("unchecked")
        final TypeToken<I> input = (TypeToken<I>) token.resolveType(typeParameters[0]);

        @SuppressWarnings("unchecked")
        final TypeToken<O> output = (TypeToken<O>) token.resolveType(typeParameters[1]);

        from(input).to(output).using(converter);
    }

    public Map<Key<?, ?>, Converter<?, ?>> getMapping() {
        return mapping;
    }

}
