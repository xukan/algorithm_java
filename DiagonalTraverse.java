package algorithm_java;

//Google 

public class DiagonalTraverse {
	public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length;
        int arr[] = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // moving up
                if(c == n - 1)  //note if we put if(r==0) as the first condition, then it should be if(c<n-1 && r==0)
                	r++;
                else if(r == 0)
                	c++;
                else{
                	r--;
                	c++;
                }
            } else {                // moving down
                if(r == m - 1)
                	c++;
                else if(c == 0)
                	r++;
                else{
                	r++;
                	c--;
                }
            }   
        }   
        return arr;
    }
	
	public static void main(String[] args) {
		int[][] input = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		int[] res = findDiagonalOrder(input);
		for(int i: res)
			System.out.print(i + " ");
	}
}
