/**************************Final2.java************/
package edu.northeastern.cs_5004;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Implement a Java FixedSizeQueue<T> that is a fixed size 
 * java.util.Queue<T> whose capacity is specified at creation. 
 * A default constructor creates a queue of capacity 16. 
 * 
 * Use the java.util.AbstractQueue<T> as a base class, and
 * implement the abstract methods for this class.  Use an
 * instance of java.util.ArrayDeque<T> internally for the
 * actual storage. Use the size parameter when creating the
 * ArrayDeque<T>.
 * 
 * If add(T) or addAll(T) attempt to add more items than the 
 * capacity, they should should throw IllegalStateException. 
 * If offer() attempts to add more items than the capacity, 
 * it should return false. Some of this behavior is inherited
 * from AbstractQueue<T>.
 */
public class Final2 {
	/**
	 * This class implements a queue whose capacity is fixed
	 * when an instance is created. The queue can hold no more
	 * elements than the specified capacity.
	 *
	 */
	static class FixedSizeQueue<T> extends AbstractQueue<T> {
		private int size=16;
		ArrayDeque<T> queue;
		
		FixedSizeQueue(){
			queue = new ArrayDeque<T>(size);
		}
		
		FixedSizeQueue(int cap){
			size = cap;
			queue = new ArrayDeque<T>(size);
		}
		
		@Override
		public boolean offer(T e) {
			// TODO Auto-generated method stub
			if(queue.size() >= size)
				return false;
			return queue.offer(e);
		}

		@Override
		public T poll() {
			// TODO Auto-generated method stub
			if(queue.size() == 0)
				return null;
			return queue.poll();
		}

		@Override
		public T peek() {
			// TODO Auto-generated method stub
			if(queue.size() == 0)
				return null;
			return queue.peek();
		}

		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return new QueueIterator();
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return queue.size();
		}
		
		/**
		 * This class implements an iterator for a queue.
		 */
		class QueueIterator implements Iterator<T> {
			/** The current queue index */
			int queueIndex = 0;
			
			/** The current queue iterator */
			Iterator<T> queueItr = queue.iterator();
			
			/**
			 * Returns true if another element is available.
			 * 
			 * @return true if another element is available
			 */
			public boolean hasNext() {
					if (queueItr.hasNext()) {
						return true;
					}
				return false;
			}
			
			/**
			 * Returns the next element available or null if no more elements.
			 * 
			 * @return next element available or null if no elements available 
			 */
			public T next() {
				return (hasNext() ? queueItr.next() : null);
			}	
		}
	}
	
	/**
	 * This program uses tests the fixed capacity limit of 
	 * a FixedSizeQueue<T>.
	 * 
	 * @param args none
	 */
	static public void main(String[] args) {
		
		System.out.println("Start problem 2 (Java)");

		System.out.println();
		System.out.println("case 1: size 0 queue");
		Queue<String> testQueue1 = new FixedSizeQueue<>(0);

		System.out.println("Adding item to queue");
		try {
			testQueue1.add("case1");
			System.out.println("Unexpected return from add()");
		} catch (IllegalStateException e) {
			System.out.println("Caught expected IllegalStateException");
		}

		System.out.println();
		System.out.println("case 2: size 1 queue");
		Queue<String> testQueue2 = new FixedSizeQueue<>(1);

		// add first item
		System.out.println("Adding item to queue");
		try {
			testQueue2.add("case2");
			System.out.println("Returned from add()");
		} catch (IllegalStateException e) {
			System.out.println("Caught unexpected IllegalStateException");
		}
		// add second item
		System.out.println("Adding item to queue");
		try {
			testQueue2.add("case2");
			System.out.println("Unexpected return from add()");
		} catch (IllegalStateException e) {
			System.out.println("Caught expected IllegalStateException");
		}

		System.out.println();
		System.out.println("case 3: size 3 queue");
		Queue<String> testQueue3 = new FixedSizeQueue<>(3);

		// add first item
		System.out.println("Adding item to queue");
		try {
			testQueue3.add("case3");
			System.out.println("Returned from add()");
		} catch (IllegalStateException e) {
			System.out.println("Caught unexpected IllegalStateException");
		}
		// add second item
		System.out.println("Adding item to queue");
		try {
			testQueue3.add("case3");
			System.out.println("Returned from add()");
		} catch (IllegalStateException e) {
			System.out.println("Caught unexpected IllegalStateException");
		}
		// add third item
		System.out.println("Adding item to queue");
		try {
			testQueue3.add("case3");
			System.out.println("Returned from add()");
		} catch (IllegalStateException e) {
			System.out.println("Caught unexpected IllegalStateException");
		}
		// add fourth item
		System.out.println("Adding item to queue");
		try {
			testQueue3.add("case3");
			System.out.println("Unexpected return from add()");
		} catch (IllegalStateException e) {
			System.out.println("Caught expected IllegalStateException");
		}

		System.out.println();
		System.out.println("End problem 2 (Java)");
	}
}
 /**************************Final2.java************/
		
