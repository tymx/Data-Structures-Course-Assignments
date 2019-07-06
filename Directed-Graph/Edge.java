package DiGraph_A5;

public class Edge {
	
	private long id;
	private String label;
	private String source_node;
	private String destination_node;
	private long weight;
	
	public Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		id = idNum;
		label = eLabel;
		source_node = sLabel;
		destination_node = dLabel;
		this.weight = weight;
	}
	
	public Edge(long idNum, String sLabel, String dLabel) {
		id = idNum;
		label = null;
		source_node = sLabel;
		destination_node = dLabel;
		this.weight = 1;
	}

	public long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public String getSource_node() {
		return source_node;
	}

	public String getDestin_node() {
		return destination_node;
	}

	public long getWeight() {
		return weight;
	}
	
}
