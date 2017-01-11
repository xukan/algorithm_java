package algorithm_java;

public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<=r){
            int m= l+(r-l)/2;
            if(nums[m]==target)
                return m;
            else if(nums[m]>target)
                r=m-1;
            else 
                l=m+1;
        }
        if(r==-1)
            r++;
        if(l>0 && nums[l-1]<target)
        	return l;
        return r;
    }
	
	public static void main(String[] args){
		int[] input={1,3,5,6};
		int res = searchInsert(input, 0);
		System.out.println(res);
	}
}
