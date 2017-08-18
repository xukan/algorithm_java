package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class AmicablePairs {
	public List<int[]> findAmicable(int num) {
		List<int[]> res = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			int factorSum = getFactorSum(i);

			if (i < factorSum && factorSum <= num) {
				int factorSum2 = getFactorSum(factorSum);
				if (i == factorSum2) {
					res.add(new int[] { i, factorSum });
				}
			}
		}
		return res;
	}

	private int getFactorSum(int num) {
		int res = 1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				res += i;
				res += num / i;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		AmicablePairs s = new AmicablePairs();
		List<int[]> res = s.findAmicable(3000);
		for (int[] arr : res) {
			System.out.println(arr[0] + " " + arr[1]);
		}
	}
}
