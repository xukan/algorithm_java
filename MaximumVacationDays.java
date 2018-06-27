package algorithm_java;

//Google

public class MaximumVacationDays {
	public static int maxVacationDays(int[][] flights, int[][] days) {
        if (days.length == 0 || flights.length == 0)
        	return 0;
        int m = days.length, n = days[0].length;
        int[][] dp = new int[m][n + 1];
        for (int week = n - 1; week >= 0; week--) {
            for (int cur_city = 0; cur_city < m; cur_city++) {
                dp[cur_city][week] = days[cur_city][week] + dp[cur_city][week + 1];
                for (int dest_city = 0; dest_city < m; dest_city++) {
                    if (flights[cur_city][dest_city] == 1) {
                        dp[cur_city][week] = Math.max(days[dest_city][week] + dp[dest_city][week + 1], dp[cur_city][week]);
                    }
                }
            }
        }
        return dp[0][0];
    }
	
	public static void main(String[] args) {
		int[][] flights = {{0, 1, 1},
				 				 {1, 0, 1},
				 				 {1, 1, 0}};
		int[][] days = {{1, 3, 1}, 
				 			  {6, 0, 3},
				 			  {3, 3, 3}};
		int res = maxVacationDays(flights, days);
		System.out.println(res);
	}
}
