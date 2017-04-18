package algorithm_java;

public class PowerofNum {
	//Power of two
	public boolean isPowerOfTwo(int n) {
        return (n>0) && ((n&(n-1))==0);
    }
	
	//Power of Three
	//iteration
	public boolean isPowerOfThree(int n) {
		while(n>0 && n%3==0)
			n/=3;
		return n==1;
	}
	
	//Math
	public boolean isPowerOfThreeII(int n) {
		//Math.log returns the natural logarithm (base e) of a double value
		return  n == Math.pow(3, Math.round(Math.log(n)/Math.log(3)));
	}
	
	//我们在确定其是2的次方数了之后，发现只要是4的次方数，减1之后可以被3整除
	public boolean isPowerOfFour(int n) {
        return n>0 && ((n & (n-1)) == 0) &&( (n-1)%3 ==0);
    }
}
