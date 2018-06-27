package algorithm_java;

//Alibaba 

/* 
 * https://discuss.leetcode.com/topic/103936/short-java-o-n-time-o-1-space-one-pass
 * low is lower bound, high is upper bound, [low, high] is the range of possible result string if we replace '*' with '(' or empty or ')'
 * */
public class ValidParenthesisString {
	public static boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
	
	public static void main(String[] args) {
//		String s = "(**())";
//		String s = "(*)";
		String s = "(((*";
		boolean res = checkValidString(s);
		System.out.println(res);
	}
}
