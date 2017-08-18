package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//amazon

//http://www.cnblogs.com/grandyang/p/6536694.html

public class Minesweeper {
//	public char[][] updateBoard(char[][] board, int[] click) {
//        if (board.length == 0 || board[0].length == 0 || click.length != 2) return board;
//        int x = click[0], y = click[1], m = board.length, n = board[0].length;
//        if (board[x][y] == 'M') {
//            board[x][y] = 'X';
//        } else {
//            dfs(board, x, y, m, n);
//        }
//        return board;
//    }
//    
//    private void dfs(char[][] board, int x, int y, int m, int n) {
//        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E')
//        	return;
//		  int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};	
//        int mine = adjMine(board, x, y, m, n);
//        if (mine > 0) {
//            board[x][y] = (char) ('0' + mine);
//        } else {
//            board[x][y] = 'B';
//            for (int[] d : dirs) {
//                dfs(board, x + d[0], y + d[1], m, n);
//            }
//        }
//    }
//    
//    private int adjMine(char[][] board, int x, int y, int m, int n) {
//        int cnt = 0;
//        for (int i = x - 1; i <= x + 1; i++) {
//            for (int j = y - 1; j <= y + 1; j++) {
//                if (0 <= i && i < m && 0 <= j && j < n && board[i][j] == 'M')
//                    cnt++;
//            }
//        }
//        return cnt;
//    }
	
//	public char[][] updateBoard(char[][] board, int[] click) {
//        if (board.length == 0 || board[0].length == 0 || click.length != 2) return board;
//        int x = click[0], y = click[1], m = board.length, n = board[0].length;
//        if (board[x][y] == 'M') {
//            board[x][y] = 'X';
//        } else {
//            helper(board, click[0], click[1]);
//        }
//        return board;
//    }
//    
//    public void helper(char[][] board, int i, int j){
//    	int m = board.length, n = board[0].length;
//    	int count = 0;
//    	int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
//    	List<int[]> neighbors = new ArrayList<>();
//    	for(int[] dir: dirs){
//    		int x = i+ dir[0];
//    		int y = j+ dir[1];
//    		if(x<0 || x>=m || y<0 || y>=n)
//    			continue;
//    		if(board[x][y] == 'M')
//    			count++;
//    		else if(count == 0 && board[x][y] == 'E')
//    			neighbors.add(new int[]{x, y});
//    	}
//    	
//    	if(count > 0)
//    		board[i][j] = (char)(count + '0');
//    	else{
//    	    board[i][j] = 'B';
//    		for(int[] pos : neighbors){
//    			helper(board, pos[0], pos[1]);
//    		}
//    	}
//    }
    
	public char[][] updateBoard(char[][] board, int[] click) {
        int i= click[0], j = click[1];
        if(board[i][j] == 'M')
            board[i][j] = 'X';
        else
            helper(board, i, j);
        return board;
    }
    
    public void helper(char[][] board, int i, int j){
        int m = board.length, n = board[0].length;
        int count = 0;
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        List<int[]> neighbors = new ArrayList<int[]>();
        for(int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<0 || x>=m || y< 0 || y>=n)
                continue;
            if(board[x][y] == 'M')
                count++;
            else if(count == 0 && board[x][y] == 'E')
                neighbors.add(new int[]{x, y});
        }
        if(count>0)
            board[i][j] = (char)(count+'0');
        else{
        	board[i][j] = 'B';
            for(int[] neighbor: neighbors)
                helper(board, neighbor[0], neighbor[1]);
        }
    }
	
	
	public static void main(String[] args) {
		Minesweeper s = new Minesweeper();
		char[][] board = {{'E', 'E', 'E', 'E', 'E'},
								  {'E', 'E', 'M', 'E', 'E'},
				                  {'E', 'E', 'E', 'E', 'E'},
				                  {'E', 'E', 'E', 'E', 'E'}};
//		char[][] board = {{'E'}};
		int[] click = {3,0};
		board = s.updateBoard(board, click);
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
