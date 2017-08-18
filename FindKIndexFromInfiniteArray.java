package algorithm_java;

//http://www.ardendertat.com/2011/11/21/programming-interview-questions-17-search-unknown-length-array/
//http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/
//https://segmentfault.com/a/1190000008598812
//http://beginnersbook.com/2013/04/throw-in-java/

public class FindKIndexFromInfiniteArray {
	class NotFoundException extends Exception{
		public NotFoundException(String msg){
			super(msg);
		}
	}
	
	public int solution(int[] array, int target) throws NotFoundException{
		if(array == null || array.length == 0)
			return -1;
		int k = 1;
		int n = array.length;
		while(array[k]<=target){
			if(array[k] ==target)
				return k;
			k*=2;
			if(k>n)
				throw new NotFoundException("out of boundary");
		}
		int res = binarySearch(array, target, k/2, k);
		return res;
    }
    /** 二分查找*/
    private int binarySearch(int[] array, int target, int low, int high) {
        int left = low, right = high - 1;
        /* 如果这里是 int right = n 的话，那么下面有两处地方需要修改，以保证一一对应：    
         * 1、下面循环的条件则是while(left < right)    
         * 2、循环内当array[middle]>value 的时候，right = mid 
         */
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(array[mid] == target)
            	return mid;
            else if(array[mid] > target)
            	right = mid - 1;
            else if(array[mid] < target)
            	left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
    	FindKIndexFromInfiniteArray s = new FindKIndexFromInfiniteArray();
        int[] nums = {1,2,3,4,7,9,11,18,20,31,36,65,100, 120,150};
        try{
        	int res = s.solution(nums, 170);
        	System.out.println(res);
        }catch(NotFoundException e){
        	e.printStackTrace();
        }
    }
}
