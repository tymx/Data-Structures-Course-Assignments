package SPLT_A4;

public class SPLT implements SPLT_Interface{
  private BST_Node root;
  private int size;
  
  public SPLT() {
    this.size = 0;
  } 
  
  public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
    return root;
  }

@Override
public void insert(String s) {
	// TODO Auto-generated method stub
	
	
	if(root == null) {
		root = new BST_Node(s);
	} else {
		root = root.insertNode(s);
	}
	
	if(root.justMade) {
		size++;
		root.justMade = false;
	}
}

@Override
public void remove(String s) {
	// TODO Auto-generated method stub

	root = root.containsNode(s);
	
	if(!root.data.equals(s) || root == null) {
		return;
	}
	
	BST_Node leftTree = root.left;
	BST_Node rightTree = root.right;
	
	if(leftTree == null && rightTree == null) {
		root = null;
	} else if(leftTree != null) {
		leftTree.par = null;
		leftTree = leftTree.findMax();
		if(rightTree != null) {
			leftTree.right = rightTree;
			leftTree.right.par = leftTree;
		}
		root = leftTree;
	} else {
		rightTree.par = null;
		root = rightTree;
	}
	size--;
}

@Override
public String findMin() {
	// TODO Auto-generated method stub
	if(size == 0) {
		return null;
	}
	root = root.findMin();
	return root.data;
}

@Override
public String findMax() {
	// TODO Auto-generated method stub
	if(size == 0) {
		return null;
	}
	root = root.findMax();
	return root.data;
}

@Override
public boolean empty() {
	// TODO Auto-generated method stub
	return size == 0;
}

@Override
public boolean contains(String s) {
	// TODO Auto-generated method stub
	if(size == 0) return false;
	root = root.containsNode(s);
	if(root.data.equals(s)) {
		return true;
	}
	return false;
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}

@Override
public int height() {
	// TODO Auto-generated method stub
	return root.getHeight();
} 

}