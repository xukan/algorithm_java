package algorithm_java;
//Twitter

import java.util.ArrayList;
import java.util.List;

//Time complexity : O(mn).
//Space complexity : O(mn).

public class BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();
        getRows(grid, rows);
        getCols(grid, cols);
        int row = rows.get(rows.size()/2);
        int col = cols.get(cols.size()/2);
        return minDis(rows, row) + minDis(cols, col);
    }
	
	public void getRows(int[][] grid, List<Integer> rows ){
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j] == 1)
					rows.add(i);
			}
		}
	}
	
	public void getCols(int[][] grid, List<Integer> cols ){
		for(int j=0;j<grid[0].length;j++){
			for(int i=0;i<grid.length;i++){
				if(grid[i][j] == 1)
					cols.add(j);
			}
		}
	}
	
	public int minDis(List<Integer> cordinates, int median){
		int sum = 0;
		for(int pos: cordinates){
			sum += Math.abs(pos - median);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		BestMeetingPoint bp = new BestMeetingPoint();
		int[][] grid = {
				{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}
		};
		int res = bp.minTotalDistance(grid);
		System.out.println(res);
	}
}
