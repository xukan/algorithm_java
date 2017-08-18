package algorithm_java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//IXL 

//similar question
//Solve the Equation

public class FractionAdditionandSubtraction {
	//solution1, regular expression
	public String fractionAddition(String expression) {
		String[] fracs = expression.split("(?=[-,+])");//() capturing group, [] character class, ?= positive lookahead
	    String res = "0/1";
	    for (String frac : fracs)
	    	res = add(res, frac); // add all fractions together
	    return res;
	}

	public String add(String frac1, String frac2) {
//	    int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray(), 
//	          f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();
		int[] f1 = breakIt(frac1);
		int[] f2 = breakIt(frac2);
		
	    int numer = f1[0]*f2[1] + f1[1]*f2[0], denom = f1[1]*f2[1];
	    String sign = "";
	    if (numer < 0) {sign = "-"; numer *= -1;}
	    int divisor = gcd(numer, denom);
	    return sign + numer/divisor + "/" + denom/divisor; // construct reduced fraction
	}
	
	public int[] breakIt(String frac){
		int[] f = new int[2];
		String[] tokens = frac.split("/");
		int i=0;
		for(String token: tokens)
			f[i++] = Integer.parseInt(token);
		return f;
	}
	
	public int gcd(int a, int b) {
	   if (b==0) return a;
	   return gcd(b,a%b);
	}
	
//	public String fractionAddition(String expression) {
//        List<String> nums = new ArrayList<>();
//        int i = 0, j = 0;
//        while (j <= expression.length()) {
//            if (j == expression.length() || j != i && (expression.charAt(j) == '+' || expression.charAt(j) == '-')) {
//                if (expression.charAt(i) == '+') {
//                    nums.add(expression.substring(i + 1, j));
//                }
//                else {
//                    nums.add(expression.substring(i, j));
//                }
//                    
//                i = j;
//            }
//            j++;
//        }
//        
//        String result = "0/1";
//        
//        for (String num : nums) {
//            result = add(result, num);
//        }
//        
//        return result;
//    }
//    
//    private String add(String s1, String s2) {
//        String[] sa1 = s1.split("/");
//        String[] sa2 = s2.split("/");
//        int n1 = Integer.parseInt(sa1[0]);
//        int d1 = Integer.parseInt(sa1[1]);
//        int n2 = Integer.parseInt(sa2[0]);
//        int d2 = Integer.parseInt(sa2[1]);
//        
//        int n = n1 * d2 + n2 * d1;
//        int d = d1 * d2;
//        
//        if (n == 0) return "0/1";
//        
//        boolean isNegative = n * d < 0;
//        n = Math.abs(n);
//        d = Math.abs(d);
//        int gcd = gcd(n, d);
//        
//        return (isNegative ? "-" : "") + (n / gcd) + "/" + (d / gcd);
//    }
//	
//	Computes gcd using Euclidean algorithm
//	public int gcd(int a, int b) {
//	   if (b==0) return a;
//	   return gcd(b,a%b);
//	}
	
	public static void main(String[] args) {
		FractionAdditionandSubtraction s = new FractionAdditionandSubtraction();
//		String input = "-1/2+2/5+1/4";
		String input = "-1/2+1/2";
		String res = s.fractionAddition(input);
		System.out.println(res);
	}
}
