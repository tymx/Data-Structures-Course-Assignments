package MinBinHeap_A3;

import java.lang.Math;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size = 0;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }

  @Override
  public void insert(EntryPair entry) {
	  
	  if(size + 1 >= array.length) {
		  return;
	  }
	  
	  array[size + 1] = entry;
	  size++;
	  	  
	  if(size > 1) {
		  if(array[(int)size/2].getPriority() > array[size].getPriority()) {
			  bubbleUp(size);
		  }
	  }
  }
	
  @Override
  public void delMin() {
	  // TODO Auto-generated method stub 
	  if (size == 1) {
		  array[1] = null;
		  size--;
		  return;
	  }
	  
	  array[1] = array[size];
	  array[size] = null;
	  size--;
	  bubbleDown(1);
  
	}
	
  @Override
  public EntryPair getMin() {
	  // TODO Auto-generated method stub
	  if(size == 0) {
		  return null;
	  } else {
		  return array[1];
	  }
  }
	
  @Override
  public int size() {
	  // TODO Auto-generated method stub
	  return size;
  }
	
  @Override
  public void build(EntryPair[] entries) {
	  for(int i = 0; i < entries.length; i++) {
		  if(array.length > i + 1) {
			  array[i + 1] = entries[i];
			  size++;
		  };
	  }
	  
	  for(int position = (int)size/2; position > 0; position--) {
		  bubbleDown(position);
	  }
  }
  
  /*Private methods*/
  
  private void bubbleUp(int i) {
	  EntryPair hole = array[i];
	  int holePos = i;
	  EntryPair parent = array[(int)Math.floor(i/2)];
	  int parentPosition = (int)Math.floor(i/2);
	  
	  if(hole.getPriority() < parent.getPriority()) {
		  array[holePos] = parent;
		  array[parentPosition] = hole;
		  bubbleUp(parentPosition);
	  } else {
		  return;
	  }
  }
  
  private void bubbleDown(int i) {
	 if (array[i] == null) {
		 return;
	 }
  	 EntryPair hole = array[i];
  	 EntryPair child = null;
	 int childPosition = 0;
	 	 
	 if((2 * i) > size) {
		 return;
	 }
	 
	 if(array[(2 * i) + 1] != null) {
		 
		 if(array[2 * i].getPriority() < array[(2 * i) + 1].getPriority()) {
			 child = array[2 * i];
			 childPosition = 2 * i;
		 } else {
				 child = array[(2 * i) + 1];
				 childPosition = (2 * i) + 1;
		 }
	 } else {
		 child = array[2 * i];
		 childPosition = 2 * i;
	 }

	 if(hole.getPriority() > child.getPriority()) {
		 array[i] = child;
		 array[childPosition] = hole;
		 bubbleDown(childPosition);
	 } else {
		 return;
	 }
  }
}