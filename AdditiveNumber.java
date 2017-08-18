package algorithm_java;

//https://segmentfault.com/a/1190000006080854

public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		int len = num.length();
        for (int i = 1; i <=  len/ 2; ++i) {
        	//0 can only appear as a single number, "022" is good since 0+2=2, but "02" is not good
            if (num.charAt(0) == '0' && i > 1) break;
            //j-i<=len-j 确保剩余数字的长度>=加数
            for (int j = i + 1; j<=(len+i)/2; ++j) {
                if (num.charAt(i) == '0' && j - i > 1) break;
                if (dfs(num, 0, i, j)) return true;
            }
        }
        return false;
    }

    // 判断从 [i, j) 和 [j, k) 出发,能否走到尽头
    private static boolean dfs(String num, int i, int j, int k) {
        long num1 = Long.parseLong(num.substring(i, j));
        long num2 = Long.parseLong(num.substring(j, k));
        String addition = String.valueOf(num1 + num2);

        if (!num.substring(k).startsWith(addition)) return false;
        if (k + addition.length() == num.length()) return true;
        return dfs(num, j, k, k + addition.length());
    }
	
	public static void main(String[] args) {
		AdditiveNumber s = new AdditiveNumber();
		//String str = "199100199";
		//String str = "12305611";
		String str = "0235813";
		boolean res = s.isAdditiveNumber(str);
		System.out.println(res);
	}
}
