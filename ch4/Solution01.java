package ch4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution01 {
	public static class Node {
		  public List<Node> adjacent;
		  private String vertex;
		  public enum State { Unvisited, Visited, Visiting }
		  public State state;

		  public Node(String vertex) {
		    this.vertex = vertex;
		    adjacent = new ArrayList<Node>();
		  }
		  public void addAdjacent(Node x) {
		    adjacent.add(x);
		  }
		  public int adjacentCount() {
		    return adjacent.size();
		  }
		}
	public static class Graph {
		  public Node vertices[];
		  public int count;
		  
		  public Graph() {
		    count = 0;
		  }

		  public void add(Node x) {
		    vertices[count] = x;
		    count++;
		  }
	}
	public static class RouteBetweenNodes {
		  public static boolean search(Graph g, Node start, Node end) {
		    if (start == end) return true;
		    
		    Queue<Node> queue = new ArrayDeque<Node>();
		    
		    for (Node node : g.vertices) {
		      node.state = Node.State.Unvisited;
		    }
		    
		    start.state = Node.State.Visiting;
		    queue.add(start);
		    Node temp;
		    while (!queue.isEmpty()) {
		      temp = queue.remove();
		      if (temp != null) {
		        for (Node adjacent : temp.adjacent) {
		          if (adjacent.state == Node.State.Unvisited) {
		            if (adjacent == end) {
		              return true;
		            } else {
		              adjacent.state = Node.State.Visiting;
		              queue.add(adjacent);
		            }
		          }
		        }
		      }
		      temp.state = Node.State.Visited;
		    }
		    
		    return false;
		  }
		}
	public static void main(String[] args) {
	    Graph g = new Graph();
	    Node[] nodes = new Node[6];
	   
	    // This graph is taken from page 107
	    nodes[0] = new Node("0");
	    nodes[1] = new Node("1");
	    nodes[2] = new Node("2");
	    nodes[3] = new Node("3");
	    nodes[4] = new Node("4");
	    nodes[5] = new Node("5");

	    nodes[0].addAdjacent(nodes[1]);
	    nodes[0].addAdjacent(nodes[4]);
	    nodes[0].addAdjacent(nodes[5]);
	    nodes[1].addAdjacent(nodes[4]);
	    nodes[1].addAdjacent(nodes[3]);
	    nodes[2].addAdjacent(nodes[1]);
	    nodes[3].addAdjacent(nodes[2]);
	    nodes[3].addAdjacent(nodes[4]);

	    g.vertices = nodes;
	    g.count = 6;

	    System.out.println(RouteBetweenNodes.search(g, nodes[0], nodes[3]));
	    System.out.println(RouteBetweenNodes.search(g, nodes[3], nodes[5]));
	  }
}
