package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//array int[] index is used to track numbers in the same set
//index[i] shows position of last number in the same set
//array dp[] shows total number in the same set.
//max_dp shows the maximum total number of all sets
public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
        if( nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n], index = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(index, -1);
        int max_dp = 0, max_index = -1;
        for( int i=0; i<n;i++){
            for( int j=i-1; j>=0; j-- ){
                if( nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i] ){
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }
            }
            if( max_dp < dp[i]  ){
            	max_dp = dp[i];
            	max_index = i;
           }
        }
        for( int i = max_index; i!=-1; i= index[i]){
            res.add( nums[ i ] );
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = { 1,2 ,4, 8, 9, 72};
		LargestDivisibleSubset solution = new LargestDivisibleSubset();
		// array index : [ -1, 0, 1, 2, 0, 3 ]
		// array dp     : [ 1, 2, 3, 4, 2, 5]
		List<Integer> result = solution.largestDivisibleSubset(nums);
		for( int i : result )
			System.out.println( i +  " " );
	}
}
