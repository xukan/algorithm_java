package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if(nums==null || nums.length ==0)
			return res;
		int len=nums.length;
		StringBuilder sb= new StringBuilder();
		sb.append(nums[0]);
		int slow=0, fast=0;
		for(int i=1;i<len;i++){
			if(nums[i] == nums[i-1]+1){
				fast=i;
			}else{
				if(slow!=fast)
					sb.append("->");
					sb.append(nums[fast]);
				slow=i;
				fast=i;
				res.add(sb.toString());
				sb = new StringBuilder();
				if(slow<len)
					sb.append(nums[slow]);
			}
		}
		if(slow!=fast){
			String range = sb.append("->").append(nums[fast]).toString();
			res.add(range);
		}else
			res.add(sb.toString());
		return res;
    }
	
	public static void main(String[] args) {
		int[] input = {1,3};
		List<String> res = summaryRanges(input);
		for(String s: res)
			System.out.print(s+" ");
	}
}
