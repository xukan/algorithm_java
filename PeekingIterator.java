package algorithm_java;

//Google Apple Yahoo

import java.util.ArrayList;
import java.util.Iterator;

//similar question : ZigzagIterator
//iterator material: https://www.tutorialspoint.com/java/java_using_iterator.htm

public class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> it;
    Integer cur;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	    cur = it.hasNext()? it.next(): null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = cur;
	    cur = it.hasNext()? it.next(): null;
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return it.hasNext() || cur!=null;
	}
	
	public static void main(String[] args) {
		 ArrayList<Integer> al = new ArrayList();
	      
	      // add elements to the array list
	      al.add(2);
	      al.add(1);
	      al.add(3);
	      al.add(5);
	      al.add(6);

		Iterator<Integer> it = new PeekingIterator(al.iterator());
		while(it.hasNext())
			System.out.print(it.next() + " ");
		
	}
}