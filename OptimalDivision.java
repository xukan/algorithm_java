package algorithm_java;

/*
 * X1/X2/X3/../Xn will always be equal to (X1/X2) * Y, no matter how you place parentheses. 
 * i.e no matter how you place parentheses, X1 always goes to the numerator and X2 always goes to the denominator. 
 * Hence you just need to maximize Y. And Y is maximized when it is equal to X3 *..*Xn. 
 * So the answer is always X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2
 * */

//a/(b/c/d/e) = a*c*d*e/b

public class OptimalDivision {
	public static String optimalDivision(int[] nums) {  
		String res = new String(nums[0]+"");
        if(nums.length==1)
            return res;
        if(nums.length==2){
            res+=("/"+nums[1]);
            return res;
        }
        res+="/";
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<nums.length;i++)
            sb.append("/").append(nums[i]+"");
        return res + "(" + sb.deleteCharAt(0).toString() + ")";
    }  
	
	public static void main(String[] args) {
		int[] input = {1000,100,2};
		String res = optimalDivision(input);
		System.out.println(res);
	}
}
