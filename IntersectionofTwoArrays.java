package algorithm_java;

import java.util.*;

public class IntersectionofTwoArrays {
	
	/* solution 1 : map, set
	 * set works when we only want to get identical common elements, i.e. { 1,2 ,2, 5} {2, 2} ->{2}
	public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean > map = new HashMap<Integer, Boolean>();
        HashSet<Integer> set = new HashSet<Integer>();
        int len = Math.min( nums1.length, nums2.length);
 
        for( int i=0; i< nums1.length; i++){
            if( !map.containsKey( nums1[i]) )
                map.put( nums1[i], true );
        }
        for( int i=0; i< nums2.length; i++ ){
            if( map.containsKey( nums2[i] )  )
                set.add( nums2[i] );
        }
        int[] result = new int[ set.size() ];
        int k=0;
        for( Integer i : set){
            result[k] = i;
            k++;
        }
        return result;
	}
	*/
	
	/*solution2 : binary search*, exceed time limit/
	public boolean binarySearch( int[] nums1, int target ){
		int l=0, r= nums1.length-1;
		while( l <=r ){
			int m = l + ( r - l )/2;
			if( nums1[ m ] == target){
				return true;
			}else if( nums1[m] < target ){
				l = m + 1;
			}else{
				r =m-1;
			}
		}
		return false;
	}
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		HashSet<Integer> set = new HashSet<Integer>();
		for( int i : nums2){
			boolean find = binarySearch(nums1, i);
			if( find ){
				set.add(i);
			}
		}
		int[] result = new int[ set.size() ];
        int k=0;
        for( Integer i : set){
            result[k] = i;
            k++;
        }
        return result;
		
	}
	*/
	
	//sort & merge
	//Arrays.sort   O(nlogn)
	//we create temp array here
	//this solution also works when we want to get all common elements, i.e. { 1,2 ,2, 5} {2, 2} ->{2, 2}
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i=0, j=0, k=0;
		int size = Math.min(nums1.length, nums2.length);
		int[] temp = new int[nums1.length];
		while( i<nums1.length && j<nums2.length ){
			if( nums1[i] == nums2[j]  ){
				//on if block when we want to get all common elements
				if( k ==0 || (k > 0 && temp[ k-1] != nums1[i]))
					temp[k++] = nums1[i];
				i++;
				j++;
			}else if( nums1[i]<nums2[j]){
				i++;
			}else{
				j++;
			}
		}
		int[] result = new int[k];
		for( int n=0;n<k;n++)
			result[n] = temp[n];
		return result;
	}
		
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 5 };
		int[] nums2 = { 2, 2 };
//		int[] nums1 = { 4,7,9,7,6,7 };
//		int[] nums2 = { 5,0,0,6,1,6,2,2,4 };
		IntersectionofTwoArrays solution = new IntersectionofTwoArrays();
		int[] result = solution.intersection(nums1, nums2);
		for( Integer i : result )
			System.out.println( i + " " );
	}
}
