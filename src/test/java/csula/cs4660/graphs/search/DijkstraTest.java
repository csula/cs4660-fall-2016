package csula.cs4660.graphs.search;

import com.google.common.collect.Lists;
import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;
import csula.cs4660.graphs.representations.Representation;
import csula.cs4660.graphs.searches.DijkstraSearch;
import junit.framework.TestCase;

import java.io.File;
import java.util.Arrays;

public class DijkstraTest extends TestCase {
    Graph[] graph1s;
    Graph[] graph2s;

    @Override
    protected void setUp() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file1 = new File(classLoader.getResource("homework-1/graph-1.txt").getFile());
        File file2 = new File(classLoader.getResource("homework-1/graph-2.txt").getFile());

        graph1s = buildGraphs(file1);
        graph2s = buildGraphs(file2);
    }

    private Graph[] buildGraphs(File file) {
        Graph[] graphs = new Graph[3];

        graphs[0] = new Graph(
            Representation.of(
                Representation.STRATEGY.ADJACENCY_LIST,
                file
            )
        );

        graphs[1] = new Graph(
            Representation.of(
                Representation.STRATEGY.ADJACENCY_MATRIX,
                file
            )
        );

        graphs[2] = new Graph(
            Representation.of(
                Representation.STRATEGY.OBJECT_ORIENTED,
                file
            )
        );

        return graphs;
    }

    public void testDijastra1() {
        Arrays.stream(graph1s)
            .forEach(graph -> {
                assertEquals(
                    "Test Dijkstra on graph 1 from Node 1 to 8",
                    Lists.newArrayList(
                        new Edge(new Node(1), new Node(3), 1),
                        new Edge(new Node(3), new Node(10), 1),
                        new Edge(new Node(10), new Node(8), 1)
                    ),
                    graph.search(new DijkstraSearch(), new Node(1), new Node(8))
                );
            });
    }

    public void testDijkstra2() {
        Arrays.stream(graph1s)
            .forEach(graph -> {
                assertEquals(
                    "Test Dijkstra on graph 1 from Node 1 to 10",
                    Lists.newArrayList(
                        new Edge(new Node(1), new Node(3), 1),
                        new Edge(new Node(3), new Node(10), 1)
                    ),
                    graph.search(new DijkstraSearch(), new Node(1), new Node(10))
                );
            });
    }

    public void testDijkstra3() {
        Arrays.stream(graph1s)
            .forEach(graph -> {
                assertEquals(
                    "Test Dijkstra on graph 1 from Node 1 to 5",
                    Lists.newArrayList(
                        new Edge(new Node(1), new Node(2), 1),
                        new Edge(new Node(2), new Node(4), 1),
                        new Edge(new Node(4), new Node(5), 1)
                    ),
                    graph.search(new DijkstraSearch(), new Node(1), new Node(5))
                );
            });
    }

    public void testDijkstra4() {
        Arrays.stream(graph2s)
            .forEach(graph -> {
                assertEquals(
                    "Test Dijkstra on graph 2 from Node 1 to 5",
                    Lists.newArrayList(
                        new Edge(new Node(1), new Node(4), 1),
                        new Edge(new Node(4), new Node(5), 5)
                    ),
                    graph.search(new DijkstraSearch(), new Node(1), new Node(5))
                );
            });
    }

    public void testDijkstra5() {
        Arrays.stream(graph2s)
            .forEach(graph -> {
                assertEquals(
                    "Test Dijkstra on graph 2 from Node 0 to 5",
                    Lists.newArrayList(
                        new Edge(new Node(0), new Node(6), 3),
                        new Edge(new Node(6), new Node(4), 1),
                        new Edge(new Node(4), new Node(5), 5)
                    ),
                    graph.search(new DijkstraSearch(), new Node(0), new Node(5))
                );
            });
    }
}
