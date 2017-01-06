package algorithm_java;

/*
 * Since the original array is sorted, we can see nums[low] >=nums[high] after we rotate the array by the pivot.
 * i.e. [1,2,3] ==rotate==> [3,1,2] or [2,3,1]
 * so we can use binary search to find the minimum element.
 * we need to consider two cases.
 * Case 1, nums[mid] > nums[high]
 * which means nums[mid] is from the part after pivot, since original array is in increasing order,
 * nums before mid are all bigger than numbers after mid, which means min exists in [low=mid, high]
 * Case 2, nums[mid] <= nums[high]
 * which means [mid, high] part is sorted, so minimun exists in [low, high=mid-1]
 * */

//Microsoft

public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		int l =0, r= nums.length-1;
		while(l<r){
			int m = l+(r-l)/2;
			if(nums[m]>nums[r]){
				l = m+1;//如果nums[mid]>nums[r]，说明最小值一定在[mid+1, r]之间，nums[mid]一定不是最小值
			}else
				r=m;//nums[mid]<=nums[r],说明最小值在[l, mid]之间，nums[mid]有可能就是最小值,因此此处r 不能设定为m-1
		}
		return nums[l];
	}
	
	//What if duplicates are allowed?
	public int findMinII(int[] nums) {
		int l=0, r=nums.length-1;
        while(l<r){
            int m= l+(r-l)/2;
            if(nums[m]>nums[r]){
                l=m+1;
            }else if(nums[m] < nums[r]){
                r=m;
            }else if(nums[m] == nums[r])
            	r--;//when nums[m] equals with nums[r], it is fine to remove rightmost element
        }
        
        return nums[l];
	}
	
	//Find Peak Element
	//Microsoft Google
	/*
	 * binary search
	 * we just need to any one of peak elements
	 * if(nums[mid]<=nums[mid+1]) means peak element exists in [mid+1, nums.length)
	 * if(nums[mid]>nums[mid+1]) means peak element exists in [ l(this is left boundary), nums[mid]]
	 * */
	public int findPeakElement(int[] nums) {
        int low=0, high=nums.length-1;
        while(low<high){
            int m=low+(high-low)/2;
            if(nums[m]<nums[m+1])
                low=m+1;
            else
                high=m;
        }
        return low;
    }
	
	
	public static void main(String[] args) {
		FindMinimuminRotatedSortedArray s = new FindMinimuminRotatedSortedArray();
		int[] nums1 = {6,7,8,1,2,3,4,5};
		int[] nums2 = {3,3,1,3};
    	//int res = s.findMin(nums1);
		//System.out.println(res);
		int min= s.findMinII(nums2);
    	System.out.println(min);
    }
}
