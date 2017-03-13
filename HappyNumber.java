package algorithm_java;

import java.util.HashSet;

//Uber Airbnb Twitter

public class HappyNumber {
	public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(n!=1){
            int sum=0;
            while(n!=0){
                int k = n%10;
                n/=10;
                sum += k*k;
            }
            if(!set.add(sum))
                return false;
            n=sum;
        }
        return true;
    }
	
	public static void main(String [] args){
		boolean x=isHappy(19);
		System.out.println(x);
	}
}
