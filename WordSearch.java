package algorithm_java;

//Microsoft Bloomberg Facebook

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( word.charAt(0) == board[i][j]){
                    boolean flag = dfs(board, word, visited, 0, i, j);
                    if(flag)
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, boolean[][] visited, int n, int i, int j){
        boolean res = false;
    	if(i<0 || i >= board.length || j < 0 || j>= board[0].length || visited[i][j] || board[i][j] != word.charAt(n))
            return false;
        if( n == word.length()-1 )
            return true;
        visited[i][j] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int k=0;k<4;k++){
            res= dfs( board, word, visited, n+1, i+dx[k], j+dy[k]);
            if(res)
            	return true;
        }      
        //after each search, if current letter failed to find the word, we need to reset each neighboring letter unvisited 
        //since we need to continue searching started from different letter 
        visited[i][j] = false;
        return res;
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
		//String word = "ABCCED";
    	//String word = "ABCESEEEFS";
    	String word = "AAB";
		WordSearch s = new WordSearch();
		boolean find = s.exist(matrix, word);
		System.out.println(find);
	}
}
