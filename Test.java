package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
//class ListNode {
//	int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

public class Test {
	public static boolean makesquare(int[] nums) {
        if(nums == null || nums.length ==0)
            return false;
        int sum=0;
        for(int i: nums)
            sum += i;
        if(sum %4 !=0)
            return false;
        boolean res = search(nums, new int[4], 0, sum/4);
        return res;
    }
    
    public static boolean search(int[] nums, int[] sum, int step, int sideLen){
        if(step == nums.length)
            return true;
        int ele = nums[step];
        for(int i=0;i<4;i++){
        	if(i>step)
        		break;
            if(sum[i]+ele > sideLen)
                continue;
            sum[i]+=ele;
            boolean bar = search(nums, sum, step+1, sideLen);
            if(bar)
                return true;
            sum[i]-=ele;
        }
        return false;
    }
	
    public static void main(String[] args) {
		int[] input = {1,1,2,2,2};
//		int[] input = {3,3,3,3,4};
		//[5,5,5,5,4,4,4,4,3,3,3,3]
		//int[] input = {5,1,5,5,4,9,4,4,3,3,3,2};
		boolean res = makesquare(input);
		//System.out.println(res);
	}
}