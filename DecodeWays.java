package algorithm_java;

//Microsoft Uber Facebook
//It is similar to the problem of counting ways of climbing stairs. The relation is dp[n]=dp[n-1]+dp[n-2].

//建立一个长度为input.length()的一维dp[]，依次考察（这里不能说每一位，因为每一次也要看两位）,分两种情况：
//1:考察第i位，如果字符c满足1<=c<=26,dp[i]=dp[i-1](与dp[i]+=dp[i-1]效果相同);
//2:考察第i-1到第i位(也就是看两位数)，如果满足编码条件，dp[i] += dp[i-2];
//还要注意的两点：
//1. 在循环的过程中,终止条件是i<=s.length(),因为substring()的原因,length()位是取不到的，所以不会越界
//2.对‘0’的处理，题目没有说清楚， 如果首位是'0',那么最终结果是0；
public class DecodeWays {
	public int numDecodings(String s) {
		//solutionI
		//dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1. 
		//I then check one digit and two digit combination and save the results along the way. In the end, dp[n] will be the end result.
		if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
	
	//solution II
	//O(1) space and O(n) time
	//similar to climbing stairs
	//solution II 的方法是solution I在空间上的优化
	public int numDecodings_better(String s) {
	    // empty string or leading zero means no way
	    if (s.length() == 0 || s.charAt(0) == '0')
	    	return 0;
	    // cur and prev store ways of the last and the last of the last
	    //对于第i位,只看第i-1(cur)和第i-2位(prev)
	    //计算出第i位后,prev,cur向前移动,prev记录i-1位,cur记录第i位
	    int cur = 1, prev = 1;
	    for (int i = 1; i < s.length(); i++) {
	        // zero voids ways of the last because zero cannot be used separately
	        if (s.charAt(i) == '0')
	        	cur = 0;
	        // possible two-digit letter
	        if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
	            int tmp = cur;
	        	cur = cur+prev;
	            prev = tmp;
	        }else {
	        	 // one-digit letter, no new way added
	        	prev= cur;
	        }
	    }
	    return cur;
	}
	
	public static void main(String[] args) {
		DecodeWays s = new DecodeWays();
		String str = "15";
		String str1="505";   // res =0
		String str2 ="5021"; //  res=0
		String str3 = "1108";
		String str4 ="121015";//4
		String str5 ="123015";//0
		int res = s.numDecodings_better(str);
		System.out.println(res);
	}
}
