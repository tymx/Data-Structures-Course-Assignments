package DiGraph_A5;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
      //exTest();
	  createGraph(exTest());
	  //createGraph(sampleData());
	  //createGraph(creatMillionGraph());
	  //createGraph(shortTest0());
	  //createGraph(shortTest1());
	  //createGraph(shortTest2());
	  //createGraph(shortTest4());
	  //numEdgesTest1();
    }
  
    public static DiGraph exTest(){
      DiGraph d = new DiGraph();
      d.addNode(1, "f");
      d.addNode(3, "s");
      d.addNode(7, "t");
      d.addNode(0, "fo");
      d.addNode(4, "fi");
      d.addNode(6, "si");
      d.addEdge(0, "f", "s", 0, null);
      d.addEdge(1, "f", "si", 0, null);
      d.addEdge(2, "s", "t", 0, null);
      d.addEdge(3, "fo", "fi", 0, null);
      d.addEdge(4, "fi", "si", 0, null);
      return d;
    }
    
    public static void numEdgesTest1() {
    	DiGraph d = new DiGraph();
    	d.addNode(1, "f");
    	d.addNode(3, "s");
    	d.addNode(7, "t");
    	d.addNode(0, "fo");
    	d.addNode(4, "fi");
    	d.addNode(6, "si");
    	d.addEdge(0, "f", "s", 0, null);
    	d.addEdge(1, "f", "si", 0, null);
    	d.addEdge(2, "s", "t", 0, null);
    	d.addEdge(3, "fo", "fi", 0, null);
    	d.addEdge(4, "fi", "si", 0, null);
    	d.delEdge("f", "s");
    	System.out.println(d.numEdges()); 
    }
    
    public static DiGraph shortTest0() {
    	DiGraph d = new DiGraph();
    	d.addNode(1, "a");
    	d.addNode(2, "b");
    	d.addNode(3, "c");
    	d.addEdge(0, "a", "b", 3, null);
    	d.addEdge(1, "b", "c", 4, null);
    	d.addEdge(2, "a", "c", 5, null);
    	return d;
    }
    
    public static DiGraph shortTest1() {
    	DiGraph d = new DiGraph();
    	d.addNode(1, "a");
    	d.addNode(2, "b");
    	d.addNode(3, "c");
    	d.addEdge(0, "a", "b", 3, null);
    	d.addEdge(1, "b", "c", 4, null);
    	d.addEdge(2, "a", "c", 10, null);
    	return d;
    }
    
    public static DiGraph shortTest2() {
    	DiGraph d = new DiGraph();
    	d.addNode(1, "a");
    	d.addNode(2, "b");
    	d.addNode(3, "c");
    	d.addNode(4, "d");
    	d.addEdge(0, "a", "b", 1, null);
    	d.addEdge(1, "b", "c", 2, null);
    	d.addEdge(2, "c", "a", 3, null);
    	d.addEdge(3, "c", "d", 2, null);
    	d.addEdge(4, "d", "b", 1, null);
    	return d;
    }
    
    public static DiGraph shortTest4() {
    	DiGraph d = new DiGraph();
    	d.addNode(0, "0");
    	d.addNode(1, "1");
    	d.addNode(2, "2");
    	d.addNode(3, "3");
    	d.addNode(4, "4");
    	d.addNode(5, "5");
    	d.addNode(6, "6");
    	d.addEdge(0, "4", "5", 2, null);
    	d.addEdge(1, "0", "5", 3, null);
    	d.addEdge(2, "3", "2", 6, null);
    	d.addEdge(3, "6", "1", 4, null);
    	d.addEdge(4, "4", "0", 1, null);
    	return d;
    }
    
    public static DiGraph sampleData() {
    	DiGraph d = new DiGraph();
    	d.addNode(0, "Raliegh");
    	d.addNode(1, "Durham");
    	d.addNode(2, "Pittsboro");
    	d.addNode(3, "Los_angeles");
    	d.addNode(4, "Graham");
    	d.addNode(5, "Cary");
    	d.addNode(6, "Chapel_hill");
    	d.addNode(7, "Hillsborough");
    	d.addNode(8, "Carrboro");
    	d.addNode(9, "Sanford");
    	d.addEdge(0, "Raliegh", "Durham", 14, null);
    	d.addEdge(1, "Durham", "Hillsborough", 9, null);
    	d.addEdge(2, "Chapel_hill", "Graham", 25, null);
    	d.addEdge(3, "Chapel_hill", "Carrboro", 1, null);
    	d.addEdge(4, "Carrboro", "Cary", 32, null);
    	d.addEdge(5, "Cary", "Raliegh", 3, null);
    	d.addEdge(6, "Pittsboro", "Cary", 17, null);
    	d.addEdge(7, "Pittsboro", "Sanford", 15, null);
    	d.addEdge(9, "Sanford", "Los_angeles", 3012, null);
    	return d;
    }
    
    public static void createGraph(DiGraph g) {
    	DiGraph d = g;
    	Scanner s = new Scanner(System.in);
    	String input = "";
    	String sLabel, dLabel, eLabel;
    	int id, weight;
    	boolean done = false;
    	
    	while(!input.equals("0")) {
    		System.out.println("What would you like to do with the graph?");
        	input = s.nextLine();
    		
    		switch(input) {
    			case "add node":
    				System.out.println("What would you like to call it?");
    				input = s.nextLine();
    				System.out.println("What id number would you give it?");
    				id = s.nextInt();
    				s.nextLine();
    				done = (d.addNode(id, input)) ? true : false;
    				if(done) {
    					System.out.println("Node was made!");
    				} else {
    					System.out.println("Oh no . . . something went wrong :(");
    				}
    				break;
    			case "add edge":
    				System.out.println("What would you like to call it?");
    				eLabel = s.nextLine();
    				System.out.println("What id number would you give it?");
    				id = s.nextInt();
    				s.nextLine();
    				System.out.println("Source");
    				sLabel = s.nextLine();
    				System.out.println("Destination: ");
    				dLabel = s.nextLine();
    				System.out.println("Weight: ");
    				weight = s.nextInt();
    				s.nextLine();
    				done = d.addEdge(id, sLabel, dLabel, weight, eLabel) ? true : false;
    				if(done) {
    					System.out.println("Edge was made!");
    				} else {
    					System.out.println("Oh no . . . something went wrong :(");
    				}
    				break;
    			case "del node":
    				System.out.println("Delete which node?");
    				input = s.nextLine();
    				done = d.delNode(input) ? true : false;
    				if(done) {
    					System.out.println("Node was deleted!");
    				} else {
    					System.out.println("Oh no . . . something went wrong :(");
    				}
    				break;
    			case "del edge":
    				System.out.println("Source?");
    				sLabel = s.nextLine();
    				System.out.println("Destination?");
    				dLabel = s.nextLine();
    				done = d.delEdge(sLabel, dLabel) ? true : false;
    				if(done) {
    					System.out.println("Edge was deleted!");
    				} else {
    					System.out.println("Oh no . . . something went wrong :(");
    				}
    				break;
    			case "node size":
    				System.out.println("There are " + d.numNodes() + " nodes in the graph.");
    				break;
    			case "edge size":
    				System.out.println("There are " + d.numEdges() + " edges in the graph.");
    				break;
    			case "shortest path":
    				System.out.println("Start Node?");
    				input = s.nextLine();
    				long startTime = System.currentTimeMillis();
    				ShortestPathInfo[] paths = d.shortestPath(input);
    				long endTime = System.currentTimeMillis();
    				for(ShortestPathInfo p : paths) {
    					if(p.getTotalWeight() != -1) {
    						System.out.println(p.getDest() + " ---> " + p.getTotalWeight());
    					}
    				}
    				System.out.println("Shortest Path Execution time: " + (double)((endTime - startTime) * 0.001) + " seconds");
    				break;
    			case "print nodes":
    				for(Node n : d.getNodes().values()) {
    					System.out.println("Node: " + n.getLabel());
    					System.out.println("\tDestination Edges: ");
    					for(Edge e : n.getDestin_edges().values()) {
    						System.out.print("\t\tNode: " + e.getDestin_node() + "\n\t\tWeight: " + e.getWeight() + "\n");
    					}
    					System.out.println("\tSource Edges: ");
    					for(Edge e : n.getSource_edges().values()) {
    						System.out.print("\t\tNode: " + e.getSource_node() + "\n\t\tWeight: " + e.getWeight() + "\n");
    					}
    				}
    				break;
    			case "print edges":
    				for(Edge e : d.getEdges().values()) {
    					System.out.println("Edge: " + e.getLabel());
    					System.out.print("\tSource Node: " + e.getSource_node() 
    					+ "\n\tDestination Node: " + e.getDestin_node()
    					+ "\n\tWeight: " + e.getWeight() + "\n");
    				}
    				break;
    			case "print graph":
    				d.printGraph(d);
    				break;
    			case "random node":
    				System.out.println("Random Node: " + d.getEdges().get((long)MyRandom.rand(0,999999)).getSource_node());
    				break;
    			default:
    				System.out.println("No one is ever really gone.");
    				break;
    		}
    	}
    }
    
    public static DiGraph creatMillionGraph() {
    	DiGraph d = new DiGraph();
    	ArrayList<String> strings = new ArrayList<>();
    	long startTime = System.currentTimeMillis();
    	for(int i = 0; i < 1000000; i++) {
    		String s = MyRandom.nextString(2, 25);
    		while(d.getNodes().containsKey(s)) {
    			s =  MyRandom.nextString(2, 25);
    		}
    		d.addNode(i, s);
    		strings.add(s);
    	}
    	long endTime = System.currentTimeMillis();
    	System.out.println("Add Node Execution time: " + (double)((endTime - startTime) * 0.001) + " seconds");
    	startTime = System.currentTimeMillis();
    	int sl = 0;
    	int sd = 1;
    	for(int i = 0; i < 1000000; i++) {
//    		int sl = MyRandom.rand(0, 999999);
//    		int sd = MyRandom.rand(0, 999999);
    		if(sd < strings.size()) {
    			d.addEdge(i, strings.get(sl++), strings.get(sd++), MyRandom.rand(1, 2), null);
    		}
    	}
    	endTime = System.currentTimeMillis();
    	System.out.println("Add Edge Execution time: " + (double)((endTime - startTime) * 0.001) + " seconds");
    	System.out.println("Random Node: " + strings.get(MyRandom.rand(0,999999)));
    	return d;	
    }
    
    public static class MyRandom {

 	   private static Random rn = new Random();
 	   
 	   public String nextString() {
 	 	     return nextString(5, 25);
 	   }

 	   public static int rand(int lo, int hi) {
 	      int n = hi - lo + 1;
 	      int i = rn.nextInt() % n;
 	      if (i < 0) i = -i;
 	      return lo + i;
 	   }

 	 public static String nextString(int lo, int hi) {
 	      int n = rand(lo, hi);
 	      int b = 0;
 	      String rep = "";
 	      for (int i = 0; i < n; i++) {
 	     	 b = rand('a', 'z');
 	     	 String ret = Character.toString((char)b);
 	     	 rep = rep.concat(ret);
 	      }
 	      return rep;
 	   }
 	   
 	 }
}