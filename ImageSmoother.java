package algorithm_java;

//Amazon

public class ImageSmoother {
	public static int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = 0, sum=0;
                for(int r=i-1;r<=i+1;r++){
                    for(int c=j-1;c<=j+1;c++){
                        if(r>=0&&r<m &&c>=0 && c<n){
                            count++;
                            sum+=M[r][c];
                        }
                    }
                }
                res[i][j] = sum/count;
            }
        }
        return M;
    }

	public static void main(String[] args) {
		int[][] M = {{1,1,1},
				 			{1,0,1},
				 			{1,1,1}};
		int[][] res = imageSmoother(M);
		int m = M.length, n = M[0].length;
		 for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	            	System.out.print(res[i][j] + " ");
	            }
	            System.out.println();
	     }
	}
}
