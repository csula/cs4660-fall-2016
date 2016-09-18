package csula.cs4660.graphs.representations;

import csula.cs4660.graphs.Edge;
import csula.cs4660.graphs.Node;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import java.util.Scanner;

/**
 * Object oriented representation of graph is using OOP approach to store nodes
 * and edges
 *
 * TODO: Please fill the body of methods in this class
 */
public class ObjectOriented implements Representation {
    private Collection<javax.xml.soap.Node> nodes;
    private Collection<com.sun.javafx.geom.Edge> edges;

    public ObjectOriented(File file) {
    	try{
    		Scanner in = new Scanner(file);
    		int size = in.nextInt();
    		nodes = new ArrayList<Node>();
    		edges = new ArrayList<Edge>();
    		
    		while(in.hasNextLine()){
    			String line = in.nextLine();
    			String[] split = line.split(':');
    			int from = Integer.parseInt(split[0]);
    			int to = Integer.parseInt(split[1]);
    			int value = Integer.parseInt(split[2]);
    			nodes.add(new Node(from));
    			edges.add(new Edge(new Node(from), new Node(to), value));
    		}
    	}
    	catch(Exception e){
    		System.out.println("File not Found!");
    		e.printStackTrace();
    	}
    }

    public ObjectOriented() {
    	
    }

    @Override
    public boolean adjacent(Node x, Node y) {
    	if(!(nodes.contains(x) || !(nodes.contains(y)))){
    		return false;
    	}
    	else{
    		for(Edge e: edges){
    			if((e.getTo() == y && e.getFrom() == x) || (e.getTo() == x && e.getFrom == y)){
    				return true;
    			}
    		}
    	}
    	return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
    	ArrayList<Node> neigh = new ArrayList<Node>();
        for (Edge e : edges) {
            Node to = e.getTo();
            if (e.getFrom().equals(x)) {
                neigh.add(t);
            }
        }
        return neigh;
    }

    @Override
    public boolean addNode(Node x) {
    	if (nodes.contains(x)) 
            return false;
        nodes.add(x);
        return true;
    }

    @Override
    public boolean removeNode(Node x) {
    	if (nodes.contains(x)) {
    		for (Node n: nodes){
    			if (n.equals(x)){
    				for (Edge e: edges){
    					if(e.getTo() == x || e.getFrom() == x)
    						edges.remove(e);
    				}
    				nodes.remove(e);
    			}
    		}
            return true;
    	}
        return false;
    }

    @Override
    public boolean addEdge(Edge x) {
    	if(!nodes.contains(x.getFrom) || !nodes.contains(x.getTo) || edges.contains(x))
    		return false;
    	edges.add(x);
    	return true;
    }

    @Override
    public boolean removeEdge(Edge x) {
    	if(!nodes.contains(x.getFrom) || !nodes.contains(x.getTo) || !edges.contains(x))
    		return false;
    	edges.remove(x);
    	return false;
    }

    @Override
    public int distance(Node from, Node to) {
    	for (Edge e: edges){
    		if(e.getFrom().equals(from) && e.getTo().equals(to))
    			return e.getValue();
    	}
        return 0;
    }

    @Override
    public Optional<Node> getNode(int index) {
        return null;
    }
}
