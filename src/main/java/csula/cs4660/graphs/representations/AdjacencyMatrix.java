package csula.cs4660.graphs.representations;

import com.google.common.collect.Lists;
import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Adjacency matrix in a sense store the nodes in two dimensional array
 */
public class AdjacencyMatrix implements Representation {
    private Node[] nodes;
    private int[][] adjacencyMatrix;

    protected AdjacencyMatrix() {
        nodes = new Node[0];
        adjacencyMatrix = new int[0][0];
    }
    protected AdjacencyMatrix(File file) {
        try {
            Scanner in = new Scanner(file);

            int size = Integer.parseInt(in.nextLine());

            nodes = new Node[size];

            for (int i = 0; i < size; i ++) {
                nodes[i] = new Node<>(i);
            }

            adjacencyMatrix = new int[size][size];

            while (in.hasNextLine()) {
                String line = in.nextLine();
                int[] parts = Arrays.stream(
                    line.split(":")
                ).mapToInt(Integer::parseInt)
                    .toArray();
                Edge edge = new Edge(
                    new Node<>(parts[0]),
                    new Node<>(parts[1]),
                    parts[2]
                );

                addEdge(edge);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean adjacent(Node x, Node y) {
        int indexX = findIndexOfNode(x);
        int indexY = findIndexOfNode(y);

        return !(indexX == -1 || indexY == -1) &&
            adjacencyMatrix[indexX][indexY] != 0;

    }

    @Override
    public List<Node> neighbors(Node x) {
        int index = findIndexOfNode(x);
        List<Node> result = Lists.newArrayList();

        if (index == -1) {
            return result;
        }

        for (int i = 0; i < adjacencyMatrix[index].length; i ++) {
            if (adjacencyMatrix[index][i] != 0) {
                result.add(nodes[i]);
            }
        }

        return result;
    }

    @Override
    public boolean addNode(Node x) {
        // if node already exist; return false
        if (findIndexOfNode(x) > -1) {
            return false;
        }

        Node[] copyNodes = new Node[nodes.length + 1];
        int[][] copyAdjacencyMatrix =
            new int[adjacencyMatrix.length + 1][adjacencyMatrix.length + 1];

        // to copy existing nodes to new copy of nodes
        System.arraycopy(nodes, 0, copyNodes, 0, nodes.length);
        nodes = copyNodes;
        nodes[nodes.length - 1] = x;

        // to copy existing values to new adjacency matrix
        System.arraycopy(adjacencyMatrix, 0, copyAdjacencyMatrix, 0, adjacencyMatrix.length);
        // do not need to change anything because int by default is zero

        return true;
    }

    @Override
    public boolean removeNode(Node x) {
        int index = findIndexOfNode(x);
        if (index == -1) {
            return false;
        }

        Node[] copyNodes = new Node[nodes.length - 1];
        int[][] copyAdjacencyMatrix =
            new int[adjacencyMatrix.length - 1][adjacencyMatrix.length - 1];

        // copy nodes to copyNodes
        // maybe convert nodes into ArrayList and remove it
        // then convert list back to array
        int k = 0;
        for (int i = 0 ; i < nodes.length; i ++) {
            if (i == index) {
                continue;
            }
            copyNodes[k] = nodes[i];
            k ++;
        }

        // copy the adjacencyMatrix to copyAdjacencyMatrix
        int row = 0;
        int col = 0;
        for (int i = 0; i < adjacencyMatrix.length; i ++) {
            if (i == index) {
                continue;
            }
            for (int j = 0; j < adjacencyMatrix[i].length; j ++) {
                if (j == index) {
                    continue;
                }
                copyAdjacencyMatrix[row][col] = adjacencyMatrix[i][j];
                col ++;
            }
            col = 0;
            row ++;
        }

        nodes = copyNodes;
        adjacencyMatrix = copyAdjacencyMatrix;

        return true;
    }

    @Override
    public boolean addEdge(Edge x) {
        int row = findIndexOfNode(x.getFrom());
        int col = findIndexOfNode(x.getTo());

        // this is to cover the case that we are adding edge of nodes
        // that do not exist in the adjacencyMatrix or nodes; then
        // we will have to add node manually
        if (row == -1) {
            addNode(x.getFrom());
        }
        if (col == -1) {
            addNode(x.getTo());
        }
        if (row == -1 || col == -1) {
            // reassigning index as necessary
            row = findIndexOfNode(x.getFrom());
            col = findIndexOfNode(x.getTo());
        }

        int existingEdgeValue = adjacencyMatrix[row][col];

        if (existingEdgeValue != 0) {
            return false;
        }

        adjacencyMatrix[row][col] = x.getValue();

        return true;
    }

    @Override
    public boolean removeEdge(Edge x) {
        int indexX = findIndexOfNode(x.getFrom());
        int indexY = findIndexOfNode(x.getTo());

        if (indexX == -1 || indexY == -1) {
            return false;
        }

        if (adjacencyMatrix[indexX][indexY] == 0) {
            return false;
        }

        adjacencyMatrix[indexX][indexY] = 0;

        return true;
    }

    @Override
    public int distance(Node from, Node to) {
        int fromIndex = findIndexOfNode(from);
        int toIndex = findIndexOfNode(to);

        if (fromIndex == -1 || toIndex == -1) {
            return 0;
        }

        return adjacencyMatrix[fromIndex][toIndex];
    }

    @Override
    public Optional<Node> getNode(int index) {
        return null;
    }

    @Override
    public String toString() {
        String result = "nodes: ";
        for (Node node: nodes) {
            result += node.toString() + ", ";
        }

        result += "\nMatrix:\n";

        for (int[] row: adjacencyMatrix) {
            for (int value: row) {
                result += value + " ";
            }
            result += "\n";
        }

        return result;
    }

    private int findIndexOfNode(Node x) {
        int index = -1;

        for (int i = 0; i < nodes.length; i ++) {
            if (nodes[i].equals(x)) {
                index = i;
            }
        }

        return index;
    }
}

