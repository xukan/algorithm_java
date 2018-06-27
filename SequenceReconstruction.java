package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Google 

public class SequenceReconstruction {
	public static boolean sequenceReconstruction(int[] org,List<List<Integer>> seqs) {
        if(seqs.size() == 0)
        	return false; 
        int[] pos = new int[org.length+1];
        for(int i=0;i<org.length;++i) 
        	pos[org[i]] = i;
        boolean[] flags = new boolean[org.length+1];
        int toMatch = org.length-1;
        for(List<Integer> v : seqs) {
            for(int i=0;i<v.size();++i) {
                if(v.get(i)<=0 || v.get(i) > org.length)
                	return false;
                if(i==0)
                	continue;
                int x = v.get(i-1), y = v.get(i);
                if(pos[x] >= pos[y])
                	return false;
                if(flags[x] == false && pos[x]+1 == pos[y]) {
                    flags[x] = true;
                    --toMatch;
                }
            }
        }
        return toMatch == 0;
    }
	
	/*
	 * The basic idea is to count how many numbers are smaller(self include) than the current number.
	 * We then compare this count to the org. It is pretty like the idea of count sort.
	 * */
//	public static boolean sequenceReconstruction(int[] org,List<List<Integer>> seqs) {
//		int len = org.length;
//        int[] map = new int[len + 1];//map number to its index
//        Arrays.fill(map, -1);
//        int[] memo = new int[org.length];//count how many numbers are smaller(on the right)
//        for (int i = 0; i < len; i++)
//            map[org[i]] = i;
//        for (List<Integer> seq : seqs) {
//            if (seq.size() == 0) continue;
//            int prev = seq.get(0);
//            if (prev <= 0 || prev > len || map[prev] == -1)
//            	return false;
//            for (int i = 1; i < seq.size(); i++) {
//                int curr = seq.get(i);
//                if (curr <= 0 || curr > len || map[curr] == -1)
//                	return false;
//                memo[map[prev]] = Math.max(memo[map[prev]], len - map[curr] + 1);
//                prev = curr;
//            }
//            memo[map[prev]] = Math.max(memo[map[prev]], 1);
//        }
//        for (int i = 0; i < memo.length; i++) {
//            if (memo[i] != len - i) return false;
//        }
//        return true;
//    }
	
	public static void main(String[] args) {
		//int[] org = {1,2,3};
		int[] org = {4,1,5,2,6,3};
		List<List<Integer>> seqs = new ArrayList<List<Integer>>();
		seqs.add(Arrays.asList(5,2,6,3));
		seqs.add(Arrays.asList(4,1,5,2));
		boolean res = sequenceReconstruction(org, seqs);
		System.out.println(res);
	}
}
