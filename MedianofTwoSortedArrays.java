package algorithm_java;

//Google Zenefits Microsoft Apple Yahoo Dropbox Adobe

public class MedianofTwoSortedArrays {
	// solution1
	// tc: O(m+n)
	public static double findMedianSortedArrays_basic(int[] nums1, int[] nums2) {
		double median = 0;
		int m = nums1.length, n = nums2.length;
		double[] array = new double[m + n];
		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (nums1[i] <= nums2[j])
				array[k++] = (double) nums1[i++];
			else
				array[k++] = (double) nums2[j++];
		}
		while (i < m)
			array[k++] = (double) nums1[i++];
		while (j < n)
			array[k++] = (double) nums2[j++];

		for (double a : array)
			System.out.print(a + " ");

		return (k % 2 == 0) ? (array[k / 2 - 1] + array[k / 2]) / 2 : array[k / 2];
	}

	// solution2
	// O(log(min(m,n)))
	// i + j == m-i+n-j+1  ==> j = (m+n+1)/2-i, since 0<=i<=m, n>=m ensures j>0
//	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//		int m = nums1.length, n = nums2.length;
//		if (m > n)
//			return findMedianSortedArrays(nums2, nums1);
//		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
//        while (iMin <= iMax) {
//            int i = (iMin + iMax) / 2;
//            int j = halfLen - i;
//            if (i < iMax && nums2[j-1] > nums1[i]){
//                iMin = iMin + 1; // i is too small
//            }else if (i > iMin && nums1[i-1] > nums2[j]) {
//                iMax = iMax - 1; // i is too big
//            }else { // i is perfect
//                int maxLeft = 0;
//                if (i == 0)
//                	maxLeft = nums2[j-1];
//                else if (j == 0)
//                	maxLeft = nums1[i-1];
//                else
//                	maxLeft = Math.max(nums1[i-1], nums2[j-1]);
//                if ( (m + n) % 2 == 1 )
//                	return maxLeft;
//                //if total length is even, then we need to find minRight and median = (maxLeft + minRight)/2;
//                int minRight = 0;
//                if (i == m)
//                	minRight = nums2[j];
//                else if (j == n)
//                	minRight = nums1[i];
//                else
//                	minRight = Math.min(nums2[j], nums1[i]);
//                return (maxLeft + minRight) / 2.0;
//            }
//        }
//        return 0.0;
//	}

	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if(len1>len2)
            return findMedianSortedArrays(nums2, nums1);
        int iMin = 0, iMax = len1;
        int halfLen = (len1+len2+1)/2;;
        while(iMin <= iMax){
            int i= (iMin + iMax)/2;
            int j = halfLen - i;
            if(i>iMin && nums1[i-1]>nums2[j])
                iMax -=1;
            else if(i<iMax && nums2[j-1]>nums1[i])
                iMin +=1;
            else{
                int maxLeft =0;
                if(i==0)
                    maxLeft = nums2[j-1];
                else if(j==0)
                    maxLeft = nums1[i-1];
                else
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                if((len1+len2)%2==1)
                    return maxLeft;
                int minRight = 0;
                if(i==len1)
                    minRight = nums2[j];
                else if(j==len2)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }

	public static void main(String[] args) {
		int[] nums1 = { 3, 6, 7, 8, 9, 10 };
		int[] nums2 = { 1, 2, 4, 5 };
//		int[] nums1 = { 1,3 };
//		int[] nums2 = { 2 };
		
		double res = findMedianSortedArrays(nums1, nums2);
		System.out.println(res);
	}
}
