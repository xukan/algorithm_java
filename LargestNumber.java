package algorithm_java;

import java.util.Arrays;

//Works Applications

public class LargestNumber {
	public static String largestNumber(int[] nums) {
		int len = nums.length;
		String[] arr = new String[len];
		int k=0;
		for(int i: nums)
			arr[k++] = String.valueOf(i);
		//Define a comparator to compare strings by concat() right-to-left or left-to-right.
		Arrays.sort(arr, (a, b)->(b+a).compareTo(a+b));
		StringBuilder sb = new StringBuilder();
		for(String s: arr)
			sb.append(s);
		while(sb.charAt(0)=='0'  &&sb.length()>1 )
				sb.deleteCharAt(0);
		return sb.toString();
    }
	
	public static void main(String[] args) {
		int input[] = {3, 30, 34, 5, 9};
		String res = largestNumber(input);
		System.out.println(res);
	}
}
