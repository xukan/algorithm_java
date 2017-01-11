package algorithm_java;
//Search Insert Position

//LinkedIn

public class SearchforaRange {
	public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1}; 
        if(nums==null || nums.length==0)
            return res;
        int len = nums.length;
        int l=0,r=nums.length-1;
        boolean find1=false, find2=false;
        while(l<=r){
            int m= l+(r-l)/2;
            if(nums[l]>target)
                break;
            if(nums[m]==target)
            	find1=true;
            if(nums[m]<=target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        int l1=0, r1=nums.length-1;
        while(l1<=r1){
            int m=l1+(r1-l1)/2;
            if(nums[r]<target)
                break;
            if(nums[m]==target)
            	find2=true;
            if(nums[m]>=target){
                r1=m-1;
            }else{
                l1=m+1;
            }
        }
        if(find1 && find2){
    	res[0]=r1+1;
    	res[1]=l-1;
        }
        
        return res;
    }
	
	public static void main(String[] args){
		//int[] input ={1,2,3,3,3,5,7,9,10};
		int[] input ={1};
		int[] res =  searchRange(input, 0);
		for(int i:res)
			System.out.print(i+" ");
	}
}
