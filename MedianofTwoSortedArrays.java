package algorithm_java;

//Google Zenefits Microsoft Apple Yahoo Dropbox Adobe


public class MedianofTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0;
        int m = nums1.length, n=nums2.length;
        double[] array = new double[m+n];
        int i=0, j=0, k=0;
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j])
                array[k++] = (double)nums1[i++];
            else
                array[k++] = (double)nums2[j++];
        }
        while(i<m)
            array[k++] = (double)nums1[i++];
        while(j<n)
            array[k++] = (double)nums2[j++];
        
        for(double a: array)
        	System.out.print(a + " ");
        
        return (k%2==0)? (array[k/2-1]+array[k/2])/2 : array[k/2];
    }
	
	public static void main(String[] args) {
		int[] nums1 = {3,6,7,8,9,10};
		int[] nums2 = {1,2,4,5};
		double res = findMedianSortedArrays(nums1, nums2);
		System.out.println( res );
	}
}
