package algorithm_java;

import java.util.HashMap;

//LinkedIn Facebook

//reference:
//http://www.cnblogs.com/EdwardLiu/p/5090563.html
/*
 * A = {{ 1, 0, 0},
 *         {-1, 0, 3}};
 * B = {{ 7, 0, 0 },
 *         { 0, 0, 0 },
 *         { 0, 0, 1 }}; 
 * 这道题的思路是改变矩阵相乘的方法,
 * A[i][j] * (B的第j行)，把A[0].length个相乘得到的行相加，结果是C的第i行，
 * 把例子中的A,B矩阵改变一下值，
 * A = {{ 1, 5, 0},
 *         {-1, 0, 3}};
 * B = {{ 7, 0, 0 },
 *         { 0, 2, 0 },
 *         { 0, 0, 1 }};
 * A[0][0] = 1,  first row of B is { 7, 0 ,0 };
 * A[0][0] * {7,0,0} = {7, 0, 0} 
 * A[0][1] = 5, second row of B is {0,2,0}
 * A[0][1] * {0,2,0} = {0,10,0}
 * A[0][2] = 0, we just ignore third row of B since mutlply result will be {0,0,0}
 * so first row of result is sum of above three rows {7,10,0}       
 * */

public class SparseMatrixMultiplication {
	//solution1 matrix
	public static int[][] multiply(int[][] A, int[][] B) {
		int m = A.length;
		int n = A[0].length;
		int k = B[0].length;
		int[][] res = new int[m][k];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(A[i][j] == 0)
					continue;
				for(int t=0;t<k;t++){
					res[i][t] += A[i][j] * B[j][t];
				}
			}
		}
		return res;
    }
	
	//solution2 adjacent list
	public int[][] multiplyII(int[][] A, int[][] B) {
        if (A == null || A[0] == null || B == null || B[0] == null) return null;
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] C = new int[m][l];
        HashMap<Integer, HashMap<Integer, Integer>> tableB = new HashMap<>();

        for(int k = 0; k < n; k++) {
            tableB.put(k, new HashMap<Integer, Integer>());
            for(int j = 0; j < l; j++) {
                if (B[k][j] != 0){
                    tableB.get(k).put(j, B[k][j]);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0){
                    for (Integer j: tableB.get(k).keySet()) {
                        C[i][j] += A[i][k] * tableB.get(k).get(j);
                    }
                }
            }
        }
        return C;   
    }
	
	public static void main(String[] args) {
		int[][] A = {{ 1, 0, 0},
				  	      {-1, 0, 3}};
		int[][] B = {{ 7, 0, 0 },
						  { 0, 0, 0 },
                          { 0, 0, 1 }};
		int[][] res = multiply(A, B);
		for(int i=0;i<res.length;i++){
			for(int j=0;j<res[0].length;j++){
				System.out.print(res[i][j] + " " );
			}
			System.out.println();
		}
	}
}
