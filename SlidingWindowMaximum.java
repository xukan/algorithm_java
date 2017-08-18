package algorithm_java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

//Amazon Google Zenefits
//reference:
//https://segmentfault.com/a/1190000003903509

public class SlidingWindowMaximum {
	//solution1 : deque
	//tc: O(n)
	//sc: O(k)
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            //if(!deque.isEmpty() && deque.peekFirst() == i - k)
            if(!deque.isEmpty() && deque.peek() == i - k)
            	deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
//            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
            while(!deque.isEmpty() && nums[deque.get(deque.size()-1)] < nums[i])
            	deque.removeLast();
            // 加入新数
            deque.offer(i);
            // 队列头部就是该窗口内第一大的
            if((i + 1) >= k) 
            	res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }
	
	//solution 2 : MaxHeap
	//tc: O(nlogn)
	//sc: O(k)
	//结果数组的大小是nums.length + 1 - k， 赋值时下标也是i + 1 - k
//	public static int[] maxSlidingWindow(int[] nums, int k) {
//		if(nums == null || nums.length == 0)
//			return new int[0];
//
//        int len = nums.length;
//        int[] res = new int[len-k+1];
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b)->(b-a));
//        //PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
//        for(int i=0;i<len;i++){
//            queue.offer(nums[i]);
//            if(i>=k-1){
//            	res[i+1-k]=queue.peek();
//                queue.remove(nums[i+1-k]);
//            }
//        }
//        return res;
//    }
	
	public static void main(String[] args) {
        int [] a1 = {30, 10, 50, '#', '#', '#', 20, 45, '#', '#', 36, '#', '#'};
        int [] a2 = {3,3,5,5,6,7};
        int [] a3 = {1,3,1,2,0,5};
        int[] a4 = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(a4, 3);
        for(int i: res)
        	System.out.print(i+" ");
    }
}
