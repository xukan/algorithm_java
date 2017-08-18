package algorithm_java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
	//I, hashMap, my solution
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        int n=0;
        boolean find = false;
        for(int i : findNums){
            int target = i;
            int pos = map.get(target);
            int k=pos+1;
            find = false;
            for(;k<nums.length;k++){
                if(nums[k]>target){
                    res[n++] = nums[k];
                    find = true;
                    break;
                }
            }
            if(k==nums.length && !find)
                res[n++]=-1;
        }
        return res;
    }
	
	//II Google
	//my solution 
	public static int[] nextGreaterElementsII(int[] nums) {
		if(nums==null || nums.length==0)
            return new int[0];
        int len = nums.length;
        int[] flatten = new int[len*2-1];
        for(int i=0;i<len;i++){
            flatten[i] = nums[i];
        }
        int t = len;
        for(int i=0;i<len-1;i++)    
            flatten[t++] = nums[i];
        int[] res = new int[len];
        for(int i=0;i<len;i++){
        	int k=i+1;
            for(;k<flatten.length;k++){
                if(flatten[k]>nums[i]){
                    res[i]= flatten[k];
                	break;
                }
            }
            if(k==flatten.length)
            	res[i] = -1;
        }
        return res;
    }
	
	//II, Stack solution with O(n)
	/*
	 * stack is used to record the indexes of decreasing subsequence.
	 * for the input nums={5,4,3,2,1,6}, 6 is the next greater element of all previous elements, since 6 is greater than all previous elements.
	 * We use a stack to keep the indexes of decreasing subsequence. When we see a nums[stack.peek()] < current element x, 
	 * then we pop all indexes whose corresponding numbers are smaller than x. And x is the next greater elements for all popped ones. 
	 * */
	public static int[] nextGreaterElementsII_stack(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }   
        return next;
    }
	
	//III
	//http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
	/*
	 * If the digits of given number is in descending order, then return -1;
	 * Say input number is 534976
	 * traversal the given number from the rightmost digit, find the digit that is greater than the previous digit. we find 4, mark it as small.
	 * next find the smallest number on the right of small that is greater than small. It is 6. mark it as big.
	 * swap small and big. number turns into 536974
	 * sort the number from the digit next to original small to the end of number, we get 536479
	 * */
	public static  int nextGreaterElementIII(int n) {
		char[] nums = String.valueOf(n).toCharArray();
        int len = nums.length;
        int small = -1;
        for(int i=len-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                small = i;
                break;
            }
        }
        if(small == -1)
            return -1;
        
        int big = -1;
        for(int i=len-1;i>small;i--){
            if(nums[i]>nums[small]){
            	if(big == -1 || nums[i]<nums[big] )
            		big = i;
            }
        }
        char tmp = nums[small];
        nums[small] = nums[big];
        nums[big] = tmp;
        Arrays.sort(nums, small+1, len);
        long x = Long.parseLong(new String(nums));
        return x>Integer.MAX_VALUE?-1:(int)x;
    }
	
	
	public static void main(String[] args) {
		int[] input = {9,8,7,3,2,1,6}; //{-1,9,9,6,6,6,9}
		int[] res = nextGreaterElementsII_stack(input);
		for(int i: res)
			System.out.print(i + " ");
		System.out.println();
		//12443322  Expected:13222344
		int num = nextGreaterElementIII(12443322 );  //534976    
		System.out.println(num);
	}
}
