package algorithm_java;

import java.util.HashMap;

/*
 * 整数部分很好处理，只要注意正负号的区分就行了，但是如何处理小数部分呢。
 * 如果只是简单的除法，那我们每次把余数乘以10，再除以被除数就可以得到当前位的小数了，得到新的余数，直到余数为0。
 * 难点在于，对于无尽循环小数，我们一直这么做永远也不能让余数变为0。
 * 这里我们可以用一个哈希表记录每次的余数，如果余数出现重复的时候，说明就产生循环了。
 * 为了能找出小数中循环的部分，我们在用哈希表时，还要把每个余数对应的小数位记录下来，这样子我们一旦遇到重复，就知道是从哪里开始循环的。

注意
如果输入的被除数很大，那么余数乘以10有可能溢出，所以我们用long来保存numerator和denominator。
 * 
 * */

//https://segmentfault.com/a/1190000003794677
public class FractiontoRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";
	 
		String result = "";
	 
		// is result is negative
		if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}
	 
		// convert int to long
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
	 
		// quotient 
		long res = num / den;
		result += String.valueOf(res);
	 
		// if remainder is 0, return result
		long remainder = (num % den) * 10;
		if (remainder == 0)
			return result;
	 
		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result += ".";
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder); 
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}
	 
			// continue
			map.put(remainder, result.length());
			res = remainder / den;
			result += String.valueOf(res);
			remainder = (remainder % den) * 10;
		}
	 
		return result;
	}
	
	public static void main(String[] args) {
		String res = fractionToDecimal(2, 3);
		System.out.println(res);
	}
}
