package org.whiskeysierra.flux.transitive;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.reflect.TypeToken;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.whiskeysierra.flux.spi.AbstractConverterMapping;
import org.whiskeysierra.flux.spi.Converter;

import java.util.List;

public final class TransitiveConverterMapping extends AbstractConverterMapping {

    private final Graph<TypeToken<?>, Converter<Object, Object>> graph =
        new DirectedSparseGraph<TypeToken<?>, Converter<Object, Object>>();

    private final DijkstraShortestPath<TypeToken<?>, Converter<Object, Object>> dijkstra =
        new DijkstraShortestPath<TypeToken<?>, Converter<Object, Object>>(graph);

    @SuppressWarnings("unchecked")
    private <I, O> Converter<I, O> cast(Converter<?, ?> converter) {
        return (Converter<I, O>) converter;
    }

    @SuppressWarnings("unchecked")
    private <T> TypeToken<T> cast(TypeToken<?> token) {
        return (TypeToken<T>) token;
    }

    @Override
    public <I, O> void register(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter) throws IllegalArgumentException {

        graph.addVertex(input);
        graph.addVertex(output);

        final boolean success = graph.addEdge(cast(converter), input, output, EdgeType.DIRECTED);
        Preconditions.checkArgument(success, "Unable to register %s", converter);
    }

    @Override
    public <I, O> void tryRegister(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter) {
        graph.addVertex(input);
        graph.addVertex(output);

        if (graph.findEdge(input, output) == null) {
            graph.addEdge(cast(converter), input, output, EdgeType.DIRECTED);
        }
    }

    @Override
    public <I, O> void forceRegister(TypeToken<I> input, TypeToken<O> output, Converter<? super I, ? extends O> converter) {
        graph.addVertex(input);
        graph.addVertex(output);

        final Converter<Object, Object> old = graph.findEdge(input, output);

        if (old != null) {
            graph.removeEdge(old);
        }

        graph.addEdge(cast(converter), input, output, EdgeType.DIRECTED);
    }

    @Override
    public <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output) {
        final List<Converter<Object, Object>> path = dijkstra.getPath(input, output);

        if (path.isEmpty()) {
            return null;
        } else if (path.size() == 1) {
            return cast(Iterables.getOnlyElement(path));
        } else {
            return new CompoundConverter<I, O>(path);
        }
    }

}
