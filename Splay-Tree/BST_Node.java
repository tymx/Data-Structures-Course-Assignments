package SPLT_A4;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  BST_Node par; //parent...not necessarily required, but can be useful in splay tree
  boolean justMade; //could be helpful if you change some of the return types on your BST_Node insert.
            //I personally use it to indicate to my SPLT insert whether or not we increment size.
  
  BST_Node(String data){ 
    this.data = data;
    this.justMade = true;
  }
  
  BST_Node(String data, BST_Node left,BST_Node right,BST_Node par){ //feel free to modify this constructor to suit your needs
    this.data=data;
    this.left=left;
    this.right=right;
    this.par=par;
    this.justMade=true;
  }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is (meaning also make sure they do in fact return data,left,right respectively)

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- Some example methods that could be helpful ------------------------------------------
  //
  // add the meat of correct implementation logic to them if you wish

  // you MAY change the signatures if you wish...names too (we will not grade on delegation for this 
  //assignment) make them take more or different parameters have them return different types
  //you may use recursive or iterative implementations

  //note: I personally find it easiest to make this return a Node,
  //(that being the node splayed to root), you are however free to do what you wish.
  public BST_Node containsNode(String s){ 
	if(data.equals(s)) {
		return splay(this);
	}
	if(data.compareTo(s)>0){
		if(left==null) {
			return splay(this);
		}
		return left.containsNode(s);
	}
	if(data.compareTo(s) < 0){
		if(right == null) {
			return splay(this);
		}
		return right.containsNode(s);
	}
	return null; //shouldn't hit 
  }
  
  //Really same logic as above note
  public BST_Node insertNode(String s){ 
	  if(data.compareTo(s) > 0) {
		  if(left == null) {
			  left = new BST_Node(s);
			  left.par = this;
			  return splay(left);
		  } else {
			  return left.insertNode(s);
		  }  
	  }
	  if(data.compareTo(s) < 0) {
		  if(right == null) {
			  right = new BST_Node(s);
			  right.par = this;
			  return splay(right);
		  } else {
			  return right.insertNode(s);
		  }
		  
	  }
	  
	  return splay(this);
  } 
  //I personal do not use the removeNode internal method in my impl since it is rather easily done in SPLT, 
  //feel free to try to delegate this out, however we do not "remove" like we do in BST
  public boolean removeNode(String s){ 
	  return false; 
  } 
  public BST_Node findMin(){ 
	  if(left != null) {
		  return left.findMin();
	  }
	  return splay(this); 
  } 
  public BST_Node findMax(){ 
	  if(right != null) {
		  return right.findMax();
	  } 
	  return splay(this); 
  }
  public int getHeight(){ 
	  int l=0;
	  int r=0;
	  if(left != null) {
		  l += left.getHeight() + 1;
	  }
	  if(right != null) {
		  r += right.getHeight() + 1;
	  }
	  return Integer.max(l, r); 
  }
  
  //you could have this return or take in whatever you want..so long as it will do the job internally. 
  //As a caller of SPLT functions, I should really have no idea if you are "splaying or not"
  //I of course, will be checking with tests and by eye to make sure you are indeed splaying
  //Pro tip: Making individual methods for rotateLeft and rotateRight might be a good idea!
  private BST_Node splay(BST_Node toSplay) { 
	  
	  BST_Node parent = toSplay.par;
	  BST_Node grandparent = null;
	  if(parent != null) {
		  grandparent = parent.par;
	  }
	  
	  while(parent != null) {
		  //Zig-Zig LL
		  if(grandparent != null) {
			  if(parent.left == toSplay && grandparent.left == parent) {
				  parent = rotateRight(parent).par;
				  parent = rotateRight(toSplay).par;
				  grandparent = parent != null ? parent.par : null;
			  }
		  }
		  //Zig-zig RR
		  if(grandparent != null) {
			  if(parent.right == toSplay && grandparent.right == parent) {
				  parent = rotateLeft(parent).par;
				  parent = rotateLeft(toSplay).par;
				  grandparent = parent != null ? parent.par : null;
			  }
		  }
		  //Zig-zag RL
		  if(grandparent != null) {
			  //Zig-zag
			  if(parent.right == toSplay && grandparent.left == parent) {
				  parent = rotateLeft(toSplay).par;
				  parent = rotateRight(toSplay).par;
				  grandparent = parent != null ? parent.par : null;
			  }
		  }
		  //Zig-zag LR
		  if(grandparent != null) {
			  if(parent.left == toSplay && grandparent.right == parent) {
				  parent = rotateRight(toSplay).par;
				  parent = rotateLeft(toSplay).par;
				  grandparent = parent != null ? parent.par : null;
			  }  
		  }
		  //Zig Situation
		  if(parent != null && grandparent == null) {
			  if(parent.left != null) {
				  if(parent.left == toSplay) {
					  parent = rotateRight(toSplay).par;
				  } else {
					  if (parent.right == toSplay) {
						  parent = rotateLeft(toSplay).par;				  
					  }
				  } 
			  } else {
				  if (parent.right == toSplay) {
					  parent = rotateLeft(toSplay).par; 				  
				  }
			 }
		  }
	  }
	  return toSplay; 
  } 
  
  // --- end example methods --------------------------------------
  
  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  //SPLT PPT Slide 10
  //Parent is parent of the node we want to splay
  //Node A is the right child of parent
  //Node B is the left child of node
  //Node C is the right child of node
  
  private BST_Node rotateLeft(BST_Node node) {
  
	BST_Node grandparent = node.par.par;
	BST_Node parent = node.par;
	BST_Node node_b = node.left;
  
	//Change parent first
	node.left = parent;
	parent.right = node_b;
	if(node_b != null) {
		  node_b.par = parent;
	}
	parent.par = node;
  
	//If there is a grandparent
	if(grandparent != null) {
		if(grandparent.right == parent) {
		  grandparent.right = node;
	  } else {
		  grandparent.left = node;
	  }
	} 
	node.par = grandparent;
	return node;
	  
}
  
  //Parent is parent of the node we want to splay
  //Node A is the left child of node
  //Node B is the right child of node
  //Node C is the right child of parent
  
  private BST_Node rotateRight(BST_Node node) {
	  
	  BST_Node grandparent = node.par.par;
	  BST_Node parent = node.par;
	  BST_Node node_b = node.right;
	  
	  //Change parent first
	  node.right = parent;
	  parent.left = node_b;
	  if(node_b != null) {
		  node_b.par = parent;
	  }
	  parent.par = node;
	  
	  //If there is a grandparent
	  if(grandparent != null) {
		  if(grandparent.right == parent) {
			  grandparent.right = node;
		  } else {
			  grandparent.left = node;
		  }
	  }
	  node.par = grandparent;
	  return node;
  }
  
}