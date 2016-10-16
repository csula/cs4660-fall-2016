package csula.cs4660.graphs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import csula.cs4660.graphs.representations.Representation;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class AdjacencyListTest {
    private Graph graph1;
    private Graph graph2;

    @Before
    public void setup() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file1 = new File(classLoader.getResource("homework-1/graph-1.txt").getFile());
        File file2 = new File(classLoader.getResource("homework-1/graph-2.txt").getFile());

        graph1 = new Graph(
            Representation.of(
                Representation.STRATEGY.ADJACENCY_LIST,
                file1
            )
        );

        graph2 = new Graph(
            Representation.of(
                Representation.STRATEGY.ADJACENCY_LIST,
                file2
            )
        );
    }

    @Test
    public void testGraph1Adjacent() {
        assertTrue(
            "Test graph 1 if node 1 connecting to node 2",
            graph1.adjacent(new Node(1), new Node(2))
        );
        assertTrue(
            "Test graph 1 if node 3 connecting to 2",
            graph1.adjacent(new Node(3), new Node(6))
        );
        assertTrue(
            "Test graph 1 if node 3 connecting to 10",
            graph1.adjacent(new Node(3), new Node(10))
        );

        assertFalse(
            "Test graph 1 if node 1 is not connecting to 6",
            graph1.adjacent(new Node(1), new Node(6))
        );
        assertFalse(
            "Test graph 1 if node 4 is not connecting to 9",
            graph1.adjacent(new Node(4), new Node(9))
        );
    }

    @Test
    public void testGraph1Neighbors() {
        assertEquals(
            "Test graph 1 neighbors for node 1",
            Lists.newArrayList(new Node(2), new Node(3)),
            graph1.neighbors(new Node(1))
        );
        assertEquals(
            "Test graph 1 neighbors for node 4",
            Lists.newArrayList(new Node(5), new Node(7)),
            graph1.neighbors(new Node(4))
        );
        assertEquals(
            "Test graph 1 neighbors for node 10",
            Lists.newArrayList(new Node(0)),
            graph1.neighbors(new Node(5))
        );
    }

    @Test
    public void testGraph1AddNode() {
        assertFalse(
            "Test graph 1 adding exiting node, should return false",
            graph1.addNode(new Node(1))
        );
        assertFalse(
            "Test graph 1 adding exiting node, should return false",
            graph1.addNode(new Node(6))
        );

        assertTrue(
            "Test graph 1 adding new node should return true",
            graph1.addNode((new Node(11)))
        );
    }

    @Test
    public void testGraph1RemoveNode() {
        assertTrue(
            "Test graph 1 remove exiting node, should return true",
            graph1.removeNode(new Node(6))
        );

        // test state of graph
        assertEquals(
            "Test graph 1 after removing node 1, node 9 should not have any neighbor",
            Lists.newArrayList(),
            graph1.neighbors(new Node(9))
        );

        assertFalse(
            "Test graph 1 remove non-exist node, should return false",
            graph1.removeNode(new Node(1234))
        );
    }

    @Test
    public void testGraph1AddEdge() {
        assertTrue(
            "Test graph 1 adding new edge from node 1 to 4",
            graph1.addEdge(new Edge(new Node(1), new Node(4), 1))
        );

        assertEquals(
            "Test graph 1 after adding edge from 1 to 4, node 1 should have 2, 3, 4 as neighbors",
            Lists.newArrayList(new Node(2), new Node(3), new Node(4)),
            graph1.neighbors(new Node(1))
        );

        assertTrue(
            "Test graph 1, node 1 and node 4 should be adjacent now",
            graph1.adjacent(new Node(1), new Node(4))
        );

        assertFalse(
            "If adding existing edge, it should return false",
            graph1.addEdge(new Edge(new Node(1), new Node(2), 1))
        );
    }

    @Test
    public void testGraph1RemoveEdge() {
        assertFalse(
            "Removing non-existing edge should return false",
            graph1.removeEdge(new Edge(new Node(1), new Node(6), 1))
        );

        assertTrue(
            "Test graph 1 remove edge from 6 to 5",
            graph1.removeEdge(new Edge(new Node(6), new Node(5), 1))
        );

        assertFalse(
            "Test graph 1, node 5 and 6 should not be adjacent now",
            graph1.adjacent(new Node(5), new Node(6))
        );
    }

    @Test
    public void testGraph2Adjacent() {
        assertTrue(
            "Test graph 2 adjacent on node 1 to 2",
            graph2.adjacent(new Node(1), new Node(2))
        );

        assertTrue(
            "Test graph 2 adjacent on node 4 to 5",
            graph2.adjacent(new Node(4), new Node(5))
        );

        assertFalse(
            "Test graph 2 adjacent on node 1 to 5, should be false",
            graph2.adjacent(new Node(1), new Node(5))
        );
    }

    @Test
    public void testGraph2Neighbors() {
        assertEquals(
            "Test graph 2 neighbors for node 0",
            Lists.newArrayList(new Node(1), new Node(3), new Node(6)),
            graph2.neighbors(new Node(0))
        );

        assertEquals(
            "Test graph 2 neighbors on node 5, should be empty",
            Lists.newArrayList(),
            graph2.neighbors(new Node(5))
        );
    }
}
