package algorithm_java;

public class Searcha2DMatrix {
	// I
	public boolean searchMatrixI(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		int row = matrix.length, col = matrix[0].length;
		int l = 0, r = row * col - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int val = matrix[m / col][m % col];
			if (val == target)
				return true;
			else if (val < target)
				l = m + 1;
			else
				r = m - 1;
		}
		return false;
	}

	/*
	 * We start search the matrix from top right corner, initialize the current
	 * position to top right corner, if the target is greater than the value in
	 * current position, then the target can not be in entire row of current
	 * position because the row is sorted, if the target is less than the value
	 * in current position, then the target can not in the entire column because
	 * the column is sorted too. We can rule out one row or one column each
	 * time, so the time complexity is O(m+n).
	 */

	public static boolean searchMatrixII(int[][] matrix, int target) {
		// The worst case is O(m + n). You don't need to iterate through each
		// column for each row.
		if (matrix.length == 0)
			return false;
		int m = matrix.length, n = matrix[0].length;
		int row = 0, col = n - 1;
		while (row < m && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] < target)
				row++;
			else
				col--;
		}
		return false;
	}

	public static void main(String[] args) {
		// int[][] input={
		// {1, 3, 5, 7},
		// {2, 4, 7, 8},
		// {3, 5, 9, 10}
		// };

		int[][] input = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		boolean res = searchMatrixII(input, 16);
		System.out.println(res);
	}
}
