package algorithm_java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Google

public class ZigzagIterator {
	Iterator<Integer> itr1;
    Iterator<Integer> itr2;
    boolean bar;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        bar = true;
        this.itr1 = v1.iterator();
        this.itr2 = v2.iterator();
    }

    public int next() {
        int res=0;
        if(itr1.hasNext() && bar){
            res= itr1.next();
        }
        else if(itr2.hasNext() && !bar)
            res= itr2.next();
        else if(!itr1.hasNext())
            res = itr2.next();
        else if(!itr2.hasNext())
            res = itr1.next();
        bar = !bar;
        return res;
    }

    public boolean hasNext() {
        return itr1.hasNext() || itr2.hasNext();
    }
    
    public static void main(String[] args) {
    	List<Integer> l1 = new ArrayList<Integer>();
    	List<Integer> l2 = new ArrayList<Integer>();
    	l1.add(3);
    	l1.add(2);
    	l1.add(1);
    	l2.add(5);
    	l2.add(7);
    	l2.add(9);
    	l2.add(11);
    	l2.add(6);
    	l2.add(8);
    	ZigzagIterator s = new ZigzagIterator(l1, l2);
    	while(s.hasNext())
    		System.out.print(s.next()+ " ");
	}
}
