/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	
	Node sentinel; //this will be the entry point to your linked list (the head)
	int size = 0;
  
	public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
		sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
	}
	  
	 //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
	  
	public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
	    return sentinel;
	 }
	
	@Override
	public boolean insert(double elt, int index) {
		// TODO Auto-generated method stub
		
		if(index > size || index < 0) {
			return false;
		}
		
		Node newNode = new Node(elt);
		
		if(index == 0 && size == 0) {
			//If adding to the beginning of the linked list when list is empty
			sentinel.next = newNode;
			sentinel.prev = newNode;
			newNode.next = sentinel;
			newNode.prev = sentinel;
			size++;
			return true;
		} else if (index == 0 && size > 0) {
			//If adding to the beginning of the linked list when list is not empty
			newNode.next = sentinel.next;
			newNode.prev = sentinel;
			sentinel.next.prev = newNode;
			sentinel.next = newNode;
			size++;
			return true;
		} else if (index > 0 && size == index) {
			//Inserting at the end
			Node countNode = sentinel.next;
			int count = 0;
			
			while (countNode != sentinel) {
				if(count < index && countNode.next != sentinel) {
					countNode = countNode.next;
					count++;
				} else {
					break;
				}
			}
			
			newNode.next = sentinel;
			newNode.prev = countNode;
			countNode.next.prev = newNode;
			countNode.next = newNode;
			size++;
			return true;
		} else if(index > 0 && index < size){
			//Inserting in the middle
			Node countNode = sentinel.next;
			int count = 0;
			
			while (countNode != sentinel) {
				if(count < index) {
					countNode = countNode.next;
					count++;
				} else {
					break;
				}
			}
			
			newNode.prev = countNode.prev;
			countNode.prev = newNode;
			newNode.prev.next = newNode;
			newNode.next = countNode;
			size++;
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		Node countNode = sentinel.next;
		int count = 0;
		
		if(size < index || index < 0) {
			return false;
		}
		
		while(countNode != sentinel) {
			if(count < index) {
				countNode = countNode.next;
				count++;
			} else {
				break;
			}			
		}
		
		countNode.prev.next = countNode.next;
		countNode.next.prev = countNode.prev;
		size--;
		
		return true;
	}
	
	@Override
	public double get(int index) {
		// TODO Auto-generated method stub
		Node countNode = sentinel.next;
		int count = 0;
		
		if(size == 0 || index >= size  || index < 0) {
			return Double.NaN;
		}
		
		while(countNode != sentinel) {
			if(count < index) {
				countNode = countNode.next;
				count++;
			} else {
				break;
			}
		}
		
		return countNode.data;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		size = 0;
	}
}