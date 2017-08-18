package algorithm_java;

//Microsoft Google 

public class TicTacToe {
	int[] rows;
    int[] cols;
    int diag;
    int anti_diag;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        anti_diag = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = (player == 1? 1: -1);
        rows[row] += add;
        cols[col] += add;
        if( row == col)
            diag += add;
        if( row == n - 1 - col)
            anti_diag += add;
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(anti_diag) == n)
            return player;
        return 0;
    }
    
    public static void main(String[] args) {
    	TicTacToe toe = new TicTacToe(3);
    	System.out.println(toe.move(0, 0, 1));
    	System.out.println(toe.move(0, 2, 2));
    	System.out.println(toe.move(2, 2, 1));
    	System.out.println(toe.move(1, 1, 2));
    	System.out.println(toe.move(2, 0, 1));
    	System.out.println(toe.move(1, 0, 2));
    	System.out.println(toe.move(2, 1, 1));
	}
}
