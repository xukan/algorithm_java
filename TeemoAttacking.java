package algorithm_java;

//Riot Games
//Similar Problems
//merge interval

public class TeemoAttacking {
	public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        int[] ends = new int[len];
        for(int i=0;i<len;i++)
            ends[i] = timeSeries[i]+duration-1;
        int i=0, j=0;
        int res = 0;
        while(i<len){
        	j=i+1;
            while(j<len && ends[i]>=timeSeries[j]){
                ends[i] = Math.max(ends[i], ends[j]);
                j++;
            }
            res += ends[i] - timeSeries[i] + 1;
            i=j;
        }
        for(int t:ends)
        	System.out.print(t+" ");
        System.out.println();
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2};
		int res = findPoisonedDuration(nums, 2);
		System.out.println(res);
	}
}
