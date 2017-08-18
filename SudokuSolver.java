package algorithm_java;

//Snapchat Uber

public class SudokuSolver {
	/*
	public static char[][] solveSudoku(char[][] board) {  
		if (board==null||board.length==0)
				return board;
        helper(board);
        return board;
    }
	
	private static boolean helper(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num <= '9'; num++){// 尝试
						if (isValid(board, i, j, num)) {
							board[i][j] = num;
							if (helper(board))
								return true;
							else
								board[i][j] = '.';// 回退
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(char[][] board, int i, int j, char c) {
		// check column
		for (int row = 0; row < 9; row++)
			if (board[row][j] == c)
				return false;
		// check row
		for (int col = 0; col < 9; col++)
			if (board[i][col] == c)
				return false;
		// check block
		int x=i/3*3;
        int y=j/3*3;
		for (int row =x; row < x + 3; row++)
			for (int col = y; col < y + 3; col++)
				if (board[row][col] == c)
					return false;
		return true;
	}
	*/

//	public char[][]  solveSudoku(char[][] board) {
//        if(board == null || board.length ==0)
//            return null;
//        helper(board);
//        return board;
//    }
//    
//    public boolean helper(char[][] board){
//        int m=board.length, n = board[0].length;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(board[i][j] == '.'){
//                    for(int k=1;k<=9;k++){
//                        if(isValid(board, i, j, k)){
//                            board[i][j] = (char)k;
//                            if(helper(board))
//                                return true;
//                            else
//                                board[i][j] = '.';
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    
//    public boolean isValid(char[][] board, int x, int y, int n){
//        for(int i=0;i<9;i++){
//            if(board[i][y] - '0' == n )
//                return false;
//        }
//        for(int j=0;j<9;j++){
//            if(board[x][j] - '0' == n )
//                return false;
//        }
//        int row = (x/3)*3;
//        int col = (y/3)*3;
//        for(int i=row;i<row+3;i++){
//            for(int j=col;j<col+3;j++){
//                if(board[i][j] - '0' == n)
//                    return false;
//            }
//        }
//        return true;
//    }
    
    
    
    public char[][] solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return null;
        helper(board);
        return board;
    }
    
    public boolean helper(char[][] board){
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '.'){
                    for(char c = '1';c<='9';c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(helper(board))
                                return true;
                            else
                                board[i][j]= '.';
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }
    
    public boolean isValid(char[][] board, int x, int y, char c){
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][y] == c)
                return false;
        }
        for(int j=0;j<n;j++){
            if(board[x][j] == c)
                return false;
        }
        int row = (x/3)*3, col = (y/3)*3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j] == c)
                    return false;
            }
        }
        return true;
    }
	
	public static void main(String args[]) {
		SudokuSolver  s = new SudokuSolver();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		char[][] res = s.solveSudoku(board);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
}
