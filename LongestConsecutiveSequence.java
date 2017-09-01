package algorithm_java;

import java.util.HashMap;
import java.util.Map;

//Google Facebook

public class LongestConsecutiveSequence {
	//solutionI, union find, tc: n+mO(logn)
	public int longestConsecutive(int[] nums) {
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap();
		UnionFind uf = new UnionFind(len);
		for(int k=0;k<len;k++){
			if( map.containsKey(nums[k]))
				continue;
			if( map.containsKey(nums[k]+1))
				uf.union(k, map.get(nums[k]+1));
			if( map.containsKey(nums[k]-1))
				uf.union(k, map.get(nums[k]-1));
			map.put(nums[k], k);
		}
		return uf.getHighestRank();
    }

	private class UnionFind{
		int[] id;
		int[] size;
		int highestRank;
		UnionFind(int len){
			id= new int[len];
			size = new int[len];
			highestRank =1;
			for(int i=0;i<len;i++){
				id[i] = i;
				size[i] = 1;
			}
		}
		
		public void union(int p, int q){
			int pRoot = find(p);
			int qRoot = find(q);
			if( pRoot == qRoot )
				return;
			int rank=1;
			if( size[pRoot ]<size[qRoot]){
				id[p] = id[q];
				size[qRoot] += size[pRoot];
				rank = size[qRoot];
			}else{
				id[q] = id[p];
				size[pRoot ]+=size[qRoot];
				rank = size[pRoot];
			}
			highestRank = Math.max(rank, highestRank);
		}
		
		public int find(int i){
			while(id[i]!=i){
				id[i] = id[id[i]];
				i = id[i];
			}
			return i;
		}
		
		public int getHighestRank(){
			return highestRank;
		}
	}

	
	//solutionII, tc: O(n)
	public int longestConsecutive_better(int[] nums) {
        Map<Integer,Integer> ranges = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (ranges.containsKey(num)) continue;
            
            // 1.Find left and right num
            int left = ranges.getOrDefault(num - 1, 0);
            int right = ranges.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            max = Math.max(max, sum);
            
            // 2.Union by only updating boundary
            // Leave middle k-v dirty to avoid cascading update
            if (left > 0) ranges.put(num - left, sum);
            if (right > 0) ranges.put(num + right, sum);
            ranges.put(num, sum); // Keep each number in Map to de-duplicate
        }
        return max;
    }
	
	public static void main(String[] args) {
		LongestConsecutiveSequence s = new LongestConsecutiveSequence();
		int[] nums = {100, 4, 200, 1, 3, 2};
//		int res = s.longestConsecutive_better(nums);
		int res = s.longestConsecutive(nums);
		System.out.println( res);
	}
}
