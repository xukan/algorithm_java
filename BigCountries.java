/**************************Final6.java********************/
package edu.northeastern.cs_5004;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Sometimes we need to iterate over multiple collections of
 * elements. To do this, we exploit the fact that collections
 * implement the Iterable interface. This class implements a
 * MultiIterable class that aggregates zero or more Iterables.
 * Its Iterator iterates the elements of the first Iterable, 
 * then the elements of each successive Iterable.
 * 
 * The framework of the MultiIterable class is already set up.
 * Your task is to implement its inner MultiIterator class.
 */
public class Final6 {
	/**
	 * This class is an Iterable for a collection of Iterables.
	 * Its Iterator returns the elements of the first Iterable, 
	 * then the elements of each successive Iterable.
	 * 
	 * @param <T> the type of element being iterated
	 */
	static public class MultiIterable<T> implements Iterable<T> {
		/** iterables to iterate */
		Iterable<Iterable<T>> iterables;

		/**
		 * This class implements an Iterator for multiple Iterables.
		 */
		class MultiIterator implements Iterator<T> {
			Iterator<Iterable<T>> iterator = iterables.iterator();
			Iterator<T> iter = iterator.next().iterator();
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				while(iterator.hasNext()){
					Iterable<T> iterable = iterator.next();
					iter = iterable.iterator();
					if(iter.hasNext())
						return true;
				}
				return false;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return iter.next();
			}
			// Your code here
		}
		
		/**
		 * Create an iterable for the input iterables
		 * @param itrs an iterable for the input iterables 
		 */
		@SafeVarargs
		public MultiIterable (Iterable<T> ...itrs) {
			iterables = Arrays.asList(itrs);
		}

		/**
		 * Create an iterable for the iterable collection of iterables
		 * @param itrs an iterable for collection of iterables 
		 */
		public MultiIterable (Iterable<Iterable<T>> itrs) {
			iterables = itrs; 
		}

		/**
		 * Return a iterator for collection of iterables
		 * @return iterator for collection of iterables
		 */
		@Override
		public Iterator<T> iterator() {
			return new MultiIterator();
		}
	}

	/**
	 * Tests MultiIterable class
	 * @param args unused
	 */
	static public void main(String[] args) {
		System.out.println("Start problem 6 (Java)");
		System.out.println();

		// create collections of Integers
		Iterable<Integer> c0 = Arrays.asList();
		Iterable<Integer> c1 = Arrays.asList(1);
		Iterable<Integer> c2 = Arrays.asList(2, 3);
		Iterable<Integer> c3 = Arrays.asList(4, 5, 6);
		
		// test collections version with one collection
		System.out.println("Testing collections version with one collection");
		MultiIterable<Integer> mi = new MultiIterable<>(Arrays.asList(c3));
		System.out.printf("MultiIterable returned: [");
		String sep = "";
		for (int i : mi) {
			System.out.printf("%s%s", sep, i);
			sep = ", ";
		}
		System.out.printf("]\nExpected: [");
		sep = "";
		for (int i : Arrays.asList(4, 5, 6)) {
			System.out.printf("%s%s", sep, i);
			sep = ", ";
		}
		System.out.printf("]\n");

		// test varargs version with four collections
		System.out.println("\nTesting varargs version with four collections");
		mi = new MultiIterable<>(c0, c1, c2, c3);
		System.out.printf("MultiIterable returned: [");
		sep = "";
		for (int i : mi) {
			System.out.printf("%s%s", sep, i);
			sep = ", ";
		}
		System.out.printf("]\nExpected: [");
		sep = "";
		for (int i : Arrays.asList(1, 2, 3, 4, 5, 6)) {
			System.out.printf("%s%s", sep, i);
			sep = ", ";
		}
		System.out.printf("]\n");

		// test collections version with no elements
		System.out.println("\nTesting collections version with no collections");
		mi = new MultiIterable<>(Arrays.<Integer>asList());
		System.out.printf("MultiIterable returned: [");
		sep = "";
		for (int i : mi) {
			System.out.printf("%s%s", sep, i);
			sep = ", ";
		}
		System.out.printf("]\nExpected: [");
		sep = "";
		for (int i : Arrays.<Integer>asList()) {
			System.out.printf("%s%s", sep, i);
			sep = ", ";
		}
		System.out.printf("]\n");

		// test varargs version with no collections
		System.out.println("\nTesting varargs version with no collections");
		mi = new MultiIterable<>();
		System.out.printf("MultiIterable returned: [");
		sep = "";
		for (int i : mi) {
			System.out.printf("%s%s", sep, i);
			sep = ", ";
		}
		System.out.printf("]\nExpected: [");
		sep = "";
		for (int i : Arrays.<Integer>asList()) {
			System.out.printf("%s%s", sep, i);
			sep = ", ";
		}
		System.out.printf("]\n");
		
		System.out.println();
		System.out.println("End problem 6 (Java)");
	}
}
/**************************Final6.java********************/


/********************Final2.java************************/

package edu.northeastern.cs_5004;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Collection;
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
	static class FixedSizeQueue<T> extends AbstractQueue<T> implements java.util.Queue<T> {
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

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return queue.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return queue.contains(o);
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return queue.toArray();
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return queue.remove(o);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return queue.contains(c);
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			// TODO Auto-generated method stub
			if(queue.size() + c.size() > size){
				throw new IllegalStateException();
			}
			return queue.addAll(c);
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return queue.removeAll(c);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			queue.clear();
		}

		@Override
		public boolean add(T e) {
			// TODO Auto-generated method stub
			if(queue.size() + 1 > size){
				throw new IllegalStateException();
			}
			return queue.add(e);
		}

		@Override
		public T remove() {
			// TODO Auto-generated method stub
			return queue.remove();
		}

		@Override
		public T element() {
			// TODO Auto-generated method stub
			return queue.element();
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
/********************Final2.java************************/
