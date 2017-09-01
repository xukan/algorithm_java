package algorithm_java;

//Google Uber Airbnb Facebook Twitter

/*
 * '.' Matches any single character.
'*' Matches zero or more of the preceding element.
 * */

/*http://blog.csdn.net/yangliuy/article/details/43834477
 * 思路分析：这题是正则表达式匹配，比较好的解法是用动态规划，令s和p的长度为m和n，
 * 我们可以定义(m+1)*(n+1)维数组dp[i][j]用于记录s的前i个字符与p的前j个字符是否可以匹配，
 * 前面增加的一维用于记录s为空或者p为空的情况，那么递推公式的思考分以下几种情况
 * 1 如果p[j-1] != * (注意p的第j个字符的index是j-1)，则当dp[i-1][j-1]为true并且s[i-1]=p[j-1]或者p[j-1]='.'时，dp[i][j]为true，否则是false
 * 2 如果p[j-1] == *
 * 情况一：当dp[i-1][j]为true并且s[i-1]=p[j-2]或者p[j-2]='.'时，dp[i][j]为true，否则是false.
 * 这种情况对应我们已经知道p的前j个字符可以匹配s的前i-1个字符，
 * 这时只需要p的第j-1个字符(index为j-2)与s的第i个字符(index是i-1)相等或者p的第j-1个字符为'.'即可完成匹配。
 * 至于为何这里是判断dp[i-1][j]是否为true而不是判断dp[i-1][j-1]是否为true，
 * 可以考虑一个例子 aaa与a*的匹配，当p第2个字符为*时(j=2)，我们需要把前2(j)个字符全部拿到做匹配，
 * 否则单单用a是无法匹配aa的，就会出现判断错误。
 * aaa与a*
 *     a *
 * 	  t f t
 * a f t t
 * a f f t
 * a f f ?
 * 看上面这个例子，在判断?这个值的时候，如果是dp[i-1][j-1]，就是false, aa无法匹配a，因为*可以代表前一个字符的0到多次重复(a*), 因此考虑dp[i-1][j]，就把*的作用考虑在内了
 * 这样aa是和a*匹配的,并且aaa中的第三个是a，a*中的第一个也是a，所以aaa匹配a*。对比情况2和情况3,这里是让*表示多个(>=1)前面的字符
 * 情况二：当dp[i][j-1]为true时，dp[i][j]为true，此时我们让*表示只有一个前面的字符。
 * 情况三：当dp[i][j-2]为true时，dp[i][j]为true，此时我们让*表示0个前面的字符。注意c*可以匹配成空，题目最后一个例子就出现这种情况，*可以和前面一个字符一起解释，让前面一个字符消失。
 * 其他情况 dp[i][j] 为false.
 * 把递推的规则想清楚了，实现就很容易了，只需要注意dp数组的index和s p的index的含义区别即可。
 * 再看一个例子
 *                c       *       a       *       b  
 *      true | false | true | false| true | false 
 * a | false | false | false| true | true | false 
 * a | false | false | false| false| true | false 
 * b | false | false | false| false| false| true 
 * 
 * 同类型的题还有wildcard matching, edit distance, Interleaving String, Regular Expression Matching
 * */

public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
//        for(int i=1;i<=len1;i++){
//			dp[i][0] = false;
//		}
        for(int j=1;j<=len2;j++){
            if(j>=2 && p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-2];
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(p.charAt(j-1)!='*'){
                    if(dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'))
                        dp[i][j] = true;
                }else{
                    if(dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'))
                       dp[i][j] = true;
                 // dp[i][j-1] = true means '*' mataches 1 preceding element,  i.e  ba*  just left b
                 // dp[i][j-2] = true means '*' mataches 0 preceding element,  i.e. a* just has a single a
                    if(dp[i][j-1] || dp[i][j-2])  
                       dp[i][j] = true;
                }
            }
        }
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++)
            	System.out.print( dp[i][j] + " ");
            System.out.println();
       }
        
        return dp[len1][len2];
    }
	
	 public static void main(String[] args){
//	    boolean res = isMatch("aaaab", "a.*ab*");
//    	boolean res = isMatch("aaa", ".*");
		 boolean res = isMatch("aab", "c*a*b");
    	System.out.println(res);
	 }
}
