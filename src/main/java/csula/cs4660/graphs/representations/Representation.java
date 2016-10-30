package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Interface to define common behaviors across different representations
 */
public interface Representation {
    enum STRATEGY {
        ADJACENCY_LIST,
        ADJACENCY_MATRIX,
        OBJECT_ORIENTED
    }

    /**
     * Factory pattern to create correct strategy of graph representation
     * @param strategy supported strategies are listed under enum
     * @param file     file to read the contents
     * @return representation from the strategy and file above
     */
    static Representation of(STRATEGY strategy, File file) {
        switch (strategy) {
            case ADJACENCY_LIST:
                return new AdjacencyList(file);
            case ADJACENCY_MATRIX:
                return new AdjacencyMatrix(file);
            case OBJECT_ORIENTED:
                return new ObjectOriented(file);
            default:
                throw new IllegalArgumentException();
        }
    }
    static Representation of(STRATEGY strategy) {
        switch (strategy) {
            case ADJACENCY_LIST:
                return new AdjacencyList();
            case ADJACENCY_MATRIX:
                return new AdjacencyMatrix();
            case OBJECT_ORIENTED:
                return new ObjectOriented();
            default:
                throw new IllegalArgumentException();
        }
    }

    boolean adjacent(Node x, Node y);

    List<Node> neighbors(Node x);

    boolean addNode(Node x);

    boolean removeNode(Node x);

    boolean addEdge(Edge x);

    boolean removeEdge(Edge x);

    int distance(Node from, Node to);

    Optional<Node> getNode(int index);
    Optional<Node> getNode(Node node);

    String toString();
}
