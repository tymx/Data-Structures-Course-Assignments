package DiGraph_A5;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node n1, Node n2) {
		// TODO Auto-generated method stub
		if(n1.distance > n2.distance) {
			return 1;
		} 
		if(n1.distance < n2.distance){
			return -1;
		}
		return 0;
	}
	
	
	
}
