package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public boolean containsNode(String s){ 
	  
	  int compare = s.compareTo(this.data);
	  boolean contains = false;
	  	  
	  if(compare == 0) {
		  contains = true;
		  return true;
	  } else if(compare <= -1) {
		  if(this.left == null) {
			  contains = false;  
		  } else {
			contains = this.left.containsNode(s); 
		  }
	  } else {
		  if(this.right == null) {
			  contains = false;
		  } else {
			 contains = this.right.containsNode(s); 
		  }
	  }
	  
	  return contains;
  }
  
  public boolean insertNode(String s, int size){ 
	  
	  boolean insert = false;
	  
	  if ((s.compareTo(this.data)) <= -1 && this.left == null) {
		  this.left = new BST_Node(s);
		  insert = true;
	  } else if (((s.compareTo(this.data)) <= -1 && this.left != null)){
		  insert = left.insertNode(s, size);
	  } else if((s.compareTo(this.data) >= 1) && this.right == null) {
		  this.right = new BST_Node(s);
		  insert = true;
	  } else if ((s.compareTo(this.data) >= 1) && this.right != null) {
		  insert = right.insertNode(s, size);
	  } else {
		  insert =  false; 
	  } 
	  
	  return insert;
  }
  
  
  public boolean removeNode(String s, BST_Node parent){ 
	  
	  
	  int compare = s.compareTo(this.data);
	  BST_Node min;
	  boolean remove = false;
	  
	  //Root
	  
	  
	  //If root is and child is left
	  if(compare == 0) {
		  //If node has string value 
		  if (left == null && right == null && parent != this) {
			  //If node has no children
			  if(parent.left == this) {
				  parent.left = null;
			  } else {
				  parent.right = null;
			  }
			  remove = true;
		  } else if (left != null && right == null && parent != this) {
			  //If node has one child on left branch
			  if (parent.right != null && parent.left != null) {
				  //If parent has two children including node
				  if(parent.left.data.compareTo(this.data) == 0) {
					  parent.left = left;  
				  } else {
					  parent.right = left;
				  }
			  } else if(parent.left != null) {
				  //if parent has child in left
				  if(parent.left.data.compareTo(this.data) == 0) {
					  parent.left = left;
				  } 
			  } else {
				  //If parent has child in right 
				  if(parent.right.data.compareTo(this.data) == 0) {
					  parent.right = left;
				  }
			  }
			  remove = true;
		  } else if (right != null && left == null && parent != this) {
			  //If node has one child on right branch
			  if (parent.right != null && parent.left != null) {
				  if(parent.left.data.compareTo(this.data) == 0) {
					  parent.left = right;  
				  } else {
					  parent.right = right;
				  }
			  } else if(parent.right != null) {
				  if(parent.right.data.compareTo(this.data) == 0) {
					  parent.right = right;
				  } 
			  } else {
				  if(parent.left.data.compareTo(this.data) == 0) {
					  parent.left = right;
				  }
			  }
			  remove = true;
		  } else if (right != null && left != null) {
			  //If node has two children
			  min = this.right.findMin();
			  this.removeNode(min.data, parent);
			  this.data = min.data;
			  remove = true;
		  } 		  
	  } else {
		  //If node does not have string value
		  if(right == null & left == null) {
			  //If no more nodes to search through
			  remove = false;
		  } else if(compare <= -1) {
			  //Search through left branch
			  parent = this;
			  remove = left.removeNode(s, parent);
		  } else {
			  //Search through right branch
			  parent = this;
			  remove = right.removeNode(s, parent);
		  }
	  }
	  
	  return remove;
	  
  }
  
  public BST_Node findMin(){ 
	  BST_Node min = this;
	  
	  if(left == null) {
		  return min;
	  } else {
		  min = left.findMin();
	  }
	  
	  return min;
  }
  
  public BST_Node findMax(){ 
	  
	  BST_Node max = this;
	  
	  if(right == null) {
		  return max;
	  } else {
		  max = right.findMax();
	  }
	  
	  return max;
  }
  
  public int getHeight(){ 
	 	  	  
	  if(this.left == null && this.right == null) {
		  return 0;
	  } else if(this.left != null && this.right == null) {
		  return 1 + left.getHeight();
	  } else if(this.left == null && this.right != null) {
		  return 1 + right.getHeight();
	  } else {
		  return 1 + Math.max(left.getHeight(), right.getHeight());
	  }
	  

  }


  // --- end fill in these methods --------------------------------------
  
  public BST_Node findMinParent(String s) {
	  BST_Node parent;
	  BST_Node min;
	  	  
	  min = this.findMin();
	  parent = this;
	  boolean found = false;
	  
	  if(min.data == this.data) {
		  found = true;
	  } else {
		  if(left != null) {
			  if(s.compareTo(this.left.data) != 0 && min == this.left) {
				  found = true;
			  }
		  } 
		  
		  if(right != null) {
			  if(s.compareTo(this.right.data) != 0 && min == this.right) {
				  found = true;
			  }
		  }
		   
		  if(!found) {
			  if(s.compareTo(this.data) <= -1 && left != null) {
				  parent = this.left.findMinParent(s);
			  } else {
				  if(right != null) {
					  parent = this.right.findMinParent(s);
				  }
				  
			  }
		  }
	  }
	  
	  return parent;
	  
  }


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}