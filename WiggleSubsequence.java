package algorithm_java;

//http://www.cnblogs.com/grandyang/p/5697621.html

public class WiggleSubsequence {
	public static int wiggleMaxLength(int[] nums) {
        int p = 1, q = 1, n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1])
                p = q + 1;
            else if (nums[i] < nums[i - 1])
                q = p + 1;
        }
        return Math.min(n, Math.max(p, q));
    }
	
	public static void main(String[] args) {
		int[] input = {1,17,5,10,13,15,10,5,16,8};
		//Output: 7
		//There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
		int res = wiggleMaxLength(input);
		System.out.println(res);
	}
}
