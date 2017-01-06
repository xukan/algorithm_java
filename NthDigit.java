package algorithm_java;

public class NthDigit {
	public int findNthDigit(int n) {
		if( n < 10)
            return n;
		int m = n;
		int len =1, count=9, start=1;
       while( m  > len*count ){
    	   m -= len*count;
    	   len++;
    	   count*=10;
    	   start*=10;
       }
       start = start + (n-1)/len;
       int res = String.valueOf(start).charAt((int)(n-1))-'0';
       return res;
    }
	
	public static void main(String[] args) {
		NthDigit solution = new NthDigit();
		int res = solution.findNthDigit(100);
		System.out.println( res );
	}
}
