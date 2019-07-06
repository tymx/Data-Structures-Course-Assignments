package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size = 0;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

@Override
public boolean insert(String s) {
	// TODO Auto-generated method stub
	
	boolean increment;
	
	if(s == null) {
		return false;
	} else if(root == null || root.data == null) {
		root = new BST_Node(s);
		size++;
		return true;
	} else {
		increment = root.insertNode(s, size);
		if(increment) {
			size++;
		} else {
			return false;
		}
	}
	
	return true;
}

@Override
public boolean remove(String s) {
	// TODO Auto-generated method stub
	boolean remove = false;
	
	if(size == 0 || s == null) {
		return false;
	}
	
	if(root.data.equals(s)) {
		if(root.left == null && root.right == null) {
			  //If root has no children
			  root = null;
		  } else if (root.left != null && root.right == null) {
			  //If root has one child on left
			  root = root.left;
			  if(size <= 2) {
				  root.left = null;
			  }
		  } else if (root.right != null && root.left == null) {
			  //If child has one child on right
			  root = root.right;
			  if(size <= 2) {
				  root.right = null;
			  }
		  } else {
			  //If root has two children
			  BST_Node min = root.right.findMin();
			  root.removeNode(min.data, root);
			  root.data = min.data;
			  remove = true;
		  }  
		remove = true;
	} else {
		remove = root.removeNode(s, root);
	}
	
	if(remove) {
		size--;
	}
	
		
	return remove;
}

@Override
public String findMin() {
	// TODO Auto-generated method stub
	if (size == 0) {
		return null;
	} else if (size == 1) {
		return this.root.data;
	} else {
		return root.findMin().data;
	}
}

@Override
public String findMax() {
	// TODO Auto-generated method stub
	if (size == 0) {
		return null;
	} else if (size == 1) {
		return this.root.data;
	} else {
		return root.findMax().data;
	}
}

@Override
public boolean empty() {
	// TODO Auto-generated method stub
	return size == 0;
}

@Override
public boolean contains(String s) {
	// TODO Auto-generated method stub
	
	if(size == 0 || s == null) {
		return false;
	}
	
	return root.containsNode(s);
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}

@Override
public int height() {
	// TODO Auto-generated method stub
	
	if(size == 0) {
		return -1;
	} else if (size == 1) {
		return 0;
	} else { 
		return root.getHeight();
	}
}

}
