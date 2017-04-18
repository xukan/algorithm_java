package algorithm_java;

//Snapchat Uber

public class SudokuSolver {
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
					for (char num = '1'; num <= '9'; num++) {// 尝试
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

	public static void main(String args[]) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		char[][] res = solveSudoku(board);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
}
