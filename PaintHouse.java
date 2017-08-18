package algorithm_java;

//similar question
//Maximum Product of Three Numbers

public class PaintHouse {	
	//LinkedIn 
	public int minCostI(int[][] costs) {
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
	 * min[0][0]记录最小cost坐标，min[0][1]记录最小cost
	 * min[1][0]记录倒数第二小cost坐标，min[1][1]记录倒数第二小cost
	 * 方法与Maximum Product of Three Numbers中找出最小两个值得方法相同
	 * 对于当前行的cost[i][j]，如果最小的cost的纵坐标不是j,那么cost[i][j] += min[0][1](上一行的最小的cost)
	 * 如果最小的cost的纵坐标是j,那么cost[i][j] += min[1][1](上一行的倒数第二小的cost)
	 * 最后一行得到的最小的cost就是结果
	 * 
	 * tc: O(nk), n = total rows, k = columns
	 * */
	public static int minCostII(int[][] costs) {
        if(costs.length==0)
            return 0;
        int n = costs.length, k = costs[0].length;
        int[][] min = getMin(costs, 0);
        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){
                if(j!=min[0][0]){
                    costs[i][j]+=min[0][1];
                }else{
                    costs[i][j] += min[1][1];
                }
            }
            min = getMin(costs, i);
        }
        return min[0][1];
    }
	
	public static int[][] getMin(int[][]costs, int i){
		int[][] min = new int[2][2];
		int k = costs[0].length;
		min = new int[2][2];
        min[0][1] = Integer.MAX_VALUE;
        min[1][1] = Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            if(costs[i][j]<min[0][1]){
                min[1][0] = min[0][0];
                min[1][1] = min[0][1];
                min[0][0] = j;
                min[0][1] = costs[i][j];
            }else if(costs[i][j]<min[1][1]){
                min[1][0] = j;
                min[1][1] = costs[i][j];
            }
        }
        return min;
	}
	
	public static void main(String[] args) {
		int[][] costs = {
				{1,5,3},{2,9,4}
		};
		int res = minCostII(costs);
		System.out.println(res);
	}
}
