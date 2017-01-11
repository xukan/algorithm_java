package algorithm_java;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int maxArea=0;
		for(int i=0;i<m;i++){
			int[] array = new int[n];
			for(int j=0;j<n;j++){
				int k=i, count =0;
				if(matrix[i][j]=='1'){
					while(k>=0){
						if(matrix[k][j]=='1'){
							count++;
						}else
							break;
						k--;
					}
				}
				array[j]=count;
			}
			int area =maxRectangle(array);
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
    }
	
	public static int maxRectangle(int[] array){
		int maxArea=0, i=0;
		Stack<Integer> stack = new Stack<Integer>();
		int[] h = new int[array.length+1];
		h=Arrays.copyOf(array, array.length+1);
		while(i<array.length+1){
			if(stack.empty() || h[stack.peek()] < h[i])
				stack.push(i++);
			else{
				int top = stack.pop();
				int area=0;
				if(stack.empty()){
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
