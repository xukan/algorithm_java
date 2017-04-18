package algorithm_java;

import java.util.Arrays;

//Bloomberg Google Facebook
//reference:
//https://segmentfault.com/a/1190000003794831
public class HIndex {
	public static int hIndex(int[] citations) {
		int result = 0;    
	    for(int i=0; i<citations.length; i++){
	        int smaller = Math.min(citations[i], citations.length-i);
	        result = Math.max(result, smaller);
	    }
	 
	    /*
	     * for (int i = 0; i < n; i++)
				if (citations[i] >= n - i)
					return n - i;
	     * */
	    return result;
    }
	
	//II Facebook
	public int hIndexII(int[] citations) {
        int n = citations.length;
        if(n == 0) return 0;
        int min = 0, max = citations.length - 1;
        while(min <= max){
            int mid = (min + max) / 2;
            // 如果该点是有效的H指数，则最大H指数一定在右边
            if(citations[mid] < n - mid){
                min = mid + 1;
            // 否则最大H指数在左边
            } else {
                max = mid - 1;
            }
        }
        // n - min是min点的H指数
        return n - min;
    }

	
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		int res = hIndex(citations);
		System.out.println( res );
	}
}
