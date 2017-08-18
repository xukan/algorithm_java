package algorithm_java;

import java.util.HashMap;
import java.util.TreeMap;

public class ContainsDuplicate {
	
	//II
	//Palantir Airbnb 
	public boolean containsNearbyDuplicateII(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else{
                int index = map.get(nums[i]);
                if(Math.abs(index-i)<=k)
                    return true;
                else
                    map.put(nums[i], i);
            }
        }
        return false;
    }
	
	//III
	//Palantir Airbnb 
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Long, Integer> map = new TreeMap();
        for(int i=0;i<nums.length;i++){
            if(i>k)
                map.remove((long)nums[i-k-1]);
            long val = (long)nums[i];
            Long greater = map.ceilingKey(val);
            if( greater != null && greater -val <=t)
                return true;
            Long smaller = map.lowerKey(val);
            if(smaller !=null && val - smaller <=t)
                return true;
            map.put(val, i);
        }
        return false;
    }
}
