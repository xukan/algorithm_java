package algorithm_java;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
	//solution1 , sort
	public int findUnsortedSubarray_sort(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) temp[i] = nums[i];
        Arrays.sort(temp);
        
        int start = 0;
        while (start < n  && nums[start] == temp[start]) start++;
        
        int end = n - 1;
        while (end > start  && nums[end] == temp[end]) end--;
        
        return end - start + 1;
    }
	
	/*
	public static int findUnsortedSubarray(int[] A) {
	    int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
	    for (int i=1;i<n;i++) {
	      max = Math.max(max, A[i]);
	      min = Math.min(min, A[n-1-i]);
	      if (A[i] < max)
	    	  end = i;
	      if (A[n-1-i] > min)
	    	  beg = n-1-i; 
	    }
	    return end - beg + 1;
	}
	*/
	
	//two passes solution, above solution is more concise than the below one, but the below one is easier to understand
	public static int findUnsortedSubarray(int[] nums) {
		int m = nums[0], n = nums.length, left = n, right = -1;
	    for (int i = 1; i < n; ++i) {
	        if (nums[i] < m)
	            right = i;
	        m = Math.max(m, nums[i]);
	    }
	    m = nums[n - 1];
	    for (int i = n - 1; i >= 0; --i) {
	        if (nums[i] > m)
	            left = i;
	        m = Math.min(m, nums[i]);
	    }
	    return Math.max(0, right - left + 1);
	}
	
	public static void main(String[] args) {
		int[] A ={ 2, 6, 4, 8, 10, 9, 15};
		int res = findUnsortedSubarray(A);
		System.out.println(res);
	}
}
