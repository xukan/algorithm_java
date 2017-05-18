package algorithm_java;

/* http://www.cnblogs.com/springfor/p/3870929.html
 * 
 * 二分法求解
 * pow(x,n)就是求x的n次方。x的N次方可以看做：x^n = x^(n/2)*x^(n/2)*x^(n%2)。所以利用递归求解，当n==1的时候，x^n=x。
 * 当然n是可以小于0的，2^(-3) = 1/(2^3)。按照上面那个规律就可以解决了。
 *  
 * 类似的题目还有sqrt(x);
 * */

public class Pow_x_n {
	public static double power(double x, int n) {
        if (n == 0)
            return 1;
        double v = power(x, n / 2);
        return n%2==0? v*v : v*v*x;
    }	
	
	public static double myPow(double x, int n) {
		if(n==0)return 1;
		if(n<0){
			x= 1/x;
			n=-n;
		}
		return power(x, n);
	}
	
	//iterative solution
	public static double myPow_iteration(double x, int n) { 
	    if(n==0) return 1;
	    if(n<0) {
	        n = -n;
	        x = 1/x;
	    }
	    double ans = 1;
	    while(n>0){
	        if((n&1) == 1) ans *= x;
	        x *= x;
	        n >>= 1;
	    }
	    return ans;
	}
	
	public static void main(String[] args){
		double x = 2.5;
		int n = 5;
    	double res = myPow(x, n);
    	System.out.println(res);
    	double res1 = myPow_iteration(x, n);
    	System.out.println(res1);
    }
}
