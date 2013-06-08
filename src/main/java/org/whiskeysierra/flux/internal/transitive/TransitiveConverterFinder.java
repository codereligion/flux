package org.whiskeysierra.flux.internal.transitive;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.reflect.TypeToken;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.whiskeysierra.flux.Feature;
import org.whiskeysierra.flux.FeatureSet;
import org.whiskeysierra.flux.Key;
import org.whiskeysierra.flux.internal.AbstractConverterFinder;
import org.whiskeysierra.flux.spi.Converter;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class TransitiveConverterFinder extends AbstractConverterFinder {

    // TODO make configurable?!
    private static final int NORMAL_WEIGHT = 1;
    private static final int IMPLICIT_WEIGHT = 3;

    private final Graph<TypeToken<?>, Weighted> graph =
        new DirectedSparseGraph<TypeToken<?>, Weighted>();

    private final DijkstraShortestPath<TypeToken<?>, Weighted> dijkstra =
        new DijkstraShortestPath<TypeToken<?>, Weighted>(graph, Weighted.TRANSFORMER);

    public TransitiveConverterFinder(FeatureSet features, Map<Key<?, ?>, Converter<?, ?>> map) {
        super(features);

        Preconditions.checkNotNull(map, "Map");

        for (Entry<Key<?, ?>, Converter<?, ?>> entry : map.entrySet()) {
            final Key<?, ?> key = entry.getKey();
            final TypeToken<?> input = key.getInput();
            final TypeToken<?> output = key.getOutput();
            final Converter<?, ?> converter = entry.getValue();
            graph.addEdge(Weighted.of(converter, NORMAL_WEIGHT), input, output, EdgeType.DIRECTED);
        }

        if (features.contains(Feature.SUPER_TYPING)) {
            for (Map.Entry<Key<?, ?>, Converter<?, ?>> entry : map.entrySet()) {
                final Key<?, ?> key = entry.getKey();
                tryRegisterOutputSuperTypes(key, entry.getValue());
            }
        }
    }

    private void tryRegisterOutputSuperTypes(Key<?, ?> key, Converter<?, ?> converter) {
        final TypeToken<?> input = key.getInput();
        final TypeToken<?> output = key.getOutput();

        for (TypeToken<?> type : output.getTypes()) {
            graph.addEdge(Weighted.of(converter, IMPLICIT_WEIGHT), input, type, EdgeType.DIRECTED);
        }
    }

    @Override
    protected <I, O> Converter<I, O> find(TypeToken<? super I> input, TypeToken<O> output) {
        if (graph.containsVertex(input) && graph.containsVertex(output)) {
            final List<Weighted> path = dijkstra.getPath(input, output);

            switch (path.size()) {
                case 0:
                    // TODO check if this case even exists
                    return null;
                case 1:
                    return Iterables.getOnlyElement(path).getConverter();
                default:
                    return new CompoundConverter<I, O>(graph, path);
            }
        } else {
            return null;
        }
    }

}
