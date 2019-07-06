package SPLT_A4;

import java.util.Random;
import java.util.Scanner;

public class SPLT_Playground {
  public static void main(String[] args){
    //genTest();
	//insertTest1();
	//insertTest2();
	//insertTest4();
	//insertTest5();
	//removeTest1();
	//removeTest5();
	//removeTest3();
	//insertremoveTest1();
	//empty2();
	//createSplay();
    //sizeTest2();
  }
  
  //Oracle Tests
  
  public static void genTest(){
    SPLT tree= new SPLT();
    tree.insert("hello");
    tree.insert("world");
    tree.insert("my");
    tree.insert("name");
    tree.insert("is");
//    tree.insert("blank");
//    tree.remove("hello");
    System.out.println("size is "+tree.size());
    System.out.println("Gen Test: " + checkTree(tree, "blank"));
    printLevelOrder(tree);
    printInOrder(tree.getRoot());	
  }
  
  public static void sizeTest0() {
	  SPLT tree = new SPLT();
	  tree.insert("A");
	  tree.insert("B");
	  System.out.println("Size Test 0: " + checkTree(tree, "B"));
  }
  
  public static void sizeTest1() {
	  SPLT tree = new SPLT();
	  tree.insert("A");
	  tree.insert("B");
	  tree.remove("A");
	  System.out.println("Size Test 1: " + checkTree(tree, "B"));
  }
  
  public static void sizeTest2() {
	  SPLT tree = new SPLT();
	  tree.insert("A");
	  tree.insert("A");
	  System.out.println("Size Test 0: " + checkTree(tree, "A"));
	  printInOrder(tree.getRoot());	
  }
  
