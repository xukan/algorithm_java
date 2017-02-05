package algorithm_java;

//This problem can be solved based on the fact that any number can be converted to the format of the following:
//num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
//here, we need to find divisor res which satisfies num >= res * (2^n + 2^(n-1) + 2^(n-2) ...)
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
			while ((b << shift) <= a) {
				shift++;
			}
			result += (1 << (shift - 1));
			a -= (b << (shift - 1));
		}

		// long sum = 0;
		// long pow = 0;
		// while(a>=b){
		// pow = 1;
		// sum = b;
		// while (sum + sum <= a) {
		// sum += sum;
		// pow += pow;
		// }
		// a -= sum;
		// result += pow;
		// }

		return isNeg ? -result : result;
	}

	public static void main(String[] args) {
		DivideTwoIntegers s = new DivideTwoIntegers();
		int n = 4;
		int res = s.divide(10, 3);
		System.out.print(res);
		System.out.println();
	}
}
