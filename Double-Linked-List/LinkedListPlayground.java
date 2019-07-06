package LinkedList_A1;

public class LinkedListPlayground {

  public static void main(String[] args) { 
    /*
     here you can instantiate your LinkedList and play around with it to check
     correctness. We've graciously also provided you a bit of extra test data for debugging.
     It doesn't matter what you have in here. We will not grade it. This is for your use in testing your implementation.
      */
//    test1();
    test2();
//	testOracle();
//	testForErrors();
//	testBigData();
//  insertAllRemoveAll();

  }
  
  public static void test1(){
    // example test cases
    LinkedListImpl L= new LinkedListImpl();
    System.out.println(L.isEmpty()); 
    printList(L);
    L.clear();
    System.out.println(L.isEmpty());
    printList(L);
    System.out.println(L.sentinel.toString());
    L.insert(3.3,0);
    System.out.println(L.isEmpty());
    printList(L);
    System.out.println(L.sentinel.next.toString());
    L.insert(3.4, 0);
    L.insert(3.5, 0);
    L.insert(3.67, 1);
    L.insert(3.357, 0);
    L.insert(3.333, 4);
    System.out.println(L.size());
    printList(L);
    L.remove(3);
    System.out.println(L.size());
    printList(L);
    L.clear();
    L.insert(3.4, 0);
    L.insert(3.5, 0);
    L.insert(3.67, 1);
    L.insert(3.357, 0);
    L.insert(3.333, 3);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
  }

  public static void test2(){
    // example test cases
    LinkedListImpl L= new LinkedListImpl();
    L.insert(3.4,0);
    L.insert(3.5,1);
    L.insert(3.67,2);
//    printList(L);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
  }
  
  public static void testOracle() {
	  LinkedListImpl L= new LinkedListImpl();
	  L.insert(3,0);
	  L.insert(5, 1);
	  L.insert(6, 2);
	  L.insert(25, 3);
	  printList(L);
	  printListBackwards(L);
	  L.remove(3);
	  printList(L);
	  printListBackwards(L);
  }
  
  public static void testForErrors() {
	  LinkedListImpl L= new LinkedListImpl();
	  L.insert(3,0);
	  L.insert(5,1);
	  System.out.println(L.get(-1));
	  System.out.println(L.get(0));
	  System.out.println(L.get(1));
	  System.out.println(L.get(2));
	  //System.out.println(L.isEmpty());
  }
  
  public static void insertAllRemoveAll() {
	  LinkedListImpl L= new LinkedListImpl();
	  System.out.println(L.isEmpty());
	  for(int i = 0; i < 5; i++) {
		  L.insert(i + 1.5, i);
		  printList(L);
	  }
	  System.out.println(L.isEmpty());
	  for(int j = 4; j >= 0; j--) {
		  L.remove(j);
		  printList(L);
	  }
	  L.clear();
	  printList(L);
	  System.out.println(L.isEmpty());
  }
  
  public static void testBigData() {
	  LinkedListImpl L = new LinkedListImpl();
	  for(int i = 0; i < 100000; i++) {
		  L.insert(i + 1, i);
	  }
	  System.out.println("Done");
//	  printList(L);
//	  System.out.println("Size: " + L.size());
	  System.out.println("Data at Position 999: " + L.get(999));
//	  System.out.println("Remove 999");
//	  L.remove(999);
//	  System.out.println("Size after removal: " + L.size());
//	  System.out.println("Data at Position 999: " + L.get(999));
  }
  
  public static void printList(LinkedListImpl L){ 
    //note that this is a good example of how to iterate through your linked list
    // since we know how many elements are in the list we can use a for loop
    // and not worry about checking the next field to see if we hit the end sentinel
    Node curr=L.sentinel.next; // the first data node in the list is the one after sentinel. 
    if(L.size() == 0) {
    	System.out.print("sentinel --> " );
    	if(L.sentinel.next.data == 0) {
    		System.out.print("sentinel\n");
    	}
    } else {
    	if(L.sentinel.next.prev.data == 0) {
        	System.out.print("sentinel");
        }
        for(int i=0; i<L.size(); i++) { 
          System.out.print(" --> " + curr.data);
          curr=curr.next;
        }
        
        if(curr.data == 0) {
        	System.out.print(" --> sentinel");
        }
        
        System.out.println();
    }
    
  }
  
  public static void printListBackwards(LinkedListImpl L) {
	Node curr=L.sentinel.prev;
	if(L.sentinel.prev.next.data == 0) {
	   	System.out.print("sentinel");
	}
    for(int i=L.size; i > 0; i--) { 
      System.out.print(" --> " + curr.data);
      curr=curr.prev;
    }
    if(curr.data == 0) {
    	System.out.print(" --> sentinel");
    }
    System.out.println();
  }
}