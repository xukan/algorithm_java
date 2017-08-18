package algorithm_java;

import java.util.HashMap;
import java.util.Map;

//Amazon

//need to read the requirement carefully
//variant of 2sum

public class KdiffPairsinanArray {
	public int findPairs(int[] nums, int k) {
        if(k<0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap();
        int count = 0;
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0)+1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(k == 0){
                if(entry.getValue() >=2)
                    count++;
            }else{
                if( map.containsKey(entry.getKey() + k))
                    count++;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		
	}
}
