package algorithm_java;

public class ValidPerfectSquare {
	public static boolean isPerfectSquare(int num) {
		long left = 1, right = num;// long type to avoid 2147483647 case

		while (left <= right) {
			long mid = left + (right - left) / 2;
			long t = mid * mid;
			if (t > num) {
				right = mid - 1;
			} else if (t < num) {
				left = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int num = 36;
		boolean res = isPerfectSquare(num);
		System.out.println(res);
	}
}
