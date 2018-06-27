package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//Google

//similar question
//Find Median from Data Stream

public class SlidingWindowMedian {
	Queue<Integer> minHeap = new PriorityQueue<Integer>();
    Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> list = new ArrayList<Double>();
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
            if(i>=k-1){
                double median = getMedian();
                list.add(median);
                remove(nums[i-k+1]);
            }
        }
        double[] res = new double[list.size()];
        int i=0;
        for(double m: list)
            res[i++] = m;
        return res;
    }
    
    public void add(int n){
        maxHeap.offer(n);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public void remove(int target){
        if(maxHeap.contains(target))
            maxHeap.remove(target);
        else if(minHeap.contains(target))
            minHeap.remove(target);
        if(maxHeap.size()<minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double getMedian(){
        if(maxHeap.size()==minHeap.size())
            return ((double)maxHeap.peek()+(double)minHeap.peek())/2.0;  //[2147483647,2147483647]  k=2
        return (double)maxHeap.peek();
    }
    
    public static void main(String[] args) {
    	SlidingWindowMedian s = new SlidingWindowMedian();
    	int[] nums = {1,3,-1,-3,5,3,6,7};
    	int k = 3;
    	double[] res =  s.medianSlidingWindow(nums, k);
    	for(int i=0;i<res.length;i++)
    		System.out.println(res[i]);
	}
}
