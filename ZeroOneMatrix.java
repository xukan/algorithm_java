package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

//Google
//http://www.debugrun.com/a/7gjTMuh.html

/*
 * 这道题要求在矩阵中对值为非零的点找到距离最近的0点并更新距离
 * 解题思路是BFS,利用队列,第一次扫描零点全部进入队列,非零点更新值为INF,
 * 然后用BFS的思想,对队列中每个点检查上下左右四个相邻点,如果临点值<队列中弹出点值+1,
 * 更新相邻点值并将其加入队列
 * */

public class ZeroOneMatrix {
	public static List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
		if (matrix == null || matrix.size() == 0)
			return matrix;
		int m = matrix.size();
		int n = matrix.get(0).size();
		LinkedList<int[] > q = new LinkedList<>();
        //Queue<int[]> q = new LinkedList<>(); 
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				// 把0元素加入队列中，以备波及影响周围元素
				if (matrix.get(i).get(j) == 0)
					q.offer(new int[] { i, j });
				else
					// 设为最大值，方便求0元素影响值
					matrix.get(i).set(j, Integer.MAX_VALUE);
			}
		// 上下左右
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!q.isEmpty()) {
			int cell[] = q.poll();
			for (int[] d : dirs) {
				int row = cell[0] + d[0];
				int col = cell[1] + d[1];
				if (row < 0 || row >= m || col < 0 || col >= n)
					continue;
				// 上下左右取到的值
				int value = matrix.get(row).get(col);
				int tmp = matrix.get(cell[0]).get(cell[1]) + 1;
				// 如果value小，那说明之前已经更新过，不是max
				if (value <= tmp)
					continue;
				q.offer(new int[] { row, col });
				matrix.get(row).set(col, tmp);
			}
		}
		return matrix;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		int[][] input = {{0,0,0},
					   		   {0,1,0},
					           {1,1,1}};
		/*one more example:
		int[][] input = {{0,1,0,1,1},
							   {1,1,0,0,1},
							   {0,0,0,1,0},
							   {1,0,1,1,1},
							   {1,0,0,0,1}};
		int[][] answer= {{0,1,0,1,2},
							   {1,1,0,0,1},
							   {0,0,0,1,0},
							   {1,0,1,1,1},
							   {1,0,0,0,1}};
		*/
		//convert 2D array to 2D list
		for(int[] arr: input){
//			List<Integer> list =new ArrayList(); 
//			Collections.addAll(list, Arrays.stream(arr).boxed().toArray(Integer[]::new));
			List<Integer> list =  Arrays.stream(arr).boxed().collect(Collectors.toList());
			matrix.add(list);
		}
		
		List<List<Integer>>  res = updateMatrix(matrix);
		for(List<Integer> list : res){
			for(int i:  list){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}
}
