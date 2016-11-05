package csula.cs4660.games;

import csula.cs4660.games.models.MiniMaxState;
import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;
import csula.cs4660.graphs.representations.Representation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphaBetaTest {
    private Graph graph = new Graph(Representation.of(Representation.STRATEGY.OBJECT_ORIENTED));

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 15; i ++) {
            graph.addNode(new Node<>(new MiniMaxState(i, 0)));
        }
        graph.addNode(new Node<>(new MiniMaxState(15, 8)));
        graph.addNode(new Node<>(new MiniMaxState(16, -8)));
        graph.addNode(new Node<>(new MiniMaxState(17, 4)));
        graph.addNode(new Node<>(new MiniMaxState(18, -9)));
        graph.addNode(new Node<>(new MiniMaxState(19, -15)));
        graph.addNode(new Node<>(new MiniMaxState(20, 9)));
        graph.addNode(new Node<>(new MiniMaxState(21, -9)));
        graph.addNode(new Node<>(new MiniMaxState(22, -13)));
        graph.addNode(new Node<>(new MiniMaxState(23, -14)));
        graph.addNode(new Node<>(new MiniMaxState(24, -16)));
        graph.addNode(new Node<>(new MiniMaxState(25, -14)));
        graph.addNode(new Node<>(new MiniMaxState(26, -15)));
        graph.addNode(new Node<>(new MiniMaxState(27, 9)));
        graph.addNode(new Node<>(new MiniMaxState(28, 3)));
        graph.addNode(new Node<>(new MiniMaxState(29, 6)));
        graph.addNode(new Node<>(new MiniMaxState(30, 14)));

        int diff = 1;
        for (int i = 0; i < 7; i ++ ) {
            graph.addEdge(new Edge(new Node<>(new MiniMaxState(i, 0)), new Node<>(new MiniMaxState(i+diff, 0)), 1));
            diff ++;
            graph.addEdge(new Edge(new Node<>(new MiniMaxState(i, 0)), new Node<>(new MiniMaxState(i+diff, 0)), 1));
        }

        graph.addEdge(new Edge(new Node<>(new MiniMaxState(7, 0)), new Node<>(new MiniMaxState(15, 8)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(7, 0)), new Node<>(new MiniMaxState(16, -8)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(8, 0)), new Node<>(new MiniMaxState(17, 4)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(8, 0)), new Node<>(new MiniMaxState(18, -9)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(9, 0)), new Node<>(new MiniMaxState(19, -15)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(9, 0)), new Node<>(new MiniMaxState(20, 9)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(10, 0)), new Node<>(new MiniMaxState(21, -9)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(10, 0)), new Node<>(new MiniMaxState(22, -13)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(11, 0)), new Node<>(new MiniMaxState(23, -14)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(11, 0)), new Node<>(new MiniMaxState(24, -16)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(12, 0)), new Node<>(new MiniMaxState(25, -14)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(12, 0)), new Node<>(new MiniMaxState(26, -15)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(13, 0)), new Node<>(new MiniMaxState(27, 9)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(13, 0)), new Node<>(new MiniMaxState(28, 3)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(14, 0)), new Node<>(new MiniMaxState(29, 6)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(14, 0)), new Node<>(new MiniMaxState(30, 14)), 1));
    }

    @Test
    public void sanityCheck() {
        assertEquals(
            new Node<>(new MiniMaxState(15, 8)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(15, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(29, 6)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(29, 0))).get().getData()).getValue()
        );
    }

    @Test
    public void testGetBestMove() throws Exception {
        assertEquals(
            new Node<>(new MiniMaxState(1, -13)).getData().getValue(),
            ((MiniMaxState) AlphaBeta.getBestMove(graph, new Node<>(new MiniMaxState(0, 0)), 4, Integer.MIN_VALUE, Integer.MAX_VALUE, true).getData()).getValue()
        );

        // check after effect
        assertEquals(
            new Node<>(new MiniMaxState(3, -8)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(3, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(1, -13)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(1, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(2, -14)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(2, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(5, -14)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(5, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(9, -15)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(9, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(6, 0)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(6, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(13, 0)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(13, 0))).get().getData()).getValue()
        );
    }
}
