package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Google

public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
        if(nums.length==0)
            return res;
        int l = 0, r=0;
        while(r<nums.length){
            String range = String.valueOf(nums[l]);
            r = l+1;
            while( r<nums.length && nums[r] == (nums[r-1]+1))
                r++;
            if(nums[r-1]!=nums[l])
                range += "->" + nums[r-1];
            res.add(range);
            l = r;
        }
        return res;
    }
	
	public static void main(String[] args) {
//		int[] input = {1,3};
		int[] input = {1,2,5};
		List<String> res = summaryRanges(input);
		for(String s: res)
			System.out.print(s+" ");
	}
}
