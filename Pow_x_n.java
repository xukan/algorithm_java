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
	public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        int power = n;
        if(n<0){
            if(n == Integer.MIN_VALUE)
                n++;
            x = 1/x;
            n = -n;
        }
        double res = helper(x, n);
        return power==Integer.MIN_VALUE? res*x: res;
    }
    
    public double helper(double x, int n){
        if(n == 0)
            return 1;
        double v = helper(x, n/2);
        return n%2==1?v*v*x:v*v;
    }
	
	//iterative solution
    public static double myPow_iteration(double x, int n) {
        if(n==0)
            return 1;
        int p = n;
        if(n<0){
            if(n == Integer.MIN_VALUE)
                n++;
            x = 1/x;
            n = -n;
        }
        double res = 1;
        double v = x;
        while(n>0){
            if(n%2==1)//这一步只有在n是奇数(n可以最开始是奇数,或者在运算过程中变成奇数,比如n=6, n/2=3,  而且最后n=1)
                res *= v; //注意这里乘的是v,不是x, 例子2^6  == (2^2)^3
            v*=v;
            n/=2;
        }
        return p == Integer.MIN_VALUE?res*x:res;
    }
	
	public static void main(String[] args){
		double x = 2;
		int n = 8;
//		double x = 2.00000;
		//注意这个test case, Integer.MIN_VALUE = -2147483648, 如果直接转化为正数是会溢出的,所以先加1,这样转化为正数就等于Integer.MAX_VALUE了
//		int n	 = -2147483648; n = Integer.MIN_VALUE
		
//    	double res = myPow(x, n);
//    	System.out.println(res);
    	double res1 = myPow_iteration(x, n);
    	System.out.println(res1);
    }
}
