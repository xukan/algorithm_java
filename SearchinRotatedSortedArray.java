package algorithm_java;

//LinkedIn Bloomberg Uber Facebook Microsoft

public class SearchinRotatedSortedArray {
	public static int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<=r){
        	int m= l+(r-l)/2;
        	if(nums[m]==target){
        		return m;
        	}else if(nums[l]<=nums[m]){
        		if(nums[l]<=target && target <=nums[m])
        			r=m-1;
        		else
        			l=m+1;
        	}else{
        		if(nums[m]<=target && target <=nums[r]){
        			l=m+1;
        		}else
        			r=m-1;
        	}
        }
        return -l;
    }
	
	//duplicate elements allowed
	public static boolean searchII(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target)
                return true;
            if(nums[l]==nums[m]){
            	l++;
            }
            else if(nums[l]<nums[m]){
                if(nums[l]<= target && target <= nums[m])
                    r=m-1;
                else
                    l=m+1;
            }else{
                if(nums[m]<=target && target <= nums[r])
                    l=m+1;
                else
                    r=m-1;
            }
        }
        return false;
    }
	
	public static void main(String[] args){
		int[] input ={13,15,17,3,5,7,9,11};
		int[] input1 ={3,4,5,6,7,0,1,2};
		//int res = search(input, 15);
		//int res1 = search(input1, 7);
		//System.out.println(res1);
		
		//[1,3,1,1,1], 3
		int[] input3 ={1,3,1,1,1};
		boolean res2 = searchII(input3, 3);
		System.out.println(res2);
	}
}