  public static void insertTest1() {
	  SPLT tree = new SPLT();
	  tree.insert("C");
	  tree.insert("B");
	  tree.insert("A");
	  System.out.println("Level Order:");
	  printLevelOrder(tree);
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());	  
  }
  
  public static void insertTest2() {
	  System.out.println("\n\nInsert Test 4:");
	  SPLT tree = new SPLT();
	  tree.insert("B");
	  tree.insert("A");
	  tree.insert("D");
	  tree.insert("C");
	  System.out.println("Level Order:");
	  printLevelOrder(tree);
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());	 
  }
  
  public static void insertTest3() {
	  
  }
  
  
  public static void insertTest4() {
	  System.out.println("\nInsert Test 2:");
	  SPLT tree = new SPLT();
	  tree.insert("B");
	  tree.insert("A");
	  tree.insert("D");
	  tree.insert("C");
	  tree.insert("E");
	  tree.insert("0");
	  System.out.println("Level Order:");
	  printLevelOrder(tree);
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());	 
  }
  
  public static void insertTest5() {
	  System.out.println("\n\nInsert Test 5:");
	  SPLT tree = new SPLT();
	  tree.insert("A");
	  //tree.insert("B");
	  //tree.insert("C");
	  tree.insert("A");
	  System.out.println("Size: " + tree.size());
	  System.out.println("Level Order:");
	  printLevelOrder(tree);
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());	 
  }
  
  public static void removeTest5() {
	  SPLT tree = new SPLT();
	  tree.insert("A");
	  tree.insert("B");
	  tree.remove("A");
	  System.out.println("Size: " + tree.size());
	  System.out.println("Level Order:");
	  printLevelOrder(tree);
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());	 
  }
  
  public static void removeTest0() {
	  SPLT tree = new SPLT();
	  tree.insert("0");
	  tree.insert("C");
	  tree.insert("A");
	  tree.insert("B");
	  tree.insert("E");
	  tree.insert("D");
	  tree.remove("C");
	  tree.remove("A");
	  tree.remove("D");
	  System.out.println("Size: " + tree.size());
	  System.out.println("Level Order:");
	  printLevelOrder(tree);
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());	 
  }
  
  public static void removeTest1() {
	  SPLT tree = new SPLT();
	  tree.insert("B");
	  tree.insert("A");
	  tree.insert("C");
	  tree.remove("C");
	  System.out.println(checkTree(tree, "B"));
	  System.out.println("Size: " + tree.size());
	  System.out.println("Level Order:");
	  printLevelOrder(tree);
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());	 
  }
  
  public static void removeTest6() {
	  SPLT tree = new SPLT();
	  tree.insert("E");
	  tree.insert("C");
	  tree.insert("F");
	  tree.insert("B");
	  tree.insert("D");
	  tree.remove("D");
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());	
  }
  
  public static void removeTest3() {
	  SPLT tree = new SPLT();
	  tree.insert("C");
	  tree.insert("D");
	  tree.insert("B");
	  tree.insert("F");
	  tree.insert("E");
	  tree.remove("C");
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());	
  }
  
  
  
  public static void insertremoveTest1() {
	  SPLT tree = new SPLT();
	  tree.insert("A");
	  tree.remove("A");
	  tree.insert("B");
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());
  }
  
  public static void empty2() {
	  SPLT tree = new SPLT();
	  tree.insert("B");
	  //tree.remove("A");
	  tree.insert("A");
	  tree.insert("D");
	  tree.insert("C");
	  tree.insert("E");
	  tree.insert("0");
//	  tree.remove("B");
//	  tree.remove("A");
	  tree.remove("D");
	  tree.remove("C");
	  tree.insert("D");
//	  tree.remove("E");
	  System.out.println("Size: " + tree.size());
	  System.out.println("Level Order:");
	  printLevelOrder(tree);
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());
  }
  
  //Check Functions
  static boolean checkTree(SPLT tree, String s) {
	  
	  boolean rootCorrect = false;
	  boolean branchCorrect = false;
	  
	  if(tree.getRoot().data.equals(s)) {
		  rootCorrect = true;
	  }
	  if(checkBranch(tree.getRoot())) {
		  branchCorrect = true;
	  }
	  
	  if(rootCorrect && branchCorrect) {
		  return true;
	  }
	  return false;
	  
  }
  
  public static boolean checkBranch(BST_Node node) {
	  
	  boolean value = true;
	  
	  if(node.left == null && node.right == null) {
		  return value;
	  }
	  if(node.left != null) {
		  if (node.data.compareTo(node.left.data) < 0) {
			  value =  false;
			  return value;		  
		  } else {
			  if(node.left.left != null) {
				  value = checkBranch(node.left.left);
			  } 
			  if(node.left.right != null) {
				  value = checkBranch(node.left.right);
			  }
	  	  }  
	  }
	  if(node.right != null) {
		  if (node.data.compareTo(node.right.data) > 0) {
			  value =  false;
			  return value;		  
		  } else {
			  if(node.right.left != null) {
				  value = checkBranch(node.right.left);
			  } 
			  if(node.right.right != null) {
				  value = checkBranch(node.right.right);
			  }
		  }  
	  }
	  return value;
  }
  
  static void createSplay() {
	  
	  SPLT tree = new SPLT();
	  for(int i = 0; i < 10000; i++) {
		  tree.insert(MyRandom.nextString(1,4));
		  System.out.println("Print Order: " + i + " " + tree.getRoot().data);
	  }
	  System.out.println(checkTree(tree, tree.getRoot().data));
	  System.out.println("Size: " + tree.size());
	  System.out.println("Level Order:");
	  printLevelOrder(tree);
	  System.out.println("\nIn Order: ");
	  printInOrder(tree.getRoot());
	  
	  Scanner scan = new Scanner(System.in);
	  String input = "";
	  
	  while(input != "0") {
		  System.out.println("Enter command: ");
		  input = scan.nextLine();
		  switch(input) {
		  	case "remove":
		  		System.out.println("Which do you want to remove?");
		  		input = scan.nextLine();
		  		if(tree.getRoot() != null) {
		  			tree.remove(input);
		  		}
		  		System.out.println("Level Order:");
				printLevelOrder(tree);
		  		break;
		  	case "contains":
		  		System.out.println("What do you want to find?");
		  		tree.contains(input);
		  		System.out.println(tree.contains(input));
		  		System.out.println("Level Order:");
				printLevelOrder(tree);
		  		break;
		  	case "insert":
		  		System.out.println("What do you want to insert");
		  		input = scan.nextLine();
		  		tree.insert(input);
		  		System.out.println("Level Order:");
				printLevelOrder(tree);
		  		break;
		  	case "print":
		  		System.out.println("\nIn Order: ");
		  		printInOrder(tree.getRoot());
		  		break;
		  	case "findMin":
		  		tree.findMin();
		  		System.out.println("Level Order:");
				printLevelOrder(tree);
				break;
		  	case "findMax":
		  		tree.findMax();
		  		System.out.println("Level Order:");
				printLevelOrder(tree);
				break;
		  	case "empty":
		  		System.out.println(tree.empty());
		  		break;
		  	case "size":
		  		System.out.println("Size: " + tree.size());
		  		break;		  		
		  	default:
		  		System.out.println("Goodbye");
		  		break;
		  }
		  System.out.println();
	  }
	  
	  	  
  }
  
  //Order Functions

  static void printLevelOrder(SPLT tree){ 
    //will print your current tree in Level-Order...Requires a correct height method
    //https://en.wikipedia.org/wiki/Tree_traversal
	  if(tree.getRoot() == null) {
		  return;
	  }
      int h=tree.getRoot().getHeight();
      for(int i=0;i<=h;i++){
        System.out.print("Level "+i+":");
        printGivenLevel(tree.getRoot(), i);
        System.out.println();
      }
    }
    static void printGivenLevel(BST_Node root,int level){
      if(root==null)return;
      String pare = root.par != null ? root.par.data : "none";
      if(level==0)System.out.print(root.data+" " + " (child of " + pare + ") ");
      else if(level>0){
        printGivenLevel(root.left,level-1);
        printGivenLevel(root.right,level-1);
      }
    }
   static void printInOrder(BST_Node root){
      if(root!=null){
      printInOrder(root.getLeft());
      System.out.print(root.getData()+" ");
      printInOrder(root.getRight());
      }
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
   
   public static void test() {
	   double s = 0.0;
	   int i = 0;
	   while (s != 1.0) {
	     s += 0.04;
	     i += 1;
	   }
	   System.out.println(i);
	 }
  
}