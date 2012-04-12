package org.whiskeysierra.flux.transitive;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.reflect.TypeToken;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.whiskeysierra.flux.AbstractConverterMapping;
import org.whiskeysierra.flux.Converter;

import java.lang.reflect.TypeVariable;
import java.util.List;

public final class TransitiveConverterMapping extends AbstractConverterMapping {

    private final Graph<TypeToken<?>, Converter<Object, Object>> graph =
        new SparseMultigraph<TypeToken<?>, Converter<Object, Object>>();

    @SuppressWarnings("unchecked")
    private <I, O> Converter<I, O> cast(Converter<?, ?> converter) {
        return (Converter<I, O>) converter;
    }

    @SuppressWarnings("unchecked")
    private <T> TypeToken<T> cast(TypeToken<?> token) {
        return (TypeToken<T>) token;
    }

    @Override
    public <I, O> void register(Converter<I, O> converter) throws IllegalArgumentException {
        final TypeToken<?> token = TypeToken.of(converter.getClass()).getSupertype(Converter.class);
        final TypeVariable<Class<Converter>>[] parameters = Converter.class.getTypeParameters();

        final TypeToken<I> input = cast(token.resolveType(parameters[0]));
        final TypeToken<O> output = cast(token.resolveType(parameters[1]));

        graph.addVertex(input);
        graph.addVertex(output);

        final Converter<Object, Object> edge = graph.findEdge(input, output);
        Preconditions.checkState(edge == null, "%s was already configured for %s -> %s", edge, input, output);

        final boolean success = graph.addEdge(cast(converter), input, output, EdgeType.DIRECTED);
        Preconditions.checkState(success, "Unable to register %s", converter);
    }

    @Override
    public <I, O> void tryRegister(Converter<I, O> converter) {
        final TypeToken<?> token = TypeToken.of(converter.getClass()).getSupertype(Converter.class);
        final TypeVariable<Class<Converter>>[] typeParameters = Converter.class.getTypeParameters();

        @SuppressWarnings("unchecked")
        final TypeToken<I> input = (TypeToken<I>) token.resolveType(typeParameters[0]);

        @SuppressWarnings("unchecked")
        final TypeToken<O> output = (TypeToken<O>) token.resolveType(typeParameters[1]);

        graph.addVertex(input);
        graph.addVertex(output);

        if (graph.findEdge(input, output) == null) {
            graph.addEdge(cast(converter), input, output, EdgeType.DIRECTED);
        }
    }

    @Override
    public <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output) {
        final DijkstraShortestPath<TypeToken<?>, Converter<Object, Object>> dijkstra =
            new DijkstraShortestPath<TypeToken<?>, Converter<Object, Object>>(graph);
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
