package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecodeWaysII {
	int M = 1000000007;
	
	//solutionI, dp, O(n) space and O(n) time
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i];
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2')
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
            }
        }
        return (int) dp[s.length()];
    }
    
    //http://www.geeksforgeeks.org/find-all-possible-interpretations/
   class Node {
        String dataString;
        Node left;
        Node right;
        public Node(String dataString) {
            this.dataString = dataString;
            //Be default left and right child are null. 
        }
    }
    
    private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
        "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
        "s", "t", "u", "v", "w", "x", "v", "z"};
    
    public List<String> printAllInterpretations(int[] arr) {
    	List<String> res = new ArrayList<>();
    	helper(arr, 0, "", res);
    	return res;
    }
    
    public static void helper(int arr[],int index,String s, List<String> res){
	    if(index>=arr.length){
	    	res.add(s);
	    	return ;
	    }
	    String temp=s+(alphabet[arr[index]]);
	    helper(arr,index+1,temp, res);
	    if(index<arr.length-1){
	       int  num=arr[index]*10+arr[index+1];
	       if(num<=26&&num>9){
	    	   temp=s+(alphabet[num]);
	    	   helper(arr,index+2,temp, res);
	        }
	    }
	}
    
    public static void main(String[] args) {
    	DecodeWaysII s = new DecodeWaysII();
    	int[] arr = {1, 1, 2,3};
    	List<String> res =  s.printAllInterpretations(arr);
    	res.forEach(str -> System.out.print(str + " "));
	}
}
