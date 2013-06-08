package org.whiskeysierra.flux.internal;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.InputBindingBuilder;
import org.whiskeysierra.flux.Key;
import org.whiskeysierra.flux.OutputBindingBuilder;
import org.whiskeysierra.flux.spi.Converter;

import java.util.Map;

final class DefaultInputBindingBuilder<I> implements InputBindingBuilder<I> {

    private final Map<Key<?, ?>, Converter<?, ?>> mapping;
    private final TypeToken<I> input;

    public DefaultInputBindingBuilder(Map<Key<?, ?>, Converter<?, ?>> mapping, TypeToken<I> input) {
        this.mapping = Preconditions.checkNotNull(mapping, "Mapping");
        this.input = Preconditions.checkNotNull(input, "Input");
    }

    @Override
    public <O> OutputBindingBuilder<I, O> to(Class<O> output) {
        Preconditions.checkNotNull(output, "Output");
        return to(TypeToken.of(output));
    }

    @Override
    public <O> OutputBindingBuilder<I, O> to(TypeToken<O> output) {
        Preconditions.checkNotNull(output, "Output");
        return new DefaultOutputBindingBuilder<I, O>(mapping, input, output);
    }

}
