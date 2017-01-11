package algorithm_java;

//Microsoft

public class JumpGame {
	//JumpGameI
	public static boolean canJump(int[] nums) {
		int reach =0;
		for(int i=0;i<=reach && i<nums.length;i++){
			int curStep = nums[i];
			int local = i+curStep;
			reach = Math.max(reach, local);
			if(reach >= nums.length)
				return true;
		}
		return false;
	}
	
	//JumpGameII
	public static int jump(int[] A) {
		if(A==null || A.length==0)  
	        return 0;  
	    int lastReach = 0;  
	    int reach = 0;  
	    int step = 0;  
	    for(int i=0;i<=reach&&i<A.length;i++)  
	    {  
	        if(i>lastReach)  
	        {  
	            step++;  
	            lastReach = reach;  
	        }  
	        reach = Math.max(reach,A[i]+i);  
	    }  
	    if(reach<A.length-1)  
	        return 0;  
	    return step;
    }
	
	public static void main(String[] args){
		/************Jump Game I************/
		//int[] input = {3,2,1,1,4};
		//2,3,1,1,4
		//3,2,1,0,4
		//int[] input = {2,3,1,1,4};
		//int[] input = {3,2,1,0,4};
//		int[] input = {3,1,0,1,1};
//		boolean res = canJump(input);
//		System.out.println(res);
		/************Jump Game I************/
		
		/************Jump Game II************/
		int[] A = {2,3,3,2,0,4};
		int min = jump(A);
		System.out.println(min);
		/************Jump Game II************/
	}
}
