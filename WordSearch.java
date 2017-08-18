package algorithm_java;

//Microsoft Bloomberg Facebook

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if(board == null || board.length==0)
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, i, j, 1, word, visited))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, int i, int j, int k, String word, boolean[][] visited){
        if( k == word.length()){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        visited[i][j] = true;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x<0 || x>=m || y<0 || y>=n || visited[x][y] || word.charAt(k) != board[x][y])
                continue;
            if(helper(board, x, y, k+1, word, visited))
                return true;
        }
        visited[i][j] = false;
        return false;
    }
    
    
    public static void main(String[] args) {
//    	char[][] matrix ={
//				{'A','B','C','E'},
//				{'S','F','E','S'},
//				{'A','D','E','E'}
//		};
    	
    	char[][] matrix = {
    			{'C','A','A'},
    			{'A','A','A'},
    			{'B','C','D'}
    	};
//    	char[][] matrix = {{'a','a'}};
		//String word = "ABCCED";
    	//String word = "ABCESEEEFS";
    	String word = "AAB";
//    	String word = "a";
		WordSearch s = new WordSearch();
		boolean find = s.exist(matrix, word);
		System.out.println(find);
	}
}
