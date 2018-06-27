package algorithm_java;

//Google

/*
 * 这道题分两种情况讨论, 1.a>=0 , 2.a<0;
 * a>=0, 根据函数可知,是凹型曲线,那么结果就是从大向小记录
 * a<0, 同理是凸型曲线,结果从小向大记录
 * */

public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        //if a >=0, we iterate from the end of the result array
        //if a < 0, we iterate from the beginning of the result array
        int i = a >= 0 ? nums.length - 1 : 0;
        while(start <= end) {
            int startNum = getNum(nums[start], a, b, c);
            int endNum = getNum(nums[end], a, b, c);
            if(a >= 0){
                if(startNum >= endNum){
                    res[i--] = startNum;
                    start++;
                }else{
                    res[i--] = endNum;
                    end--;
                }
            }else{
                if(startNum <= endNum){
                    res[i++] = startNum;
                    start++;
                }else{
                    res[i++] = endNum;
                    end--;
                }
            }
        }
        return res;
    }
	
    public int getNum(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
    
    public static void main(String[] args) {
    	SortTransformedArray s = new SortTransformedArray();
    	int[] nums = {-4, -2, 2, 4};
    	int a = -1;
    	int b = 3;
    	int c = 5;
		int[] res = s.sortTransformedArray(nums, a, b, c);
		for(int i: res)
			System.out.print(i+" ");
	}
}
