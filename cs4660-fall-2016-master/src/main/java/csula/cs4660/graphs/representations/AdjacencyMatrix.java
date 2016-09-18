package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.util.List;
import java.util.Optional;

import java.util.Scanner;

/**
 * Adjacency matrix in a sense store the nodes in two dimensional array
 *
 * TODO: please fill the method body of this class
 */
public class AdjacencyMatrix implements Representation {
    private com.sun.corba.se.impl.orbutil.graph.Node[] nodes;
    private int[][] adjacencyMatrix;

    public AdjacencyMatrix(File file) {
    	try{
    		Scanner in = new Scanner(file);
    		int size = in.nextInt();
    		nodes = new Node[size];
    		adjacencyMatrix = new int[size][size];
    		for(int i = 0; i<size; i++){
    			nodes[i] = new Node(i);
    			for(int j = 0; j<size; i++)
    				adjacencyMatrix[j][i] = 0;
    		}
    		
    		while(in.hasNextLine()){
    			String line = in.nextLine();
    			String[] split = line.split(':');
    			int from = Integer.parseInt(split[0]);
    			int to = Integer.parseInt(split[1]);
    			int value = Integer.parseInt(split[2]);
    			adjacencyMatrix[from][to] = value;
    		}
    	}
    	catch(Exception e){
    		System.out.println(File Not Found!);
    		e.printStackTrace();
    	}
    }

    public AdjacencyMatrix() {

    }

    @Override
    public boolean adjacent(Node x, Node y) {
    	try{
	    	int a = (int) x.getData();
	    	int b = (int) y.getData();
	    	if(nodes[a] != x || nodes[b] != y)
	    		return false;
	    	if(adjacencyMatrix[a][b] != 0)
	    		return true;
	        return false;
    	}
    	catch(Exception e){
    		System.out.println("Out of Bounds!");
    		e.printStackTrace();
    	}
    }

    @Override
    public List<Node> neighbors(Node x) {
    	try{
	    	int a = (int) x.getData();
	    	ArrayList<Node> neigh = new ArrayList<Node>();
	    	for (int i = 0; i<adjacencyMatrix[a].length; i++)
	    		if(adjacencyMatrix[a][i] != 0)
	    			neigh.add(new Node(i));
	        return neigh;
    	}
    	except(Exception e){
    		System.out.println("Out of Bounds!");
    		e.printStackTrace();
    	}
    }

    @Override
    public boolean addNode(Node x) {
    	int[][] adjMat = new int[adjacencyMatrix.length + 1][adjacencyMatrix[0].length + 1];
        Node[] noodles = new Node[nodes.length + 1];
        int add = (int) x.getData();
        for(int i = 0; i<nodes.length; i++)
        	if (nodes[i] == add)
        		return false;
        
        noodles = Arrays.copyOf(nodes, nodes.length + 1);
        noodles[nodes.length] = x;
        for(int i = 0; i<adjMat.length;i++){
        	adjMat[i] = Arrays.copyOf(adjacencyMatrix[i], adjacencyMatrix[0].length);
        	adjMat[i][adjacencyMatrix[0].length] = 0;
        	if(i == adjacencyMatrix[0].length)
        		for(int j = 0; j<adjMat[0].length;j++)
        			adjMat[i][j];
        }
        adjacencyMatrix = adjMat;
        nodes = noodles;
        return true;
    }

    @Override
    public boolean removeNode(Node x) {
    	int[][] adjMat = new int[adjacencyMatrix.length - 1][adjacencyMatrix[0].length - 1];
        Node[] noodles = new Node[nodes.length - 1];
    	int rem = (int) x.getData();
    	Boolean check = false;
    	for(int i = 0; i<nodes.length; i++)
        	if (nodes[i] == rem)
        		check = true;
    	if(!check)
    		return false;
    	
    	int pI = 0;
    	int pJ = 0;
    	for(int i = 0; i<adjacencyMatrix.length;i++){
    		if(nodes[i] == rem)
    			continue;
    		noodles[pI] = nodes[i];
    		for(int j = 0; j<adjacencyMatrix[0].length;j++){
    			if(nodes[j] == rem)
        			continue;
    			adjMat[pI][pJ] = adjacencyMatrix[i][j];
    			pJ++;
    		}
    		pI++;
    	}
    	
        return true;
    }

    @Override
    public boolean addEdge(Edge x) {
    	Node from = x.getFrom();
    	Node to = x.getTo();
    	for(int i = 0; i < adjacencyMatrix.length; i++){
    		for(int j = 0; j< adjacencyMatrix[0].length; j++){
    			if(adjacencyMatrix[i] == from.getData() && adjacencyMatrix[j] == to.getData()){
    				adjacencyMatrix[i][j] = x.getValue();
    				return true;
    			}
    		}
    	}
        return false;
    }

    @Override
    public boolean removeEdge(Edge x) {
    	Node from = x.getFrom();
    	Node to = x.getTo();
    	for(int i = 0; i < adjacencyMatrix.length; i++){
    		for(int j = 0; j< adjacencyMatrix[0].length; j++){
    			if(adjacencyMatrix[i] == from.getData() && adjacencyMatrix[j] == to.getData()){
    				adjacencyMatrix[i][j] = 0;
    				return true;
    			}
    		}
    	}
        return false;
    }

    @Override
    public int distance(Node from, Node to) {
    	for(int i = 0; i<adjacencyMatrix.length;i++)
    		for(int j = 0; j<adjacencyMatrix.length;j++)
    			if(i == from.getData() && j == from.getData())
    				return adjacencyMatrix[i][j];
        return 0;
    }

    @Override
    public Optional<Node> getNode(int index) {
        return null;
    }
}