/*******************Final4.java****************/
package edu.northeastern.cs_5004;
import java.util.Vector;

/**
 *  A binary tree can be represented as as a vector of values of type T.
 *  Values are represented in the vector as pointers to instances of
 *  tree_node that store the values.
 *
 *  The root node is at index 1, and its children are at index 2 and 3.
 *  In general, for a node at index k, its left and and right children
 *  are at indexes (2*k) and (2*k)+1. Unoccupied elements are null, and
 *  element 0 is not used.
 *
 *  Binary search tree:
 *                             M
 *                .------------'------------.
 *                E                          T
 *          .-----'-----.              .-----'-----.
 *         B            K              R           W
 *     .---'---.                       '---.   .---'---.
 *     A       C                           S   V       Z
 *
 * Vector representation:
 *    0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
 *  [ *,  M,  E,  T,  B,  K,  R,  W,  A,  C,  *,  *,  *,  S,  V,  Z  ]
 *
 *  Occupied elements contain node values, unoccupied elements are null.
 *
 *  Implement the the private function add(i,v) that adds a value v to
 *  the subtree starting at element i. The value is added by creating and
 *  initializing a tree_node with the value. Also implement the getSize()
 *  function that returns the number of nodes in the tree.
 */
public class Final4 {

	static public class VectorTree<T extends Comparable<T>> {
		/**
		 * Vector used as a binary search tree
		 */
		private Vector<T> tree = new Vector<T>();
	
		/**
		 * Add value v to the tree rooted at node i if the value is not
		 * already in the tree. Value cannot be null.
		 *
		 * Note: adding value at i may require resizing the vector and
		 * initializing the new elements to nullptr first.
		 *
		 * @param i the node index
		 * @param v the node value
		 */
		private void add(int i, T v) {
			// you rcode here
			if(getSize() ==0)
				tree.set(i, v);
			int position = search(i, v);
			tree.set(position, v);
		}

		// A utility function to search a given key in BST
		public int search(int i, T v){
		    if (tree.get(i) == null || tree.get(i).equals(v))
		        return i;
		 
		    // v is less than current node
		    if(tree.get(i).compareTo(v)>0)	
		        return search(2*i, v);
		 
		    // v is greater than current node
		    return search(2*i+1, v);
		}
		
		/**
		 * Adds value v to the tree rooted at position i. If the the 
		 * value at position i is null, adds the value at that position. 
		 * If the value is less than the value at position i, adds the 
		 * value to the left subtree. If the value is greater than the 
		 * value at position i, adds the value to the right subtree. 
		 * If the value is equal to the value at position i, then the 
		 * value is already in the tree and there is nothing to do.
		 *
		 * Note: adding value at i may require resizing the vector and
		 * initializing the new elements to nullptr first.
		 *
		 * @param i the node index
		 * @param v the node value
		 * @throws IllegalArgumentException if v is null.
		 */
		public void add(T v) {
			add(1, v);
		}
		
		/**
		 * Returns number of nodes in the tree.
		 * 
		 * @return the number of nodes in the tree
		 */
		public int getSize() {
			// your code here
			int count = 0;
			for(T node: tree){
				if(node != null)
					count++;
			}
			return count;
		}
	
		/**
		 * Print tree starting at node i in infix order.
		 *
		 * @param i index of subtree to print
		 */
		private void printInfix(int i) {
			if (i < tree.size() && tree.get(i) != null) {
				printInfix(2*i);
				System.out.print(tree.get(i));
				System.out.print(" ");
				printInfix(2*i + 1);
			}
		}
		
		/**
		 * Print tree in infix order.
		 */
		public void printInfix() {
			printInfix(1);
		}
	}
	
	static public void main(String[] args) {
		System.out.println("Start problem 4 (Java)");
		System.out.println();
	
		VectorTree<String> tree = new VectorTree<String>();
	
		// insert values into tree
		String vals[] = {"M", "E", "B", "A", "C", "K", "T", "R", "S", "W", "V", "Z"};
		for(int i=0;i<vals.length*2;i++)
			tree.tree.add(null);
		for (String s : vals) {
			System.out.print("Adding '");
			System.out.print(s);
			System.out.println("' to tree");
			tree.add(s);
		}
		
		// print tree size
		System.out.printf("\nsize: %d expected: %d\n", tree.getSize(), 12);
	
		// print tree in infix (sorted) order
		System.out.println();
		System.out.println("printInfix:");
		tree.printInfix();
		System.out.println();
	
		// print expected values
		System.out.println();;
		System.out.println("Expected:");
		System.out.println("A B C E K M R S T V W Z ");
	
		System.out.println();
		System.out.println("End problem 4 (Java)");
	}
}
/*******************Final4.java****************/

