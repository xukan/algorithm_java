package algorithm_java;

//https://segmentfault.com/a/1190000003709954

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//class SortQueueViaPriority implements Comparator<Integer> {
//    @Override
//    public int compare(Integer f1, Integer f2) {
//        return Integer.compare(f2, f1);
//    }
//}

//Find Median from Data Stream
public class MedianFinder {
	private PriorityQueue<Integer> minHeap;
	private PriorityQueue<Integer> maxHeap;
	
    MedianFinder(){
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<>((x, y)->(y-x));
        
//        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
//        	public int compare( Integer a, Integer b){
//        		return b-a;
//        	}
//        });
        
//        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
//       maxHeap = new PriorityQueue<Integer>(new SortQueueViaPriority());
        
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
    	maxHeap.offer(num);
    	minHeap.offer(maxHeap.poll());
    	//to make sure the whole sequence is in increasing order
    	if( maxHeap.size() < minHeap.size())
    		maxHeap.offer(minHeap.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
    	int size1 = maxHeap.size();
    	int size2 = minHeap.size();
       return (size1==size2)?((double)(maxHeap.peek()+minHeap.peek())/2.0): (double)maxHeap.peek();
    }
    
    public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		m.addNum(1);
		System.out.println(m.findMedian());
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
	}
}
