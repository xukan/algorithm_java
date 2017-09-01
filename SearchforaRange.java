package algorithm_java;
//Search Insert Position
//用到二分查找的一个结论：如果没有找到目标元素，那么当停止时，L恰好停在比目标元素位置大的index上，R恰好停在比目标元素位置小的index上。
//实现中用到了在Search Insert Position中提到的方法，可以保证当搜索结束时，l和r所停的位置正好是目标数的后面和前面。

//LinkedIn

public class SearchforaRange {
	public static int[] searchRange(int[] nums, int target) {
		int[] res = {-1, -1};
        if(nums.length == 0)
            return res;
        boolean find1 = false, find2 = false;
        int ll = 0, lr= nums.length-1; //find left boundary
        while(ll<=lr){
            int m = ll + (lr-ll)/2;
            if(nums[m] == target)
                find1 = true;
            if(nums[m] >= target)
                lr = m - 1;
            else
                ll = m + 1;
        }
        int rl = 0, rr = nums.length-1; // find right boudary
        while(rl <= rr){
            int m = rl + (rr-rl)/2;
            if(nums[m] == target)
                find2 = true;
            if(nums[m] <= target)
                rl = m + 1;
            else
                rr = m - 1;
        }
        if(find1 && find2){
            res[0] = ll;
            res[1] = rr;
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
