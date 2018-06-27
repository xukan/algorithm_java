package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Google Facebook

//target sum

//reference:  http://www.cnblogs.com/grandyang/p/4814506.html
/*
 * tc: O(4^(N-1))
 * there are 4 cases:
 * plus, minus, multiply and the next digit
 * The process moving to N length of string gives us from 3T(n-1) to 3T(1) :
 * T(n) = 3 * T(n-1) + 3 * T(n-2) + 3 * T(n-3) + ... + 3 *T(1);
 * T(n-1) = 3 * T(n-2) + 3 * T(n-3) + ... 3 * T(1);
 * Thus T(n) = 4T(n-1);
 * */
public class ExpressionAddOperators {
	public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num ==null || num.length() == 0)
            return res;
        helper(num, "", 0, 0, target, res);
        return res;
    }
    
	//when String is converted to int, it is easy to , so we use long 
	//String num, here, num is right part of the input String we are analyzing
    public static void helper(String num, String cur, long last, long curVal, int target, List<String> res){
        if(num.length() == 0){
            if(curVal == target){
                res.add(cur);
            }
            return;
        }
        for(int i=1;i<=num.length();i++){
        	//prune operation, 剪枝操作
        	//如果curVal加上剩余的数字总和(能加到的最大值)小于target,那么可以返回,加法不能达到target,
        	//同理如果curVal减去剩余的数字的值(能减到的最小值)大于target,那么可以返回,减法不能达到target
            long val = Long.parseLong(num);
            String left = num.substring(0, i);
            if(left.length() >1 && left.charAt(0) == '0')
                return;
            long leftVal = Long.parseLong(left);
            String right = num.substring(i);
            if(cur.length()>0){
                if(curVal +val >= target)//如果curVal加上剩余的数字总和(能加到的最大值)小于target,那么可以返回,加法不能达到target,
                    helper(right, cur+"+"+left, leftVal, curVal+leftVal, target, res);
                if(curVal -val <= target)//如果curVal减去剩余的数字的值(能减到的最小值)大于target,那么可以返回,减法不能达到target
                    helper(right, cur+"-"+left, -leftVal, curVal-leftVal, target, res);
                helper(right, cur+"*"+left, last*leftVal, (curVal - last)+last*leftVal, target, res);
            }else{
                helper(right, left, leftVal, leftVal, target, res);
            }
        }
    }
	
	
	public static void main(String[] args) {
//		String input ="123456789";  int target =100; //from facebook
		String input="232";int target =8;
		List<String> res = addOperators(input, target);
		System.out.println("size:"+res.size());
		for(String s: res)
			System.out.println(s+" ");
	}
}
