package algorithm_java;

//Microsoft Bloomberg Facebook

public class MergeSortedArray {
	public static void merge(int[] A, int m, int[] B, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(k>=0){
            if(j<0 || (i>=0) && A[i] > B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        for(int x: A)
      	  System.out.print(x+" ");
    }
	
	public static void main(String[] args) {
		
//		int[] nums1= {1,2,3,0,0,0};
//		int[] nums2= {2,5,6};
		int[] nums1= {1,2,6,0,0,0};
		int[] nums2= {3,4,5};
		
		
		int m=3, n=3;
		merge(nums1, m, nums2, n);
	}
}
