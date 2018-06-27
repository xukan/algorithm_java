package algorithm_java;

//Baidu Facebook 

//tc: O(n*log(sumOfArray - max))
//sc: O(1)
public class SplitArrayLargestSum {	
	public int splitArray(int[] nums, int m) {
        if(nums.length == 0 || m <0)
            return 0;
        int max = nums[0], sum = 0;
        for(int n: nums){
            max = Math.max(max, n);
            sum += n;
        }
        if(m == nums.length)
            return max;
        int l = max, r = sum;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isValid(nums, mid, m))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
    
    public boolean isValid(int[] nums, int target, int m){
        int sum = 0, count = 1;
        for(int n : nums){
            sum += n;
            if(sum > target){
                sum = n;
                count++;
                if(count > m)
                    return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		SplitArrayLargestSum s = new SplitArrayLargestSum();
//		int[] nums = {7,2,5,10,8};
//		int m = 2;
		
		int[] nums = {2,3,1,2,4,3};
		int m = 5;
		int res = s.splitArray(nums, m);
		System.out.println(res);
	}
}
