package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Facebook

public class NumberofLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)
                    	cnt[i] += cnt[j];
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i])
            	res += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	NumberofLongestIncreasingSubsequence s = new NumberofLongestIncreasingSubsequence();
//    	int[] nums = {1,3,5,4,7};
    	int[] nums = {1,2,4,3,5,4,7,2};
    	int res = s.findNumberOfLIS(nums);
    	System.out.println(res);
	}
}
