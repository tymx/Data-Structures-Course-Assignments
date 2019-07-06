package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;

public class Node {
	
	private String label;
	private long id;
	//String is the node that it's pointing to
	private HashMap<String, Edge> destin_edges;
	//String is the node the edge is coming from
	private HashMap<String, Edge> source_edges;
	public long distance = 1000000;
	public boolean finishNode = false;
	public Node prevNode = null;

	public Node(long id, String label) {
		this.label = label;
		this.id = id;
		destin_edges = new HashMap<>();
		source_edges = new HashMap<>();
	}
	
	public HashMap<String, Edge> getDestin_edges() {
		return destin_edges;
	}

	public HashMap<String, Edge> getSource_edges() {
		return source_edges;
	}

	public boolean addNodeEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
				
		if(label.equals(dLabel)) {
			source_edges.put(sLabel, new Edge(idNum, sLabel, dLabel, weight, eLabel));
		}
		
		if(label.equals(sLabel)) {
			destin_edges.put(dLabel, new Edge(idNum, sLabel, dLabel, weight, eLabel));
		}
		
		return true;
	}
	
	public Edge delNodeEdges(String sLabel, String dLabel) {
		
		Edge ed = null;
		
		if(source_edges.containsKey(sLabel)) {
			ed = source_edges.get(sLabel);
			source_edges.remove(sLabel);
		}
		
		if(destin_edges.containsKey(dLabel)) {
			ed = destin_edges.get(dLabel);
			destin_edges.remove(dLabel);
		}
		
		return ed;
				
	}

	public String getLabel() {
		return label;
	}

	public long getId() {
		return id;
	}
}
