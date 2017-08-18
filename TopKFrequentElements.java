package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

//Pocket Gems Yelp

//comparison between PriorityQueue and TreeMap
//Generally speaking, it is less work to track only the minimum element, using a heap.
//A tree is more organized, and it requires more computation to maintain that organization
// More specifically a PriorityQueue allows you to peek at the head element in constant time. 
//A TreeMap requires O(logn) to peek. They both require O(logn) anytime you actually pop that element off

//similar question
//Sort Characters By Frequency

//solution1 : heap + hashmap
//tc : nO(logk)

class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num=num;
        this.count=count;
    }
}

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		//count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
 
        // create a min heap
        //default order is from small to large, here we provide a custom Comparator(compare Pair base on Pair.count)
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((Pair a, Pair b)->(a.count-b.count));
 
        //maintain a heap of size k. 
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if(queue.size()>k){
                queue.poll();
            }
        }
 
        //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while(queue.size()>0){
            result.add(queue.poll().num);
        }
        
        //reverse the order
        Collections.reverse(result);
 
        return result;
    }
	
	//solution 2 : bucket sort
	//tc: O(n)
	public List<Integer> topKFrequent_bucket_sort(int[] nums, int k) {
        if(k > nums.length)
            k %= nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        for(int n: nums){
        	int f = map.getOrDefault(n,0)+1;
            map.put(n, f);
            len = Math.max(len, f);
        }
        
        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[len+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }
        
        List<Integer> res = new LinkedList<>();
        for(int pos = bucket.length-1; pos >= 0; pos--){
            if(bucket[pos] != null){
                for(int i = 0; i < bucket[pos].size() && res.size() < k; i++)
                    res.add(bucket[pos].get(i));
            }
        }
        
        return res;
    }
	
	//solution 3: treemap
	public List<Integer> topKFrequent_treemap(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap();
        for(int i:nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        TreeMap<Integer, List<Integer>> treemap = new TreeMap();
        for(int num: map.keySet()){
            int f = map.get(num);
            if(!treemap.containsKey(f))
                treemap.put(f, new ArrayList<Integer>());
            treemap.get(f).add(num);
        }
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = treemap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,5,5,5,2,2,3};
		TopKFrequentElements s = new TopKFrequentElements();
		List<Integer> res = s. topKFrequent_bucket_sort(nums, 1);
		for(int i: res)
			System.out.print(i+" ");
	}
}
