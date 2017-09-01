package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//yahoo, zenefit

//a solution requires that no TWO queens share the same row, column, or diagonal.

/*
 * 这道题是NP问题, tc大于O(2^n) , it is O(N!)
 * 因为棋盘是n*n的，we use an array named with columnVal to keep track of queen's position, 
 * queen's x-axis is the index of the array, columnVal[index ] = y-axis
 * Let's look at an example here.
 * if n = 4, we have a 4*4 chess board,
 * queens are located at [0,1],[1,0],[2,2],[3,3];
 * which means: columnVal[0] = 1, columnVal[1] = 0, columnVal[2] =2 , columnVal[3] = 3;
 * so array columnVal = {1,0, 2, 3}; 
 * We define a function isValid to check if any two of queens lie in the same column or diagonal line. Since each row only has a single queen,
 * we don't need to worry same row part.
 * */

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		int[] columnVal = new int[n];
		helper( res, columnVal, 0, n );
		return res;
    }
	
	public void helper( List<List<String>> res, int[] columnVal, int cur, int n ){
		if(cur == n){
			printBoard(res, columnVal, n);
		}else{
			for(int i=0;i<n;i++){
				columnVal[cur] = i;  // pay attention to here
				if(isValid(columnVal, cur)){
					helper(res, columnVal, cur+1, n);
				}
			}
		}
	}
	
	public boolean isValid(int[] columnVal, int cur){
		for(int i=0;i<cur;i++){
			if( columnVal[i] == columnVal[cur]  || Math.abs( columnVal[i] - columnVal[cur]) == Math.abs(i - cur))
				return false;
		}
		return true;
	}
	
	public void printBoard(List<List<String>> res, int[] columnVal, int n){
		List<String> tmp = new ArrayList<String>();
		for(int i=0;i<n;i++){
			String[] row = new String[n];
			Arrays.fill(row, ".");
			//columnVal[i] represents y-axis of queen in each row
			row[columnVal[i]] = "Q";
			String str = String.join("", row);
			tmp.add(str);
		}
		res.add(new ArrayList<String>(tmp));
	}
	
	public static void main(String args[]){
		NQueens s = new NQueens();
		List<List<String>> res = s.solveNQueens(4);
		for(List<String> l : res){
			for(String str: l)
				System.out.print(str);
			System.out.println();
		}
	}
}
