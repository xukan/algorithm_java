package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Google

public class OptimalAccountBalancing {
	public int minTransfers(int[][] transactions) {
        Map<Integer, Long> map = new HashMap();
        for(int[] t: transactions){
            long val1 = map.getOrDefault(t[0], 0L);
            long val2 = map.getOrDefault(t[1], 0L);
            map.put(t[0], val1 - t[2]);
            map.put(t[1], val2 + t[2]);
        }        
        
        List<Long> list = new ArrayList();
        for(long val: map.values()){
            if(val != 0) list.add(val);
        }
        
        Long[] debts = new Long[list.size()];
        debts = list.toArray(debts);
        return helper(debts, 0 , 0);
    }
        
    int helper(Long[] debts, int pos, int count){
        while(pos < debts.length && debts[pos] == 0) pos++;
        if (pos >= debts.length) {
            return count;
        }
        int res = Integer.MAX_VALUE;
        for(int i = pos + 1; i < debts.length; i++){
            if(debts[pos] * debts[i] < 0){
              debts[i] += debts[pos];
              res = Math.min(res, helper(debts, pos + 1, count + 1));
              debts[i] = debts[i] - debts[pos];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	OptimalAccountBalancing s = new OptimalAccountBalancing();
    	int[][] transactions = {{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}};
    	int res = s.minTransfers(transactions);
    	System.out.println(res);
	}
}
