package algorithm_java;

import java.util.Comparator;
import java.util.PriorityQueue;

//Google

public class SuperUglyNumber {
	public int nthSuperUglyNumberHeap(int n, int[] primes) {
	    int[] ugly = new int[n];

	    PriorityQueue<Num> pq = new PriorityQueue<Num>(new Comparator<Num>(){
	 	    public int compare(Num n1, Num n2) {
	 	        return n1.val - n2.val;
	 	    }
	    });
	    for (int i = 0; i < primes.length; i++)
	    	pq.add(new Num(1, primes[i], primes[i]));
	    
	    ugly[0] = 1;
	    for (int i = 1; i < n; i++) {
	        ugly[i] = pq.peek().val;
	        while (pq.peek().val == ugly[i]) {
	            Num nxt = pq.poll();
	            int index = nxt.idx + 1;
	            System.out.println(nxt.pf* ugly[nxt.idx] + " " + index + " " + nxt.pf);
	            pq.add(new Num(nxt.pf * ugly[nxt.idx], nxt.idx + 1, nxt.pf));
	        }
	    }

	    return ugly[n - 1];
	}

	private class Num {
	    int val;
	    int idx;
	    int pf; //prime factor

	    public Num(int idx, int pf, int val) {
	        this.idx = idx;
	        this.pf = pf;
	        this.val = val;
	    }
	}
	
	public static void main(String[] args) {
		SuperUglyNumber s = new SuperUglyNumber();
		int[] primes =  {2, 7, 13, 19};
		int res = s.nthSuperUglyNumberHeap(10, primes);
		System.out.println(res);
		
	}
}
