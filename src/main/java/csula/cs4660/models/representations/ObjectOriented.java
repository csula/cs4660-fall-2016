package csula.cs4660.models.representations;

import csula.cs4660.models.Edge;
import csula.cs4660.models.Node;

import java.io.File;
import java.util.List;

/**
 * Created by eric on 8/27/16.
 */
public class ObjectOriented implements Representation {
    public ObjectOriented(File file) {
    }

    public ObjectOriented() {

    }

    @Override
    public boolean adjacent(Node x, Node y) {
        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
        return null;
    }

    @Override
    public boolean addNode(Node x) {
        return false;
    }

    @Override
    public boolean removeNode(Node x) {
        return false;
    }

    @Override
    public boolean addEdge(Edge x) {
        return false;
    }

    @Override
    public boolean removeEdge(Edge x) {
        return false;
    }

    @Override
    public int distance(Node from, Node to) {
        return 0;
    }
}
