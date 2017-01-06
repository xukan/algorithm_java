package algorithm_java;

//reference: http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
//reference: http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
//stack里面只存放单调递增的索引

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0)
			return 0;
        Stack<Integer> stack = new Stack();
        int maxArea=0, area=0, i=0;
        int[] h = new int[heights.length+1];
        h=Arrays.copyOf(heights, heights.length+1);
        while(i<heights.length+1){
        	if(stack.empty() || h[i]>=h[stack.peek()])
        		stack.push(i++);
        	else{
        		int top = stack.pop();
        		if(stack.empty())
        			area = h[top]*i;
        		else{
        			area = h[top]*(i-stack.peek()-1);
        		}
        		maxArea= Math.max(area, maxArea);
        	}
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		int[] nums={2,1,5,6,2,3};
		LargestRectangleinHistogram s = new LargestRectangleinHistogram();
		int res = s.largestRectangleArea(nums);
		System.out.println(res);
	}
}
