package algorithm_java;

//Facebook

/*tc: O(n), two direction iteration
 * 举例理解此题方法 nums={2,3,4,5}
 * 从左向右遍历,
 *  0   1   2   3
 *  2   3   4   5
 *  1   2   6   24 
 *  res[0]设定为1,那么从左向右时res[i] = res[i-1]*nums[i-1];
 * 从右向左遍历
 *   0           1          2        3
 *   2           3          4        5
 * 2*60     3*20      6*5     24
 * 从右向左遍历需要一个辅助变量product, product的值是当前数字右边所有数字的乘积
 * */

public class ProductofArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
		if(nums.length == 0)
            return new int[0];
		int[] res = new int[nums.length];
        int len = nums.length;
        int cur = 1;       
        for(int i=0;i<len;i++){
            res[i] = cur;
            cur *= nums[i];
        }
        cur = 1;
        for(int i=len-1;i>=0;i--){
            res[i]*=cur;
            cur*=nums[i];
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,4,5};
		int[] res = productExceptSelf(nums);
		for(int i: res)
			System.out.print(i + " ");
	}
}
