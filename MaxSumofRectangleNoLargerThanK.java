package algorithm_java;

import java.util.TreeSet;

//Maximum Sum of Subarray Close to K
//Maximum Subarray

public class MaxSumofRectangleNoLargerThanK {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int maxValue = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = 0;
        if(m>=n){
        	row = m;
        	col = n;
        }else{
        	row = n;
        	col = m;
        }
        for(int i=0;i<col;i++){
        	int[] sum = new int[row];
        	for(int j=i;j<col;j++){
        		TreeSet<Integer> preSum = new TreeSet();
        		preSum.add(0);
        		int curSum = 0;
        		for(int x=0;x<row;x++){
        			sum[x] += row==m?matrix[x][j]: matrix[j][x];
        			curSum += sum[x];
        			Integer ceiling = preSum.ceiling(curSum-k);
        	        if(ceiling!=null){
        	            maxValue= Math.max(maxValue, curSum-ceiling);        
        	        }
        	        preSum.add(curSum);
        		}
        	}
        }
        return maxValue;
    }
}
