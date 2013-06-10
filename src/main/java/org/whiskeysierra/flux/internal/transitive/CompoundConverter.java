package org.whiskeysierra.flux.internal.transitive;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import edu.uci.ics.jung.graph.Graph;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.util.List;

final class CompoundConverter<I, O> implements Converter<I, O> {

    private final Graph<TypeToken<?>, Weighted> graph;
    private final List<Weighted> converters;

    public CompoundConverter(Graph<TypeToken<?>, Weighted> graph,
            List<Weighted> converters) {

        this.graph = Preconditions.checkNotNull(graph, "Graph");
        this.converters = Preconditions.checkNotNull(converters, "Converters");
    }

    @SuppressWarnings("unchecked")
    private <O> O cast(Object value) {
        return (O) value;
    }

    @SuppressWarnings("unchecked")
    private <T> TypeToken<T> cast(TypeToken<?> token) {
        return (TypeToken<T>) token;
    }

    @Nullable
    @Override
    public <V extends I> O convert(V value, TypeToken<V> input, TypeToken<? extends O> output, Capacitor capacitor) {
        return convert(value, capacitor);
    }

    private <V extends I> O convert(V value, Capacitor capacitor) {
        Object v = value;

        for (Weighted weighted : converters) {
            final TypeToken<Object> input = cast(graph.getSource(weighted));
            final TypeToken<Object> output = cast(graph.getDest(weighted));
            final Converter<Object, Object> converter = weighted.getConverter();

            v = converter.convert(v, input, output, capacitor);
        }

        return cast(v);
    }

}
