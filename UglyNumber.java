package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {
	//I
	public static boolean isUgly(int n) {
        if(n <=0)
            return false;
        while(n%2==0)
            n/=2;
        while(n%3==0)
            n/=3;
        while(n%5==0)
            n/=5;
        return n==1;
    }
	
	//II
	//http://fisherlei.blogspot.com/2015/10/leetcode-ugly-number-ii-solution.html
	public static int nthUglyNumber(int n) {
	    if(n<=0)
	        return 0;
	 
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(1);
	    int i=0;
	    int j=0;
	    int k=0;
	    while(list.size()<n){
	        int m2 = list.get(i)*2;
	        int m3 = list.get(j)*3;
	        int m5 = list.get(k)*5;
	 
	        int min = Math.min(m2, Math.min(m3, m5));
	        list.add(min);
	 
	        if(min==m2)
	            i++;
	 
	        if(min==m3)
	            j++;
	 
	        if(min==m5)
	            k++;
	    }
	    return list.get(list.size()-1);
	}
	
	//Super Ugly Number
	public static int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i=0;
        int[] pos = new int[primes.length];
        while(list.size()<n){
        	 int min = Integer.MAX_VALUE;
            for(int m=0;m<primes.length;m++){
                min = Math.min(min, list.get(pos[m])*primes[m]);
            }
            // if(!list.contains(min))
            	list.add(min);
            for(int m=0;m<primes.length;m++){
            	if(min == list.get(pos[m])*primes[m]){
            		pos[m]++;
            	}	
            }
        }
        return list.get(n-1);
    }
	
	public static void main(String[] args) {
//		int res = nthUglyNumber(11);
//		System.out.println(res);
		
		int n = 11;
		int[] primes = {2,3,5};
		int res1 = nthSuperUglyNumber(n, primes);
		System.out.println(res1);
	}
}
