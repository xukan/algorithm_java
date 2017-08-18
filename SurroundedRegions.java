package algorithm_java;

import java.util.Arrays;
import java.util.LinkedList;

public class SurroundedRegions {
	class Point{
        int x;
        int y;
        public Point(int i, int j){
            x = i;
            y = j;
        }
    }
    
	public static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	
    public void solve_bfs(char[][] board) {
        if(board.length == 0)
            return;
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j] == 'O'){
                    LinkedList<Point> queue = new LinkedList<>();
                    board[i][j] = 'B';
                    queue.offer(new Point(i, j));
                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        for(int[] dir: dirs){
                            int x = p.x + dir[0];
                            int y = p.y + dir[1];
                            if(x<0 || x>=m || y<0 || y>=n)
                                continue;
                            if(board[x][y] == 'O'){
                                board[x][y] ='B';
                                queue.offer(new Point(x, y));
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'B')
                    board[i][j] = 'O';
            }
        }
    }
	
    
    public char[][] solve_dfs(char[][] board) {
        if(board==null || board.length == 0)
            return board;
        if(board.length <=2 || board[0].length<=2)
            return board;
        for(int i=1;i<board.length-1;i++)
            for(int j=1;j<board[i].length-1;j++){
                if(board[i][j] == 'O')
                    dofill(board,i,j);
            }
        return board;
    }
    
    public void dofill(char[][] board, int i, int j){
        if(i<0||j<0||i>=board.length||j>=board[i].length||board[i][j] == 'X')
            return;
        board[i][j] = 'X';
        for(int[] dir: dirs)
            dofill(board, i+dir[0], j+dir[1]);
    }
    
	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},
								  {'X','O','O','X'},
								  {'X','X','O','X'},
								  {'X','O','X','X'}};
//		String[] input = {   "XOOOOOOOOOOOOOOOOOOO",
//			                        "OXOOOOXOOOOOOOOOOOXX",
//			                        "OOOOOOOOXOOOOOOOOOOX",
//			                        "OOXOOOOOOOOOOOOOOOXO",
//			                        "OOOOOXOOOOXOOOOOXOOX",
//			                        "XOOOXOOOOOXOXOXOXOXO",
//			                        "OOOOXOOXOOOOOXOOXOOO",
//			                        "XOOOXXXOXOOOOXXOXOOO",
//			                        "OOOOOXXXXOOOOXOOXOOO",
//			                        "XOOOOXOOOOOOXXOOXOOX",
//			                        "OOOOOOOOOOXOOXOOOXOX",
//			                        "OOOOXOXOOXXOOOOOXOOO",
//			                        "XXOOOOOXOOOOOOOOOOOO",
//			                        "OXOXOOOXOXOOOXOXOXOO",
//			                        "OOXOOOOOOOXOOOOOXOXO",
//			                        "XXOOOOOOOOXOXXOOOXOO",
//			                        "OOXOOOOOOOXOOXOXOXOO",
//			                        "OOOXOOOOOXXXOOXOOOXO",
//			                        "OOOOOOOOOOOOOOOOOOOO",
//			                        "XOOOOXOOOXXOOXOXOXOO"};
//		int m = input.length , n = input[0].length();
//		char[][] board = new char[m][n];
//		for(int i=0;i<input.length;i++){
//			for(int j=0;j<input[i].length();j++)
//				board[i][j] = input[i].charAt(j);
//		}
		SurroundedRegions s = new SurroundedRegions();
		s.solve_dfs(board);
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
