package algorithm_java;

import java.util.*;

//Two Sigma

public class IntersectionofTwoArrays {
	//solution1 : binary search + sort  
	//tc:  O(nlogn)
	//sc:  O(n)
	public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList();
        for(int i=0;i<nums2.length;i++){
            if(i>0 && nums2[i]==nums2[i-1])
                continue;
            boolean bar = search(nums1, nums2[i]);
            if(bar)
                list.add(nums2[i]);
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i] = list.get(i);
        return res;
    }
    
    public boolean search(int[] nums, int target){
        int l=0, r=nums.length-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m ] == target)
                return true;
            else if( nums[m] < target)
                l = m+1;
            else
                r = m-1;
        }
        return false;
    }
    
    //solution 2: hashSet
    //tc:  O(n)
    //sc:  O(n)
    public int[] intersectionI(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)
            return new int[0];
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int i: nums1)
            set1.add(i);
        for(int i: nums2){
            if(set1.contains(i))
                set2.add(i);
        }
        int[] res = new int[set2.size()];
        int i=0;
        for(int n: set2)
            res[i++] = n;
        return res;
    }
    
    //II: two pointers
    public int[] intersectII(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length ==0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        List<Integer> list = new ArrayList();
        while(i<nums1.length && j< nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        int k=0;
        for(int n: list)
            res[k++] = n;
        return res;
    }
    
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 5 };
		int[] nums2 = { 2, 2 };
//		int[] nums1 = { 4,7,9,7,6,7 };
//		int[] nums2 = { 5,0,0,6,1,6,2,2,4 };
		IntersectionofTwoArrays s= new IntersectionofTwoArrays();
		int[] result = s.intersection(nums1, nums2);
		for( int i : result )
			System.out.println( i + " " );
		System.out.println();
		
		int[] res = s.intersectII(nums1, nums2);
		for( int i: res)
			System.out.print(i + " ");
	}
}
