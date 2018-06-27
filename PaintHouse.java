package algorithm_java;

//similar question
//Maximum Product of Three Numbers

public class PaintHouse {	
	//LinkedIn 
	public static int minCostI(int[][] costs) {
        int m = costs.length;
        if(m==0)
            return 0;
        for(int i=1;i<m;i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[m-1][0], costs[m-1][1]), costs[m-1][2]);
    }
	
	//Facebook
	/*
	 * 每一行用二维数组min记录最小和倒数第二小的cost及其纵坐标,
	 * min1记录每行最小cost坐标
	 * min2记录每行倒数第二小cost坐标
	 * 方法与Maximum Product of Three Numbers中找出最小两个值得方法相同
	 * 对于当前行的cost[i][j]，如果最小的cost的纵坐标不是j,那么cost[i][j] += min[0][1](上一行的最小的cost)
	 * 如果最小的cost的纵坐标是j,那么cost[i][j] += min[1][1](上一行的倒数第二小的cost)
	 * 最后一行得到的最小的cost就是结果
	 * 
	 * tc: O(nk), n = total rows, k = columns
	 * sc: O(1)
	 * */
	public static int minCostII(int[][] costs) {
        if(costs.length == 0)
            return 0;
        int m = costs.length, n = costs[0].length;
        int min1=0, min2 = 0;
        for(int i=0;i<m;i++){
            if(i>0){
                for(int j=0;j<n;j++){
                    if(j!=min1)
                        costs[i][j] += costs[i-1][min1];
                    else
                        costs[i][j] += costs[i-1][min2];
                }
            }
            min1 = min2 = 0;
            for(int j=0;j<n;j++){
                if(costs[i][j] < costs[i][min1]){
                    min2 = min1;
                    min1 = j;
                }else if( min2 == min1 || costs[i][j] <= costs[i][min2])
                    min2 = j;
            }
        }
        return costs[m-1][min1];
    }
	
	public static void main(String[] args) {
		int[][] costs = {
				//{1,5,3},{2,9,4}
				{17,9,6,2,6,18,8,12,3,5,9,11,20,8,13,16}
		};
		int res = minCostII(costs);
		System.out.println(res);
	}
}
