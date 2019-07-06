package MinBinHeap_A3;

import java.util.Random;
import java.util.Scanner;

public class MinBinHeap_Playground {
  public static void main(String[] args){   
    //Add more tests as methods and call them here!!
    //TestBuild();
//	  testInsert1();
//	  testDelMin1();
//	  testDelMin2();
//	  testDelMin4();
	  //testGetMin3();
//	  createMBH();
	  
  }
  
  public static void TestBuild(){ 
    // constructs a new minbinheap, constructs an array of EntryPair, 
    // passes it into build function. Then print collection and heap.
    MinBinHeap mbh= new MinBinHeap();
    EntryPair[] collection= new EntryPair[13];
    collection[0]=new EntryPair("b",12);
    collection[1]=new EntryPair("c",3);
    collection[2]=new EntryPair("t",17);
    collection[3]=new EntryPair("e",45);
    collection[4]=new EntryPair("a",0);
    collection[5]=new EntryPair("z",1);
    collection[6]=new EntryPair("g",14);
    collection[7]=new EntryPair("h",9);
    collection[8]=new EntryPair("h",55);
    collection[9]=new EntryPair("h",73);
    collection[10]=new EntryPair("h",5);
    collection[11]=new EntryPair("h",21);
    collection[12]=new EntryPair("h",34);
    printHeapCollection(collection);
    mbh.build(collection);
    printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void testInsert1() {
	  MinBinHeap mbh= new MinBinHeap();
	  mbh.insert(new EntryPair("a", 5));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.insert(new EntryPair("b", 4));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.insert(new EntryPair("c", 3));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.insert(new EntryPair("d", 2));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.insert(new EntryPair("e", 1));
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void testDelMin1() {
	  MinBinHeap mbh= new MinBinHeap();
	  mbh.insert(new EntryPair("a", 5));
	  mbh.insert(new EntryPair("b", 4));
	  mbh.insert(new EntryPair("c", 3));
	  mbh.insert(new EntryPair("d", 2));
	  mbh.insert(new EntryPair("e", 1));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void testDelMin2() {
 	  MinBinHeap mbh= new MinBinHeap();
	  mbh.insert(new EntryPair("a", 1));
	  mbh.insert(new EntryPair("b", 2));
	  mbh.insert(new EntryPair("c", 3));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void testDelMin4() {
	  MinBinHeap mbh= new MinBinHeap();
	  mbh.insert(new EntryPair("a", 4));
	  mbh.insert(new EntryPair("b", 1));
	  mbh.insert(new EntryPair("c", 2));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.insert(new EntryPair("d", 0));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.insert(new EntryPair("c", 3));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.insert(new EntryPair("c", 7));
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.insert(new EntryPair("g", 0));
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void testGetMin3() {
	  MinBinHeap mbh= new MinBinHeap();
	  EntryPair[] collection= new EntryPair[6];
	  collection[0]=new EntryPair("b",1);
	  collection[1]=new EntryPair("c",4);
	  collection[2]=new EntryPair("t",2);
	  collection[3]=new EntryPair("e",8);
	  collection[4]=new EntryPair("a",5);
	  collection[5]=new EntryPair("z",7);
	  mbh.build(collection);
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
  //Order Functions
  
  public static void printHeapCollection(EntryPair[] e) { 
    //this will print the entirety of an array of entry pairs you will pass 
    //to your build function.
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=0;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
    //System.out.println("\nLast element: " + e[len].value + ", " + e[len].priority);
  }
  
  static void createMBH() {
	  
	  int arraySize = 9990;
	  MinBinHeap mbh = new MinBinHeap();
	  EntryPair[] collection = new EntryPair[arraySize];
	  for(int i = 0; i < arraySize; i++) {
		  collection[i] = new EntryPair(MyRandom.nextString(1, 4), MyRandom.nextNumber());
//		  System.out.println("Print Order: " + i + 
//				  " Priority: " + collection[i].getPriority() + 
//				  " Value: " + collection[i].getValue());
	  }
	  printHeapCollection(collection);
	  mbh.build(collection);
	  System.out.println("Size: " + mbh.size());
	  printHeap(mbh.getHeap(), mbh.size());
	  
//	  Scanner scan = new Scanner(System.in);
//	  String input = "";
//	  
//	  while(input != "0") {
//		  System.out.println("Enter command: ");
//		  input = scan.nextLine();
//		  switch(input) {
//		  	
//		  }
//		  System.out.println();
//	  }
	  
	  	  
  }
   
   public static class MyRandom {

	   private static Random rn = new Random();
	   
	   public String nextString() {
	 	     return nextString(5, 25);
	   }
	   
	   public static int nextNumber() {
		   return rand(1,9990);
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