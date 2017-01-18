package algorithm_java;

//Microsoft Google Uber

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	//spiral matrix I
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length==0)
            return res;
        int m = matrix.length, n=matrix[0].length;
        //int k=0;
        int x=0, y=0;
        while(m>0 && n>0){
        	if(m==1){
        		for(int j=0;j<n;j++)
        			res.add(matrix[x][y++]);
        		break;
        	}else if(n==1){
        		for(int i=0;i<m;i++)
        			res.add(matrix[x++][y]);
        		break;
        	}
        	for(int j=0;j<n-1;j++){
        		res.add(matrix[x][y++]);
        	}
        	for(int i=0;i<m-1;i++){
        		res.add(matrix[x++][y]);
        	}
        	for(int j=0;j<n-1;j++){
        		res.add(matrix[x][y--]);
        	}
        	for(int i=0;i<m-1;i++){
        		res.add(matrix[x--][y]);
        	}
        	x++;
        	y++;
        	m-=2;
        	n-=2;
        }
        return res;
    }
	
	//spiral matrix II
	public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int k=1;
        int x=0, y=0;
        while(n>0){
            if(n==1){
                for(int i=0;i<n;i++){
                    res[x][y++]=k++;
                }
                break;
            }
            for(int i=0;i<n-1;i++)
                res[x][y++]=k++;
            for(int i=0;i<n-1;i++){
                res[x++][y]=k++;
            }
            for(int i=0;i<n-1;i++){
                res[x][y--]=k++;
            }
            for(int i=0;i<n-1;i++){
                res[x--][y]=k++;
            }
            x++;
            y++;
            n-=2;
        }
        return res;
    }
	
	public static void main(String[] args){
		int[][] input={{1,2,3,4,5},
				       {6,7,8,9,10},
				       {11,12,13,14,15},
				       {16,17,18,19,20}};
		List<Integer> res = spiralOrder(input);
		for(int i: res)
			System.out.print(i+" ");
		System.out.println();
	}
}
