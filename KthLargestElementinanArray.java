package algorithm_java;

import java.util.Random;

//Facebook Amazon Microsoft Apple Bloomberg Pocket Gems

//http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/

//quickselect
//best O(n), worst O(n^2)
//Discard half each time: n+(n/2)+(n/4)..1 = n + (n-1) = O(2n-1) = O(n), because n/2+n/4+n/8+..1=n-1.

public class KthLargestElementinanArray {
	public int findKthLargest(int[] array, int k) {
		return quickselect(array, 0, array.length - 1, k);
	}

	private int quickselect(int[] array, int left, int right, int k) {
		if (left <= right) {
			// select a pivotIndex between left and right
			//int pivotIndex = randomPivot(left, right); 
			int pivotIndex = left + new Random().nextInt(right - left + 1);
			pivotIndex = partition(array, left, right, pivotIndex);
			// The pivot is in its final sorted position
			if (k == pivotIndex) {
				return array[k];
			} else if (k < pivotIndex) {
				return quickselect(array, left, pivotIndex - 1, k);
			} else {
				return quickselect(array, pivotIndex + 1, right, k);
			}
		}
		return Integer.MIN_VALUE;
	}
	
	/**
	*	In quicksort, there is a subprocedure called partition that can, in 
	*	linear time, group a list (ranging from indices left to right) into two 
	*	parts, those less than a certain element, and those greater than or 
	*	equal to the element. Here is pseudocode that performs a partition about
	*	the element list[pivotIndex]
	*/
	private int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right); // move pivot to end
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(array[i] < pivotValue) {
				swap(array, storeIndex, i);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex); // Move pivot to its final place
		return storeIndex;
	}
	
	//solution II, an easier one
	public int findKthLargest_easy(int[] a, int k) {
	    int n = a.length;
	    int p = quickSelect(a, 0, n - 1, n - k + 1);
	    return a[p];
	  }
	  
	  // return the index of the kth smallest number
	  int quickSelect(int[] arr, int lo, int hi, int k) {
	    // use quick sort's idea
	    // put nums that are <= pivot to the left
	    // put nums that are  > pivot to the right	    
	    int pivot = arr[hi];
	    int i = lo;
        for (int j = lo; j < hi; j++){
            if (arr[j] <= pivot){
                swap(arr, i, j);
                i++;
            }
        }
	    
	    swap(arr, i, hi);
	    
	    // count the nums that are <= pivot from lo
	    int m = i - lo + 1;
	    
	    // pivot is the one!
	    if (m == k)     return i;
	    // pivot is too big, so it must be on the left
	    else if (m > k)
	    	return quickSelect(arr, lo, i - 1, k);
	    // pivot is too small, so it must be on the right
	    else            
	    	return quickSelect(arr, i + 1, hi, k - m);
	  }
	  
	  void swap(int[] a, int i, int j) {
	    int tmp = a[i];
	    a[i] = a[j];
	    a[j] = tmp;
	  }
	
	public static void main(String[] args) {
		KthLargestElementinanArray s = new KthLargestElementinanArray();
		int[] nums = {3,8,2,1,5,6,4};
		int res = s.findKthLargest_easy(nums, 3);
		System.out.println(res);
	}
}
