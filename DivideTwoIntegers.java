package algorithm_java;

//This problem can be solved based on the fact that any number can be converted to the format of the following:
//res=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n, so a_0, a_1 are integers
// 7 =  1 + 2 + 4
// 9 = 1+ 8(2^3)
//here, we need to find divisor res which satisfies  dividend >= divisor*res,  res = a_0*1 + a_1*2^1 + a_2*2^2 + ... + a_n*2^n;
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == -1 && dividend == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		if (dividend == 0 || divisor == 0) {
			return 0;
		}
		boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		int result = 0;
		// bit operation, easier to understand
		while (a >= b) {
			int shift = 0;
			while (a>=(b << shift)) {
				shift++;
			}
			result += (1 << (shift - 1));
			a -= (b << (shift - 1));
		}
		return isNeg ? -result : result;
	}

	public static void main(String[] args) {
		DivideTwoIntegers s = new DivideTwoIntegers();
		int res = s.divide(10, 3);
		System.out.print(res);
		System.out.println();
	}
}
