package algorithm_java;

public class FactorialTrailingZeroes {
	 public int trailingZeroes(int n) {
		 int r = 0;
	        while (n > 0) {
	            n /= 5;
	            r += n;
	        }
	        return r;
	 }
}
