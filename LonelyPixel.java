package algorithm_java;

//Google

public class LonelyPixel {
	public static int findLonelyPixel(char[][] picture) {
		int m = picture.length;
	    int n = picture[0].length;
	    int[] row = new int[m];
	    int[] col = new int[n];
	    for(int i=0;i<m;i++){
	        for(int j=0;j<n;j++){
	            if(picture[i][j] == 'B'){
	                row[i]++;
	                col[j]++;
	            }
	        }
	    }
	    int res=0;
	    for(int i=0;i<m;i++){
	        for(int j=0;j<n;j++){
	            if(picture[i][j] == 'B' && row[i] == 1 && col[j] == 1)
	                res++;
	        }
	    }
	    return res;
	}
	
	/*
	 * Given a picture consisting of black and white pixels, and a positive integer N, 
	 * find the number of black pixels located at some specific row R and column C that align with all the following rules:
	 * 1.Row R and column C both contain exactly N black pixels.
	 * 2.For all rows that have a black pixel at column C, they should be exactly the same as row R
	 * */
	
	public static int findBlackPixelII(char[][] picture, int N) {
        int m = picture.length;
        int n = picture[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for(int i: row)
        	System.out.print(i+" ");
        System.out.println();
        for(int j: col)
        	System.out.print(j+" ");
        System.out.println();
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B' && row[i] == N && col[j] == N)
                    res++;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		char[][] picture = {{'W', 'B', 'W', 'B', 'B', 'W'},    
									{'W', 'B', 'W', 'B', 'B', 'W'},    
									{'W', 'B', 'W', 'B', 'B', 'W'},    
									{'W', 'W', 'B', 'W', 'B', 'W'}};
		
		char[][] input = {{'W','B','W','B','B','W'},
								  {'B','W','B','W','W','B'},
								  {'W','B','W','B','B','W'},
								  {'B','W','B','W','W','B'},
								  {'W','W','W','B','B','W'},
								  {'B','W','B','W','W','B'}};
		int res = findBlackPixelII(input, 3);
		System.out.println(res);
	}
	
}
