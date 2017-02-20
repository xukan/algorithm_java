package algorithm_java;

//reference:  http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/

public class Knapsack {
	// time complexity O(2^n)
	// overlapping subproblems property
	public int knapSack(int W, int wt[], int val[], int n) {
		if (W == 0 || n == 0)
			return 0;
		if (wt[n - 1] > W)
			return knapSack(W, wt, val, n - 1);
		else {
			int v1 = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1);
			int v2 = knapSack(W, wt, val, n - 1);
			return Math.max(v1, v2);
		}
	}

	public int tabulation(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}

	// Driver program to test above function
	public static void main(String args[]) {
		Knapsack k = new Knapsack();
		int val[] = new int[] { 100, 120, 60 };
		int wt[] = new int[] { 20, 30, 10 };
		int W = 50;
		int n = val.length;
		System.out.println(k.knapSack(W, wt, val, n));
		System.out.println(k.tabulation(W, wt, val, n));
	}
}
