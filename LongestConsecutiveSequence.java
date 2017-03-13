package algorithm_java;

import java.util.HashMap;
import java.util.Map;

//Google Facebook

public class LongestConsecutiveSequence {
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
				id[p] = q;
				size[qRoot] += size[pRoot];
				rank = size[qRoot];
			}else{
				id[q] = p;
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
//	public int longestConsecutive(int[] nums) {
//        final int length = nums.length;
//        if (length <= 1) return length;
//        
//        final Map<Integer, Integer> elementIndexMap = new HashMap();
//        final UnionFind uf = new UnionFind(length);
//        for (int p = 0; p < length; p++) {
//            final int i = nums[p];
//            if (elementIndexMap.containsKey(i)) continue;
//            if (elementIndexMap.containsKey(i+1)) uf.union(p, elementIndexMap.get(i+1));
//            if (elementIndexMap.containsKey(i-1)) uf.union(p, elementIndexMap.get(i-1));
//            elementIndexMap.put(i, p);
//        }
//        return uf.getHighestRank();
//    }
//    
//    private final class UnionFind {
//        final private int[] sequenceTree;
//        final private int[] rank;
//        private int highestRank;
//        
//        UnionFind(int length) {
//            sequenceTree = new int[length];
//            rank = new int[length];
//            highestRank = 1;
//            for (int i = 0; i < length; i++) {
//                sequenceTree[i] = i;
//                rank[i] = 1;
//            }
//        }
//        
//        void union(int p, int q) {
//            final int pId = find(p); final int qId = find(q);
//            
//            if (pId == qId) return;
//            
//            int localHighestRank = 1;
//            if (rank[pId] < rank[qId]) {
//                sequenceTree[pId] = qId;
//                rank[qId] += rank[pId];
//                localHighestRank = rank[qId];
//            } else {
//                sequenceTree[qId] = pId;
//                rank[pId] += rank[qId];
//                localHighestRank = rank[pId];
//            }
//            highestRank = Math.max(highestRank, localHighestRank);
//        }
//        
//        int find(int p) {
//            while (p != sequenceTree[p]) {
//                sequenceTree[p] = sequenceTree[sequenceTree[p]];
//                p = sequenceTree[p];
//            }
//            return p;
//        }
//        
//        int getHighestRank() { return highestRank; }
//    }
	
	public static void main(String[] args) {
		LongestConsecutiveSequence s = new LongestConsecutiveSequence();
		int[] nums = {0,0};
		int res = s.longestConsecutive(nums);
		System.out.println( res);
	}
}
