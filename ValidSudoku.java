package algorithm_java;

import java.util.HashSet;

//Snapchat Uber Apple

//II, Snapchat Uber

/*
 * sudoku puzzle rule
 * Each row must have the numbers 1-9 occuring just once.
 * Each column must have the numbers 1-9 occuring just once.
 * And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
 * */
public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        HashSet<Integer> set = new HashSet();
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == '.')
                    continue;
                else{
                    int num = board[i][j] - '0';
                    if(1<=num && num<= 9 && set.add(num))
                        continue;
                    else
                        return false;
                }
            }
            set.clear();
        }
        for(int j = 0;j<n;j++){
            for(int i=0;i<m;i++){
                if(board[i][j] == '.')
                    continue;
                else{
                    int num = board[i][j] - '0';
                    if(1<=num && num<= 9 && set.add(num))
                        continue;
                    else
                        return false;
                }
            }
            set.clear();
        }
        for(int i=0;i<m;i++){
            int row = (i/3)*3;
            int col = (i%3)*3;
            for(int k=row;k<row+3;k++){
                for(int t=col;t<col+3;t++){
                    if(board[k][t] == '.')
                        continue;
                    else{
                        int num = board[k][t] - '0';
                        if(1<=num && num<= 9 && set.add(num))
                            continue;
                        else
                            return false;
                    }
                }
            }
            set.clear();
        }
        return true;
    }
	
	public static void main(String[] args){
		char[][] board= {{'5','3','.','.','7','.','.','.','.'},
				         		 {'6','.','.','1','9','5','.','.','.'},
				         		 {'.','9','8','.','.','.','.','6','.'},
				         		 {'8','.','.','.','6','.','.','.','3'},
				         		 {'4','.','.','8','.','3','.','.','1'},
				         		 {'7','.','.','.','2','.','.','.','6'},
				         		 {'.','6','.','.','.','.','2','8','.'},
				         		 {'.','.','.','4','1','9','.','.','5'},
				         		 {'.','.','.','.','8','.','.','7','9'}};
		boolean res = isValidSudoku(board);
		System.out.println(res);
	}
}
