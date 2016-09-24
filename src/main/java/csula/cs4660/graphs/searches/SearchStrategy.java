package csula.cs4660.graphs.searches;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.Node;

import java.util.List;

public interface SearchStrategy {
    public List<Edge> search(Graph graph, Node source, Node dist);
}

