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