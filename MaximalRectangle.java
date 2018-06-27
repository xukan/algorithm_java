package algorithm_java;

import java.util.Arrays;
import java.util.Stack;

//Facebook

//see Largest Rectangular Area in a Histogram
// in above question, since every bar is pushed and popped only once, the time complexity of this method is O(n).
//tc: O(mn)
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] h = new int[n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1')
                    h[j] +=1;
                else
                    h[j] = 0;
            }
            int area = helper(h);
            max = Math.max(max, area);
        }
        return max;
    }
    
    public int helper(int[] h){
        Stack<Integer> stack = new Stack<Integer>();
        int i=0;
        int height=0;
        int max = 0;
        while(i<=h.length){
            height = (i == h.length?0:h[i]);
            if(stack.empty() || height >= h[stack.peek()])
                stack.push(i++);
            else{
                int top = stack.pop();
                int area = 0;
                if(stack.empty())
                    area = i*h[top];
                else
                    area = (i-stack.peek()-1)*h[top];
                max = Math.max(max, area);
            }
        }
        return max;
    }
    
    
    //solution II:
    public static int maximalRectangle_better(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            right[i] = n;
        }
//        Arrays.fill(right, n);
        int maxA = 0;
        for(int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n; 
            for(int j = 0; j < n; j++) { // compute height (can do this from either side)
                if(matrix[i][j ]== '1') height[j]++; 
                else height[j] = 0;
            }
            for(int j = 0; j < n; j++) { // compute left (from left to right)
                if(matrix[i][j]=='1') 
                	left[j] = Math.max(left[j],cur_left);
                else {
                	left[j] = 0;
                	cur_left = j+1;
                }
            }
            // compute right (from right to left)
            for(int j = n-1; j >= 0; j--) {
                if(matrix[i][j] == '1')
                	right[j] = Math.min(right[j],cur_right);
                else {
                	 right[j] = n;
                	 cur_right = j;
                }    
            }
            // compute the area of rectangle (can do this from either side)
            for(int j = 0; j < n; j++)
                maxA = Math.max(maxA, (right[j]-left[j])*height[j]);
        }
        return maxA;
    }
   
	public static void main(String[] args) {
		char[][] matrix={{'1', '0', '1', '0', '0'},
								  {'1', '0', '1', '1', '1'},
								  {'1', '1', '1', '1', '1'},
								  {'1', '0', '0', '1', '0'}};
		//["10111","01010","11011","11011","01111"]
//		String[] input = {
//				"0001000", 
//				"0011100", 
//				"0111110",
//				"0111100"};
//		char[][] matrix = new char[input.length][input[0].length()];
//		for(int i=0;i<input.length;i++)
//			matrix[i] = input[i].toCharArray();
//		char[][] input = {{},
//								  {},
//								  {},
//								  {},
//								  {},};
		int res = maximalRectangle_better(matrix);
		System.out.println(res);
	}
}
