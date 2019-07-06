package DiGraph_A5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;


public class DiGraph implements DiGraphInterface {

	// in here go all your data and methods for the graph
	
	private HashMap<String, Node> nodes = new HashMap<>();
	private HashMap<Long, Node> nodes_id = new HashMap<>();
	private HashMap<Long, Edge> edges = new HashMap<>();
	private long nodeSize;
	private long edgeSize;

	public DiGraph ( ) { // default constructor
	// explicitly include this
	// we need to have the default constructor
	// if you then write others, this one will still be there
	}

	@Override
	public boolean addNode(long idNum, String label) {
		
		if(idNum < 0 || label == null) {
			return false;
		}
		
		if(nodes.containsKey(label)) {
			return false;
		}
		if(nodes_id.containsKey(idNum)){
			return false;
		}
		
		nodes.put(label, new Node(idNum, label));
		nodes_id.put(idNum, new Node(idNum, label));
		nodeSize++;
		
		return true;
	}
	
	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		
		boolean source_found = false;
		boolean destin_found = false;
		boolean both_found = false;
		
		if(idNum < 0) {
			return false;
		}
		
		if(edges.containsKey(idNum)) {
			return false;
		}
		
		if(nodes.containsKey(sLabel)) {
			source_found = true;
		}
		
		if(nodes.containsKey(dLabel)) {
			destin_found = true;
		}
		
		if(!(source_found & destin_found)) {
			return false;
		}
		
		if(nodes.get(sLabel).getDestin_edges().containsKey(dLabel)) {
			both_found = true;
		}
		
		if(both_found) {
			return false;
		}
		
		nodes.get(sLabel).addNodeEdge(idNum, sLabel, dLabel, weight, eLabel);
		nodes.get(dLabel).addNodeEdge(idNum, sLabel, dLabel, weight, eLabel);
		
		edges.put(idNum, new Edge(idNum, sLabel, dLabel, weight, eLabel));
		edgeSize++;
				
		return true;
	}

	@Override
	public boolean delNode(String label) {
		
		boolean found = false; 
	
		if(nodes.containsKey(label)) {
			found = true;
		}
		
		if(found) {			
			for(Edge e : nodes.get(label).getSource_edges().values()) {
				edges.remove(e.getId());
				nodes.get(e.getSource_node()).getDestin_edges().remove(label);
				edgeSize--;
			}
			for(Edge e : nodes.get(label).getDestin_edges().values()) {
				edges.remove(e.getId());
				nodes.get(e.getDestin_node()).getSource_edges().remove(label);
				edgeSize--;
			}

			//Remove node
			nodes_id.remove(nodes.get(label).getId());
			nodes.remove(label);
			nodeSize--;
		}
		
		return found;
	}
	
	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		
		boolean found = false;
		
		if(nodes.containsKey(sLabel)) {
			if(nodes.get(sLabel).getDestin_edges().containsKey(dLabel)) {
				found = true;
				edges.remove(nodes.get(sLabel).getDestin_edges().get(dLabel).getId());
				nodes.get(sLabel).delNodeEdges(sLabel, dLabel);
				nodes.get(dLabel).delNodeEdges(sLabel, dLabel);
				edgeSize--;
			}
		}		
		return found;
	}

	@Override
	public long numNodes() {
		return nodeSize;
	}
	
	@Override
	public long numEdges() {
		return edgeSize;
	}
	
	@Override
	public ShortestPathInfo[] shortestPath(String label) {
		//Creating the PQUE
		PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
		ShortestPathInfo[] paths = new ShortestPathInfo[(int) nodeSize];
		String node = null;
		int currentSize = 0;
		
		//Find the start node and change the distance to 0.
		node = label;
		nodes.get(label).distance = 0;
		
		//Add the start node to the queue
		queue.add(nodes.get(label));
		
		//While queue is not empty, go through all adjacent nodes until all have been touched.
		while(!queue.isEmpty()) {
			//Remove head of queue and add to array of paths array
			if(!nodes.get(node).finishNode) {
				paths[currentSize++] = new ShortestPathInfo(node, nodes.get(node).distance);
			}
			nodes.get(node).finishNode = true;
			queue.poll();
			
			//Add adjacent nodes to queue if they aren't true
			for(Edge e : nodes.get(node).getDestin_edges().values()) {
				if(!nodes.get(e.getDestin_node()).finishNode) {
					//Change distance if need to
					if(nodes.get(e.getSource_node()).prevNode != null) {
						if(nodes.get(e.getDestin_node()).distance > (e.getWeight() + nodes.get(node).distance)){
							nodes.get(e.getDestin_node()).distance = e.getWeight() + nodes.get(node).distance;
						}
					} else {
						nodes.get(e.getDestin_node()).distance = e.getWeight();
					}                                     
					queue.add(nodes.get(e.getDestin_node()));
					nodes.get(e.getDestin_node()).prevNode = nodes.get(node); 
				}
			}
			if(!queue.isEmpty()) {
				node = queue.peek().getLabel();
			}
		}
		
		for(Node n : nodes.values()) {
			if(!n.finishNode) {
				paths[currentSize++] = new ShortestPathInfo(n.getLabel(), -1);
			}
			n.distance = 1000000;
			n.finishNode = false;
		}
		
		return paths;
	}
	  
  // rest of your code to implement the various operations
	
	public void printGraph(DiGraph d) {
		System.out.println("Nodes:");
		for(String s : d.getNodes().keySet()) {
			System.out.print(s + ", ");
		}
		System.out.println();
		System.out.println("Edges:");
		for(Edge e : d.getEdges().values()) {
			System.out.println(e.getSource_node() + "--- (" + e.getWeight() + ") ---> " + e.getDestin_node());
		}
	}
	
	public HashMap<String, Node> getNodes() {
		return nodes;
	}
	
	public HashMap<Long, Edge> getEdges() {
		return edges;
	}
}