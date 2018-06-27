package algorithm_java;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class FindMedianfromDataStream {
	//see MedianFinder
	private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;
    public FindMedianfromDataStream() {
    	minHeap = new PriorityQueue<Integer>();
    	maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() == 0)
            return 0;
        return maxHeap.size()==minHeap.size()?(double)(maxHeap.peek() + minHeap.peek())/2.0: (double)maxHeap.peek(); 
    }
    
    public static void main(String[] args) {
    	FindMedianfromDataStream m = new FindMedianfromDataStream();
		m.addNum(1);
		System.out.println(m.findMedian());
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
	}
}
