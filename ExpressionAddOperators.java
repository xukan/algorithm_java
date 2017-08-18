package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Google Facebook

//target sum

//reference:  http://www.cnblogs.com/grandyang/p/4814506.html

public class ExpressionAddOperators {
	public static List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<String>();
		helper(res,num,"",  0, 0, target);
		return res;
    }
	//when String is converted to int, it is easy to , so we use long 
	//String num, here, num is right part of the input String we are analyzing
	public static void helper(List<String> result, String num, String cur, long last, long curVal, int target) {
	    if (num.length() == 0) { //used up right part of string num
	        if (curVal == target) {
	            result.add(cur);
	        }
	        return;
	    }

	    for (int i = 1; i <= num.length(); i++) {
	        String left = num.substring(0, i);
	        long leftVal = Long.parseLong(left);
	        if (left.length() > 1 && left.charAt(0) == '0') {
	            return; ///invalid case: 01,000...
	        }
	        String right = num.substring(i);
	        if (cur.length() > 0) {
	        	//                  result, num, cur, last, curVal, target
	            helper(result, right, cur + "+" + left, leftVal, curVal + leftVal, target);
	            helper(result, right, cur + "-" + left, -leftVal, curVal - leftVal, target);
	            helper(result, right, cur + "*" + left, last * leftVal, (curVal - last) + (last * leftVal), target);
	        } else {
	            helper(result, right, left, leftVal, leftVal, target);
	        }
	    }
	}
	
	public static void main(String[] args) {
		String input ="123456789";  int target =100; //from facebook
		//String input="232";int target =8;
		List<String> res = addOperators(input, target);
		System.out.println("size:"+res.size());
		for(String s: res)
			System.out.println(s+" ");
	}
}
