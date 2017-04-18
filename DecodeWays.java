package algorithm_java;

//Microsoft Uber Facebook
//It is similar to the problem of counting ways of climbing stairs. The relation is dp[n]=dp[n-1]+dp[n-2].

//建立一个长度为input.length()的一维dp[]，依次考察（这里不能说每一位，因为每一次也要看两位）,分两种情况：
//1:考察第i位，如果字符c满足1<=c<=26,dp[i]=dp[i-1](与dp[i]+=dp[i-1]效果相同);
//2:考察第i-1到第i位(也就是看两位数)，如果满足编码条件，dp[i] += dp[i-2];
//还要注意的两点：
//1. 在循环的过程中,终止条件是i<=s.length(),因为substring()的原因,length()位是取不到的，所以不会越界
//2.对‘0’的处理，题目没有说清楚， 如果首位是'0',那么最终结果是0；如果中间出现'0',那么方法数计算到出现0的位置上，后面的不再计算了
public class DecodeWays {
	public int numDecodings(String s) {
        if( s.length() ==0 || s.charAt(0)=='0')
            return 0;
        if(s.length()==1) //i.e  input="1"
            return 1;
        int len = s.length();
        int[] dp = new int[len];
        dp[0]=1;
        if(Integer.parseInt(s.substring(0,2))>26){
        	if(s.charAt(1)!=0)
        		dp[1]=1;
        	else
        		dp[1]=0;
        }else{
        	if(s.charAt(1)!=0)
        		dp[1]=2;
        	else
        		dp[1]=1;
        }
        for(int i=2;i<len;i++){
            if(s.charAt(i)!='0'){
                dp[i]+=dp[i-1];
            int k = Integer.parseInt(s.substring(i-1, i+1));
            if(10<=k && k <=26)
                dp[i]+=dp[i-2];
            }
        }
        return dp[len-1];
    }

//	public static int numDecodings(String s) {
//		if (s.length() == 0 || s == null || s == "0")
//			return 0;
//
//		int[] dp = new int[s.length() + 1];
//		dp[0] = 1;
//
//		if (isValid(s.substring(0, 1)))
//			dp[1] = 1;
//		else
//			dp[1] = 0;
//
//		for (int i = 2; i <= s.length(); i++) {
//			if (isValid(s.substring(i - 1, i)))
//				dp[i] += dp[i - 1];
//			if (isValid(s.substring(i - 2, i)))
//				dp[i] += dp[i - 2];
//		}
//		return dp[s.length()];
//	}
//
//	public static boolean isValid(String s) {
//		if (s.charAt(0) == '0') // 如果首位是'0',那么最终结果是0；如果中间出现'0',那么方法数计算到出现0的位置上，后面的不再计算了
//			return false;
//		int code = Integer.parseInt(s);
//		return code >= 1 && code <= 26;
//	}

	public static void main(String[] args) {
		DecodeWays s = new DecodeWays();
		String str = "110";
		String str1="505";   // res =0
		String str2 ="5021"; //  res=0
		int res = s.numDecodings(str1);
		System.out.println(res);
	}
}
