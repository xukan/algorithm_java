package algorithm_java;

//Microsoft Bloomberg 

//similar question
//First Missing Positive

public class MissingNumber {
	public static int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int cur = nums[i];
            if(cur<n && nums[cur]!=cur){
                int tmp = nums[cur];
                nums[cur] = cur;
                nums[i] = tmp;
                i--;
            }
        }
        for(int i=0;i<n;i++)
            if(nums[i] != i)
                return i;
        return n;
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 3};
		int m = missingNumber(nums);
		System.out.println(m);
	}
}
