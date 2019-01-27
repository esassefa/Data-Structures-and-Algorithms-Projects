//import java.util.Arrays;


public class MaxHeap<T extends Comparable<? super T>> {
private T[] heap;	// Array of heap integers
private int endIndex;	//index of the last entry
//private boolean initialized = false;
private static final int DEFAULT_CAPACITY = 25;
//private static final int MAX_CAPACITY = 10000;
private int optimalSwaps;
private int sequentialSwaps;

/**
 * default constructor
 */
public MaxHeap() {
	this(DEFAULT_CAPACITY);
}
/*
 * constructor taking in an integer
 */
public MaxHeap(int initialCapacity) {
	// checks if intial capacity is too small
	if(initialCapacity < DEFAULT_CAPACITY)
		initialCapacity = DEFAULT_CAPACITY;
	
	@SuppressWarnings("unchecked")// the cast is safe because the array contains null entries
	T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
	heap = tempHeap;
	endIndex = 0;
	optimalSwaps = 0;
	sequentialSwaps = 0;
	
}
/**
 * / contructors that takes in an array
 * @param entries
 */
public MaxHeap(T[] entries) {
	this(entries.length);

	for(int j = 0; j < entries.length; j++) {
		heap[j + 1] = entries[j];
		endIndex++;
	}
	//create heap
	for(int rootIndex = endIndex/2; rootIndex > 0; rootIndex--) {
		reheap(rootIndex);
	}
	
	
}
/**
 * constructor and remove method call reheap when needed
 * @param rootIndex
 */

private void reheap(int rootIndex) {
	boolean done = false;
	T orphan = heap[rootIndex];
	int leftChildIndex = 2*rootIndex;
	
	while(!done && (leftChildIndex <= endIndex)) {
		
		int largerChildIndex = leftChildIndex;
		int rightChildIndex = leftChildIndex + 1;
		
		if((rightChildIndex <= endIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
			largerChildIndex = rightChildIndex;
		
		}
		if(orphan.compareTo(heap[largerChildIndex]) <0) {
			heap[rootIndex] = heap[largerChildIndex];
			rootIndex = largerChildIndex;
			leftChildIndex = 2*rootIndex;
			optimalSwaps++;
		}
		else
			done =true;
	}
	heap[rootIndex] = orphan;
	
}

/**
 * Adding new entries to clean slate by the end
 * @param newEntry
 */
public void add(T newEntry) {
	int newIndex = endIndex +1;
	//System.out.print(newIndex);
	int parentIndex = newIndex /2;
	// checks if newEntry is greater than value on parent index
	while( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
		heap[newIndex] = heap[parentIndex];// if it is, perform upheap using while loop
		sequentialSwaps++;
		
		// count how many swaps are made
		newIndex =parentIndex;
		parentIndex =newIndex/ 2;
		
	}
	heap[newIndex] =newEntry;
	endIndex++;
}
/**
 * removes the max/ heap[1] from heap 
 * @return root
 */
public T removeMax() {
	T root = null;
	if(!isEmpty()) {
		root = heap[1];
		heap[1] = heap[endIndex];
		endIndex--;
		reheap(1);
	}
	return root;
	
}
/**
 * returns the max of heap with no tampering
 * @return root
 */
public T getMax() {
	T root = null;
	if(isEmpty()) {
		root = heap[1];
	}
	return root;
}
// checks if heap is empty
public boolean isEmpty() {
	return endIndex < 1;
}
// returns the size of heap
public int getSize() {
	return endIndex;
}
//clear all values in heap
public void clear() {
	while (endIndex > -1) {
		heap[endIndex] = null;
		endIndex--;
	}
	endIndex = 0;
}


// return all optimal swaps
public Integer getOptimalSwaps() {
	// return counter for optimal/reheaping method
	//System.out.println(optimalSwaps );
	return optimalSwaps;
}
// return sequential swapss
public Integer getSequentialSwaps() {
//	System.out.print(sequentialSwaps);
	return sequentialSwaps;
}
// free to be everything you want
public void printHeap() {
	int i;
	int n = 11;
	for( i = 1; i < n && i < endIndex; i++) {
		System.out.print(heap[i]);
		if(i != endIndex -1) {
			System.out.print(",");
		}
	}
		if(i != endIndex) {
			System.out.print("...");
		
	}
	
	
}



}
