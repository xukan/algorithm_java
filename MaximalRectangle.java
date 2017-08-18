package algorithm_java;

import java.util.Arrays;
import java.util.Stack;

//Facebook

//see Largest Rectangular Area in a Histogram
// in above question, since every bar is pushed and popped only once, the time complexity of this method is O(n).
//tc: O(mn)
public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length == 0)
            return 0;
        int m=matrix.length, n=matrix[0].length;
        int[][] h = new int[m][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=i;k>=0;k--){
                    if(matrix[k][j]=='0')
                        break;
                    else if(matrix[k][j] == '1')
                        h[i][j]++;
                }
            }
        }
        int max= 0;
        for(int i=0;i<m;i++){
            int area = maxRec(h[i]);
            max = Math.max(area, max);
        }
        return max;
    }
    
    public static int maxRec(int[] h){
        int len = h.length;
        int i=0;
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        while(i<len){
            if(stack.isEmpty() || h[i]>h[stack.peek()])
                stack.push(i++);
            else{
                int top = stack.pop();
                int area = 0;
                if(stack.isEmpty()){
                    area = h[top]*i;
                }else
                    area = h[top]*(i-stack.peek()-1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		char[][] matrix={{'1', '0', '1', '0', '0'},
								  {'1', '0', '1', '1', '1'},
								  {'1', '1', '1', '1', '1'},
								  {'1', '0', '0', '1', '0'}};
		//["10111","01010","11011","11011","01111"]
		
//		char[][] input = {{},
//								  {},
//								  {},
//								  {},
//								  {},};
		int res = maximalRectangle(matrix);
		System.out.println(res);
	}
}
