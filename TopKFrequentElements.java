package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//Pocket Gems Yelp

//reference:
//

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
	public List<Integer> topKFrequentSolution2(int[] nums, int k) {
        if(k > nums.length)
            k %= nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }
        
        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i]; 
                res.addAll(list);
                k-= list.size();
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		TopKFrequentElements s = new TopKFrequentElements();
		List<Integer> res = s.topKFrequent(nums, 2);
		for(int i: res)
			System.out.print(i+" ");
	}
}
