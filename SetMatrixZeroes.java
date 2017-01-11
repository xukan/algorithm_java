package algorithm_java;

//http://blog.csdn.net/linhuanmars/article/details/24066199

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        boolean rowHasZero=false, colHasZero = false;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0)
                colHasZero=true;
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0)
                rowHasZero = true;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
        }
        if(colHasZero){
            for(int i=0;i<m;i++)
                matrix[i][0]=0;
        }
        if(rowHasZero){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
    }
    
    public static void main(String[] args) {
    	SetMatrixZeroes s = new SetMatrixZeroes();
    	int[][] matrix = {{1,0},
    							 {1,1}};
    	s.setZeroes(matrix);
    	int m=matrix.length, n=matrix[0].length;
    	for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+ " ");    
            }
            System.out.println();
        }
	}
}
