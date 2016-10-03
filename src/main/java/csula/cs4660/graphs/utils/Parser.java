package csula.cs4660.graphs.utils;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Graph;
import csula.cs4660.graphs.representations.Representation;

import java.io.File;
import java.util.Collection;

/**
 * A quick parser class to read different format of files
 */
public class Parser {
    public static Graph readRectangularGridFile(Representation.STRATEGY graphRepresentation, File file) {
        Graph graph = new Graph(Representation.of(graphRepresentation));
        // TODO: implement the rectangular file read and add node with edges to graph
        return graph;
    }

    public static String converEdgesToAction(Collection<Edge> edges) {
        // TODO: convert a list of edges to a list of action
        return "";
    }
}
