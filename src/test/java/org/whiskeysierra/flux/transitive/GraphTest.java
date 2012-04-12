package org.whiskeysierra.flux.transitive;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.junit.Test;

import java.util.List;

public final class GraphTest {

    @Test
    public void test() {
        final Graph<Integer, String> graph = new SparseMultigraph<Integer, String>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge("Edge-A", 1, 3);
        graph.addEdge("Edge-B", 2, 3, EdgeType.DIRECTED);
        graph.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
        graph.addEdge("Edge-P", 2, 3);
        graph.addEdge("Edge-K", 3, 4, EdgeType.DIRECTED);

        System.out.println("The graph g2 = " + graph);

        final DijkstraShortestPath<Integer, String> dijkstra = new DijkstraShortestPath<Integer, String>(graph);
        final List<String> path = dijkstra.getPath(1, 4);

        System.out.println("The shortest unweighted path from" + 1 + " to " + 4 + " is:");
        System.out.println(path.toString());
    }

}
