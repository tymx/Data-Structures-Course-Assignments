package BST_A2;

import java.util.Random;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 * 
*/
  
  public static void main(String[]args){

   // you should test your BST implementation in here
   // it is up to you to test it thoroughly and make sure
   // the methods behave as requested above in the interface
  
   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print tree method
   // feel free to use the printLevelOrder method to verify your trees manually
   // or write one you like better
   // you may wish to print not only the node value, and indicators of what
   // nodes are the left and right subtree roots,
   // but also which node is the parent of the current node
	  
//	  firstInsertTest();
//	  oracleTests();
//	  oracleTests2();
//	  exampleInsertTests();
//	  exampleRemoveTests();
//	  feedbackHeightTest();
	  feedbackHeightTest();
	  feedbackIRTest1();
	  System.out.println();
	  feedbackIRTest2();
	  System.out.println();
//	  deleteRootTest();
	  emptyTest();
	  
  }

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order...
  //https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.height();
    System.out.println("Given Level:");
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    System.out.println();
    System.out.println("Order Level:");
    printInOrder(tree.getRoot());
  }
  
  static void printGivenLevel(BST_Node root,int level){
	 if(root==null)return;
	 if(level==0)System.out.print(root.data+" ");
	 else if(level>0){
	   printGivenLevel(root.left,level-1);
	   printGivenLevel(root.right,level-1);
	 }
  }
  static void printInOrder(BST_Node root){
	  //will print your current tree In-Order
	  if(root!=null){
	    printInOrder(root.getLeft());
	    System.out.print(root.getData() + " ");
	    printInOrder(root.getRight());
	  }
  }
  
  static void firstInsertTest() {
  	BST tree = new BST();
  		
  	tree.insert("B");
  	tree.insert("A");
  	tree.insert("D");
  	tree.insert("C");
  	tree.insert("F");
  	tree.insert("E");
//	System.out.println(tree.contains("G"));
	System.out.println(tree.findMin());
//	System.out.println(tree.remove("E"));
	System.out.println("Size: " + tree.size);
	System.out.println("Height: " + tree.height());
	printLevelOrder(tree);
  		
  }
  
  static void oracleTests() {
	  BST tree = new BST();
	  
	  tree.insert("A");
	  tree.insert("B");
//	  tree.insert("E");
//	  tree.insert("D");
	  tree.remove("A"); //inorder 0DE 
	  
	  System.out.println(tree.size());
	  printLevelOrder(tree);
  }
  
  static void oracleTests2() {
	  BST tree = new BST();
	  tree.insert("B");
	  tree.insert("A");
	  tree.insert("D");
	  tree.insert("C");
	  tree.insert("E");
	  printLevelOrder(tree);
//	  tree.remove("B");
//	  tree.remove("A");
//	  tree.remove("D");
//	  tree.remove("C");
	  tree.remove("E");
	  System.out.println(tree.empty()); //returns true
	  printLevelOrder(tree);
  }
  
  static void exampleInsertTests() {
	  BST tree = new BST();
	  tree.insert("");
	  System.out.println("Size after inserting empty string: " + tree.size);
	  tree.insert("");
	  System.out.println("Size after inserting empty string again: " + tree.size);
	  tree.remove("");
	  System.out.println("Size after removing empty string: " + tree.size);
	  tree.insert("I");
	  System.out.println("Size after inserting into empty tree: " + tree.size);
	  tree.insert("A");
	  System.out.println("Size after inserting duplicate string: " + tree.size);
	  tree.insert("M");
	  tree.insert("J");
	  tree.insert("B");
	  tree.insert("P");
	  tree.insert("O");
	  tree.insert("E");
	  System.out.println("Size before inserting duplicate leaf: " + tree.size);
	  tree.insert("M");
	  tree.insert("");
	  tree.insert("");
	  System.out.println("Size after inserting duplicate leaf: " + tree.size);
	  printLevelOrder(tree);
  }
  
  static void feedbackHeightTest() {
	  BST tree = new BST();
	  tree.insert("G");
	  tree.insert("D");
	  tree.insert("I");
	  tree.insert("B");
	  tree.insert("E");
	  tree.insert("H");
	  tree.insert("O");
	  tree.insert("A");
	  tree.insert("C");
	  tree.insert("F");
	  tree.insert("L");
	  tree.insert("U");
	  tree.insert("N");
	  tree.insert("W");
	  tree.insert("M");
	  tree.insert("Z");
	  tree.insert("X");
	  tree.insert("Y");
	  System.out.println("Height: " + tree.height());
  }
  
  static void feedbackIRTest1() {
	  BST tree = new BST();
	  tree.insert("D");
	  tree.insert("B");
	  tree.insert("A");
	  tree.insert("C");
	  tree.remove("D");
	  printLevelOrder(tree);
  }
  
  static void feedbackIRTest2() {
	  BST tree = new BST();
	  tree.insert("A");
	  tree.remove("A");
	  tree.insert("E");
	  tree.insert("B");
	  tree.insert("D");
	  tree.insert("C");
	  tree.remove("E");
	  printLevelOrder(tree);
  }
  
  static void exampleRemoveTests() {
	  BST tree = new BST();
	  
	  tree.insert("L");
	  tree.insert("K");
	  tree.insert("J");
	  tree.insert("I");
	  tree.insert("H");
	  tree.insert("G");
	  tree.insert("F");
	  tree.insert("E");
	  tree.insert("D");
	  tree.insert("C");
	  tree.insert("B");
	  tree.insert("A");
//	  tree.remove("M");
//	  tree.remove("J");
//	  tree.remove("B");
//	  tree.remove("P");
//	  tree.remove("O");
//	  tree.remove("E");
	  printLevelOrder(tree);
	  System.out.println("\nEmpty: " + tree.empty());
	  System.out.println("Size: " + tree.size());
	  System.out.println("Height: " + tree.height());
	  System.out.println("Min: " + tree.findMin());
	  System.out.println("Max: " + tree.findMax());
//	  System.out.println(tree.contains("G"));
//	  System.out.println(tree.root.right.findMin());
//	  System.out.println(tree.root.right.findMax());
  }
  
  static void emptyTest() {
	  BST tree = new BST();
	  tree.insert("B");
	  tree.insert("A");
	  tree.insert("D");
	  tree.insert("C");
	  tree.insert("E");
	  tree.remove("B");
	  tree.remove("A");
	  tree.remove("D");
	  tree.remove("C");
	  tree.remove("E");
	  printLevelOrder(tree);
  }
  
  static void deleteRootTest() {
	  BST tree = new BST();
	  tree.insert("E");
	  tree.insert("C");
	  tree.insert("B");
	  tree.insert("D");
	  tree.insert("G");
	  tree.insert("F");
	  tree.insert("H");
	  tree.remove("E");
	  printLevelOrder(tree);
  }
  
}