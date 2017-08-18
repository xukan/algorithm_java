package algorithm_java;

//reference: http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
//reference: http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
//stack里面只存放单调递增的索引
//栈底保存的坐标是扫描到当前最小高度的坐标

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistogram {
//	public int largestRectangleArea(int[] heights) {
//		if(heights == null || heights.length == 0)
//			return 0;
//		int len = heights.length;
//        int[] h = new int[len+1];
//        h=Arrays.copyOf(heights, len+1);
//        Stack<Integer> stack = new Stack<Integer>();
//        int i=0;
//        int maxArea = 0;
//        while(i<h.length){
//            if(stack.isEmpty() || h[i]>=h[stack.peek()])
//                stack.push(i++);
//            else{
//                int top = stack.pop();
//                int area=0;
//                if(stack.isEmpty()){
//                	area = i*h[top];
//                }else
//                	area = (i-stack.peek()-1)*h[top];
//                maxArea = Math.max(area, maxArea);
//            }
//        }
//        return maxArea;
//    }
	
	//Since every bar is pushed and popped only once, the time complexity of this method is O(n).
	public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int i=0;
        while( i <= len){
            int h = (i == len ? 0 : height[i]);
            if(stack.isEmpty() || h >= height[stack.peek()]){
                stack.push(i++);
            }else{
                int top = stack.pop();
                maxArea = Math.max(maxArea, height[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		int[] nums={2,1,3,4,2,3};
		//{2,1,5,6,2,3} 10
		//int[] input = {4,2,0,3,2,5}; //6
		LargestRectangleinHistogram s = new LargestRectangleinHistogram();
		int res = s.largestRectangleArea(nums);
		System.out.println(res);
	}
}
