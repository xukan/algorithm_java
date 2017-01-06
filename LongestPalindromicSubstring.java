package algorithm_java;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int l = 0, r = s.length()-1;
		String longest = s.substring(0, 1);
		for( int i=0;i<s.length();i++ ){
			String tmp = helper( s, i, i );
			if( tmp.length() > longest.length() )
				longest = tmp;
			tmp = helper( s, i, i+1 );
			if( tmp.length() > longest.length() )
				longest = tmp;
		}
		return longest;
    }
	
	public String helper( String s, int start, int end ){
		while( start >=0 && end <s.length() && s.charAt(start ) == s.charAt( end )){
			start--;
			end++;
		}
		return s.substring(start+1, end);
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubstring solution = new
				LongestPalindromicSubstring();
		String s = "adedbaccabh";
		String result = solution.longestPalindrome(s);
		System.out.println( result );
	}
}
