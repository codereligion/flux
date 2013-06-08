package org.whiskeysierra.flux.internal.transitive;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Primitives;
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

// TODO model inheritence in the graph using cast-converters
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
            add(input, output, converter, NORMAL_WEIGHT);
        }

        if (features.contains(Feature.AUTOBOXING)) {
            for (Map.Entry<Key<?, ?>, Converter<?, ?>> entry : map.entrySet()) {
                final Key<?, ?> key = entry.getKey();
                final Class<?> output = key.getOutput().getRawType();

                if (Primitives.allPrimitiveTypes().contains(output)) {
                    final Converter<?, ?> converter = entry.getValue();

                    add(key.getInput(), Primitives.wrap(output), converter, IMPLICIT_WEIGHT);
                }
            }
        }

        if (features.contains(Feature.UNBOXING)) {
            for (Map.Entry<Key<?, ?>, Converter<?, ?>> entry : map.entrySet()) {
                final Key<?, ?> key = entry.getKey();
                final Class<?> output = key.getOutput().getRawType();

                if (Primitives.allWrapperTypes().contains(output)) {
                    final Converter<?, ?> converter = entry.getValue();
                    add(key.getInput(), Primitives.unwrap(output), converter, IMPLICIT_WEIGHT);
                }
            }
        }

        if (features.contains(Feature.SUPER_TYPING)) {
            for (Map.Entry<Key<?, ?>, Converter<?, ?>> entry : map.entrySet()) {
                final Key<?, ?> key = entry.getKey();

                for (TypeToken<?> output : key.getOutput().getTypes()) {
                    add(key.getInput(), output, entry.getValue(), IMPLICIT_WEIGHT);
                }
            }
        }
    }

    private void add(TypeToken<?> input, Class<?> output, Converter<?, ?> converter, int weight) {
        add(input, TypeToken.of(output), converter, weight);
    }

    private void add(TypeToken<?> input, TypeToken<?> output, Converter<?, ?> converter, int weight) {
        graph.addEdge(Weighted.of(converter, weight), input, output, EdgeType.DIRECTED);
    }

    @Override
    protected <I, O> Converter<I, O> find(TypeToken<? super I> input, TypeToken<O> output) {
        if (graph.containsVertex(input) && graph.containsVertex(output)) {
            final List<Weighted> path = dijkstra.getPath(input, output);

            switch (path.size()) {
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
