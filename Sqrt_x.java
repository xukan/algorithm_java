package algorithm_java;

//Bloomberg Apple Facebook

//The square root of a given number x is no bigger than x/2+1

public class Sqrt_x {
	public static int mySqrt(int x) {
		long l=0, r=x/2+1;
        while(l<=r){
            long m = (l+r)/2;
            if(m*m == x)
                return (int)m;
            else if(m*m<x){
                l=m+1;
            }else
                r=m-1;
        }
        return (int)r;
    }
	
	
	//solution II
	public int MySqrt(int x) {
        long l = 0, r = x/2+1;
        while(l<=r){
            long m = l + (r-l)/2;
            if(m*m == x)
                return (int)m;
            else if(m*m<x){
                if((m+1)*(m+1)>x)
                    return (int)m;
                l = m+1;
            }else
                r = m-1;
        }
        return -1;
	}
	
	public static void main(String[] args) {
		int res = mySqrt(4);
		System.out.println(res);
	}
}
