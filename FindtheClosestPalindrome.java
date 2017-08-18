package algorithm_java;

//Yelp
//https://discuss.leetcode.com/topic/88897/java-solution-with-detailed-proof
/*
 * Let's build a list of candidate answers for which the final answer must be one of those candidates. 
 * Afterwards, choosing from these candidates is straightforward.
 * If the final answer has the same number of digits as the input string S, 
 * then the answer must be the middle digits + (-1, 0, or 1) flipped into a palindrome. 
 * For example, 23456 had middle part 234, and 233, 234, 235 flipped into a palindrome yields 23332, 23432, 23532. 
 * Given that we know the number of digits, the prefix 235 (for example) uniquely determines the corresponding palindrome 23532, 
 * so all palindromes with larger prefix like 23732 are strictly farther away from S than 23532 >= S.
 * If the final answer has a different number of digits, it must be of the form 999....999 or 1000...0001, 
 * as any palindrome smaller than 99....99 or bigger than 100....001 will be farther away from S.
 * */

public class FindtheClosestPalindrome {
	public String nearestPalindromic(String n) {
        char[] arr = n.toCharArray();
        int l = 0, r = arr.length-1;
        while(l<r)
            arr[r--] = arr[l++];
        String cur = String.valueOf(arr);
        String prev = helper(cur, false);
        String next = helper(cur, true);
        
        long num = Long.valueOf(n);
        long curNum = Long.valueOf(cur);
        long prevNum = Long.valueOf(prev);
        long nextNum = Long.valueOf(next);
        
        long d1 = Math.abs(num - prevNum);
        long d2 = Math.abs(num - curNum);
        long d3 = Math.abs(num - nextNum);
        
        if(num == curNum){
            return d1<=d3?prev: next;
        }else if(num < curNum){
            return d1<=d2? prev: cur;
        }else
            return d2<=d3? cur: next;
    }
    
    public String helper(String str, boolean dir){
        int len = str.length();
        int l = len/2, r = len-l;
        int n = Integer.valueOf(str.substring(0, r));
        n += (dir?1: -1);
        if(n==0)
            return l==0?"0":"9";
        String left = String.valueOf(n);
        StringBuilder sb = new StringBuilder(left).reverse();
        if(left.length()<r)
            sb.append("9");
        String right = sb.substring(sb.length() - l);  //example: input = "2", res = "1"
        return left+right;
    }
	
	
	public static void main(String[] args) {
		FindtheClosestPalindrome s = new FindtheClosestPalindrome();
//		String input = "1000";
		String input = "23456";
		String res = s.nearestPalindromic(input);
		System.out.println(res);
	}
}
