package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Google

public class FindKClosestElements {
	public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int lo = 0, hi = arr.size() - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int a = x - arr.get(mid);
            int b = arr.get(mid+k) - x; 
            if( a  > b)
                lo = mid + 1;
            else
                hi = mid;
        }
        return arr.subList(lo, lo + k);
    }
	
	//solutionII
	//O(logN + k) solution:
	//	We use binary search to find the nearest location of x in the array. This is logN.
	//	Then we expand on both sides using 2 pointers, to get the k nearest elements.
	public static List<Integer> findClosestElements_solii(List<Integer> arr, int k, int x) {
        if(x < arr.get(0))
        	return arr.subList(0, k);
        if(x > arr.get(arr.size()-1))
        	return arr.subList(arr.size()-k+1, arr.size());

        List<Integer> result = new ArrayList<>();
        int index = binSearch(arr, x);
        System.out.println(index);
        int i = 0; int j = 0;
        if(arr.get(index) == x) {
            result.add(x);
            i = index - 1;
            j = index + 1;
        } else {
            i = index - 1;
            j = index;
        }

        while(i >= 0 && j < arr.size() && result.size() != k) {
           if(Math.abs(arr.get(i) - x) <= Math.abs(arr.get(j) - x)) {
              result.add(0, arr.get(i--));
           } else {
               result.add(arr.get(j++));
           }
        }

        if(result.size() == k) {
        } else if(i < 0) {
            result.addAll(arr.subList(j, j + k - result.size()));
        } else {
            result.addAll(0, arr.subList(i+1-k+result.size(), i+1));
        }

        return result;
    }
    
      public static int binSearch(List<Integer> a, int target) {
        int st = 0;
        int end = a.size() - 1;
        while(st < end) {
            int mid = (st + end)/2;
            if(a.get(mid) == target) {
                return mid;
            } else if (a.get(mid) > target) {
                end = mid;
            } else {
                st = mid +1;
            }
        }
        return end;
    }
	
    public static void main(String[] args) {
    	List<Integer> nums =Arrays.asList(0,1,1,1,2,3,6,7,8,9);
		int k=9, x=4;
		List<Integer> res = findClosestElements(nums, k, x);
		res.forEach(i->System.out.print(i+ " "));
	}
}
