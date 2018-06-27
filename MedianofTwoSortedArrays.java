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
	//https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation?page=1
	/*
	 * A. Since C1 and C2 can be mutually determined from each other, we can just move one of them first, 
	 * then calculate the other accordingly. However, it is much more practical to move C2 (the one on the shorter array) first. 
	 * The reason is that on the shorter array, all positions are possible cut locations for median, but on the longer array, 
	 * the positions that are too far left or right are simply impossible for a legitimate cut. For instance, [1], [2 3 4 5 6 7 8]. 
	 * Clearly the cut between 2 and 3 is impossible, because the shorter array does not have that many elements to balance out 
	 * the [3 4 5 6 7 8] part if you make the cut this way. Therefore, for the longer array to be used as the basis for the first cut, 
	 * a range check must be performed. It would be just easier to do it on the shorter array, which requires no checks whatsoever. 
	 * Also, moving only on the shorter array gives a run-time complexity of O(log(min(N1, N2)))
	 * B. The only edge case is when a cut falls on the 0th(first) or the 2Nth(last) position. 
	 * For instance, if C2 = 2N2, then R2 = A2[2*N2/2] = A2[N2], which exceeds the boundary of the array. 
	 * To solve this problem, we can imagine that both A1 and A2 actually have two extra elements, 
	 * INT_MAX at A[-1] and INT_MAX at A[N]. These additions don't change the result, but make the implementation easier: 
	 * If any L falls out of the left boundary of the array, then L = INT_MIN, and if any R falls out of the right boundary, 
	 * then R = INT_MAX.
	 * */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        if (N1 > N2) return findMedianSortedArrays(nums2, nums1);

        int lo = 0, hi = 2 * N1;
        while (lo <= hi) {
            int C1 = (lo + hi) / 2;
            int C2 = N1 + N2 - C1;

            double L1 = (C1 == 0) ? Integer.MIN_VALUE : nums1[(C1-1)/2];
            double R1 = (C1 == 2*N1) ? Integer.MAX_VALUE : nums1[C1/2];
            double L2 = (C2 == 0) ? Integer.MIN_VALUE : nums2[(C2-1)/2];
            double R2 = (C2 == 2*N2) ? Integer.MAX_VALUE : nums2[C2/2];

            if (L1 > R2)
            	hi = C1 - 1;
            else if(L2 > R1)
            	lo = C1 + 1;
            else
            	return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 7, 8, 9, 10 };
		int[] nums2 = { 1, 2, 4, 6 };
//		int[] nums1 = { 1,3 };
//		int[] nums2 = { 2 };
		
		double res = findMedianSortedArrays(nums1, nums2);
		System.out.println(res);
	}
}
