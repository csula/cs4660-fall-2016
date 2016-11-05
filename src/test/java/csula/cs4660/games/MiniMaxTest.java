package csula.cs4660.games;

import com.google.common.collect.Lists;
import csula.cs4660.games.models.MiniMaxState;
import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;
import csula.cs4660.graphs.representations.Representation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiniMaxTest {
    private Graph graph = new Graph(Representation.of(Representation.STRATEGY.OBJECT_ORIENTED));

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 7; i ++) {
            graph.addNode(new Node<>(new MiniMaxState(i, 0)));
        }
        graph.addNode(new Node<>(new MiniMaxState(7, -10)));
        graph.addNode(new Node<>(new MiniMaxState(8, 8)));
        graph.addNode(new Node<>(new MiniMaxState(9, 9)));
        graph.addNode(new Node<>(new MiniMaxState(10, 15)));
        graph.addNode(new Node<>(new MiniMaxState(11, 6)));
        graph.addNode(new Node<>(new MiniMaxState(12, 100)));
        graph.addNode(new Node<>(new MiniMaxState(13, -15)));
        graph.addNode(new Node<>(new MiniMaxState(14, -9)));

        graph.addEdge(new Edge(new Node<>(new MiniMaxState(0, 0)), new Node<>(new MiniMaxState(1, 0)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(0, 0)), new Node<>(new MiniMaxState(2, 0)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(1, 0)), new Node<>(new MiniMaxState(3, 0)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(1, 0)), new Node<>(new MiniMaxState(4, 0)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(2, 0)), new Node<>(new MiniMaxState(5, 0)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(2, 0)), new Node<>(new MiniMaxState(6, 0)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(3, 0)), new Node<>(new MiniMaxState(7, -10)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(3, 0)), new Node<>(new MiniMaxState(8, 8)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(4, 0)), new Node<>(new MiniMaxState(9, 9)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(4, 0)), new Node<>(new MiniMaxState(10, 15)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(5, 0)), new Node<>(new MiniMaxState(11, 6)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(5, 0)), new Node<>(new MiniMaxState(12, 100)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(6, 0)), new Node<>(new MiniMaxState(13, -15)), 1));
        graph.addEdge(new Edge(new Node<>(new MiniMaxState(6, 0)), new Node<>(new MiniMaxState(14, -9)), 1));
    }

    @Test
    public void sanityCheck() {
        // just to check if my sanity is still here within the power of OOP
        assertTrue(graph.adjacent(new Node<>(new MiniMaxState(0, 0)), new Node<>(new MiniMaxState(1, 0))));
        assertFalse(graph.adjacent(new Node<>(new MiniMaxState(1, 0)), new Node<>(new MiniMaxState(9, 0))));

        assertEquals(
            Lists.newArrayList(new Node<>(new MiniMaxState(1, 0)), new Node<>(new MiniMaxState(2, 0))),
            graph.neighbors(new Node<>(new MiniMaxState(0, 0)))
        );

        assertEquals(
            new Node<>(new MiniMaxState(0, 0)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(0, 0))).get().getData()).getValue());
    }

    @Test
    public void testGetBestMove() {
        assertEquals(
            (new Node<>(new MiniMaxState(1, 8)).getData()).getValue(),
            ((MiniMaxState) MiniMax.getBestMove(graph, new Node<>(new MiniMaxState(0, 0)), 3, true).getData()).getValue()
        );

        // test after minimax mutate effect
        assertEquals(
            new Node<>(new MiniMaxState(0, 8)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(0, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(1, 8)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(1, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(2, -9)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(2, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(3, 8)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(3, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(4, 15)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(4, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(5, 100)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(5, 0))).get().getData()).getValue()
        );
        assertEquals(
            new Node<>(new MiniMaxState(6, -9)).getData().getValue(),
            ((MiniMaxState) graph.getNode(new Node<>(new MiniMaxState(6, 0))).get().getData()).getValue()
        );
    }
}
