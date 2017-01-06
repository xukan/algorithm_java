package algorithm_java;

//rackspace
//http://blog.csdn.net/jmspan/article/details/53882635
public class MatchstickstoSquare {
	public boolean makesquare(int[] nums) {  
        if (nums == null || nums.length < 4) {  
            return false;  
        }  
        int sum = 0;  
        for(int num : nums) {  
            sum += num;  
        }  
        if (sum % 4 != 0) {  
            return false;  
        }  
        boolean res = find(nums, new int[4], 0, sum / 4);  
        return res;
    }  
    private boolean find(int[] nums, int[] sums, int step, int sum) {  
        if (step == nums.length) {  
            return true;  
        }  
        for(int i = 0; i < 4; i++) {  
        	int ele = nums[step];
            if (sums[i] + ele> sum)
            	continue;  
            if ( i > step)//说明输入数组中的数据有一个数比边长大
            	break;  
            sums[i] += ele;  
            boolean bar = find(nums, sums, step + 1, sum);
            if (bar) 
            	return true;
            sums[i] -= ele;  
        }  
        return false;  
    }  
	
	public static void main(String[] args) {
//		int[] input = {1,1,2,2,2};
//		int[] input = {3,3,3,3,4};
		//[5,5,5,5,4,4,4,4,3,3,3,3]
		int[] input = {5,1,5,5,4,9,4,4,3,3,3,2};
		MatchstickstoSquare s = new MatchstickstoSquare();
		boolean res = s.makesquare(input);
		System.out.println(res);
	}
}
