package algorithm_java;

import java.util.HashMap;

public class ArithmeticSlices {
	public static int numberOfArithmeticSlices(int[] A) {
//brute force solution
//        int res= 0;
//        int num = 3;
//        int len = nums.length;
//        for(int i=num;i<=len;i++){
//            for(int j=1;j<len;j++){
//                int diff = nums[j] - nums[j-1];
//                int count =1;
//                for(int k=j;count<i&&k<len;k++){
//                    if(nums[k]-nums[k-1] == diff)
//                        count++;
//                    else
//                    	break;
//                }
//                if(count == i)
//                    res++;
//            }
//        }
//        return res;
//    }

//		Aetion Baidu 
		//http://blog.csdn.net/mebiuw/article/details/52876206
		//http://www.cnblogs.com/grandyang/p/5968340.html
		//实质上是在找等差数列个数(arithmetic sequence)
		int curr = 0, sum = 0;
	    for (int i=2; i<A.length; i++)
	        if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
	            curr += 1;
	            sum += curr;
	        } else {
	        	//sum = (1+curr)*curr/2;
	            curr = 0;
	        }
	    return sum;
	}
	
	//Baidu 
	//II Arithmetic Slices II - Subsequence
	//we need to understand <key, value> pair in map.
    //key is diff,
    //value is the number of times this diff appears till current number.
	/*   for example, if input array = {2,4,6,8,10}
	 *    2      4         6        8       10
	 *   {}  {2=1} {2=2} {2=3} {2=4}
	 *                   {4=1} {4=1} {4=2}
	 *                             {6=1} {6=1} 
	 *   so when current iterator arrives 10, we have 2=4, which mean diff=2 appear 4 times,
	 *   then the arithmetic sequence is C43 = 3
	 * */
	
	public static int numberOfArithmeticSlicesII(int[] A) {
        int re = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for(int i=0; i<A.length; i++) {
            maps[i] = new HashMap<>();
            int num = A[i];
            for(int j=0; j<i; j++) {
                if((long)num-A[j]>Integer.MAX_VALUE) continue;
                if((long)num-A[j]<Integer.MIN_VALUE) continue;
                int diff = num - A[j];
                int count = maps[j].getOrDefault(diff, 0);
                maps[i].put(diff, maps[i].getOrDefault(diff,0)+count+1);
                re += count;
            }
        }
        return re;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,7,8,9,10};
		int res1 = numberOfArithmeticSlices(nums1);
		System.out.println(res1);
		int[] nums2 = {2,4,6,8,10};
		int  res2 = numberOfArithmeticSlicesII(nums2);
		System.out.println(res2);
	}
}
