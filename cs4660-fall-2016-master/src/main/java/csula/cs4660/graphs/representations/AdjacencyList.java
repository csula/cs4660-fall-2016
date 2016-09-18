package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.Scanner;
/**
 * Adjacency list is probably the most common implementation to store the unknown
 * loose graph
 *
 * TODO: please implement the method body
 */
public class AdjacencyList implements Representation {
    private Map<com.sun.org.apachcom.sun.javafx.geom.Edgelan.internal.xsltc.runtime.Node, Collection<Edge>> adjacencyList;

    public AdjacencyList(File file) {
    	try{
    		Scanner in = new Scanner(file);
    		int size = in.nextInt();
    		adjacencyList = new HashMap<Node, Collection<Edge>>();
    		
    		for(int i = 0; i<size; i++){
    			adjacencyList.put(new Node(i), new ArrayList<Edge>());
    		}
    		
    		while(in.hasNextLine()){
    			String line = in.nextLine();
    			String[] split = line.split(':');
    			int from = Integer.parseInt(split[0]);
    			int to = Integer.parseInt(split[1]);
    			int value = Integer.parseInt(split[2]);
    			
    			adjacencyList.get(new Node(from)).add(new Edge(new Node(from), new Node(to), value));
    			
    		}
    	}
    	catch(Exception e){
    		System.out.println("Can not Find File!");
    		e.printStackTrace();
    	}
    }

    public AdjacencyList() {

    }

    @Override
    public boolean adjacent(Node x, Node y) {
    	if(!adjacencyList.containsKey(x) || !adjacencyList.containsKey(y))
    		return false;
    	for (Edge e :adjacencyList.get(x)){
    		if (e.getTo() == y)
    			return true;
    	}
    	for (Edge e: adjacencyList.get(y)){
    		if(e.getTo() == x)
    			return true;
    	}
        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
        return adjacencyList.get(x);
    }

    @Override
    public boolean addNode(Node x) {
    	if(!adjacencyList.containsKey(x)){
    		adjacencyList.put(x,new ArrayList<Edge>());
    		return true;
    	}
        return false;
    }

    @Override
    public boolean removeNode(Node x) {
    	if(!adjacentList.containsKey(x))
    		return false;
    	adjacencyList.remove(x);
    	ArrayList<Node> rems = new ArrayList<Node>();
    	for(Collection<Edge> c: adjacencyList.values()){
    		for(Edge e: c){
    			if(e.getTo() == x)
    				rems.add(e.getFrom());
    		}
    	}
    	for(Node n: rems){
    		for(Edge e: adjacencyList.get(n)){
    			if(e.getTo() == x)
    				adjacencyList.get(n).remove(e);
    		}
    	}
    	return true;
    }

    @Override
    public boolean addEdge(Edge x) {
    	if(!adjacencyList.containsKey(x.getFrom()))
    		return false;
    	if(adjacencyList.get(x.getFrom()).contains(x))
    		return false;
    	else{
    		adjacencyList.get(x.getFrom().add(x));
    		return true;
    	}
        return false;
    }

    @Override
    public boolean removeEdge(Edge x) {
    	if(!adjacencyList.containsKey(x.getFrom()))
    		return false;
    	if(adjacencyList.get(x.getFrom()).contains(x)){
    		adjacencyList.get(x.getFrom().remove(x);
    		return true;
    	}
        return false;
    }

    @Override
    public int distance(Node from, Node to) {
    	for(Edge e: adjacencyList.get(from))
    		if(e.getTo() == to){
    			return e.getValue();
    		}
        return 0;
    }

    @Override
    public Optional<Node> getNode(int index) {
        return null;
    }
}
