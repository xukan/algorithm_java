package algorithm_java;

//yelp

public class LongestCommonPrefix {
	//my solution
	//first, we get the length of shortest string
	//then, we get longest common prefix
//	public String longestCommonPrefix(String[] strs) {
//		if( strs.length == 1)
//            return strs[0];
//        StringBuilder sb = new StringBuilder();
//        int len= Integer.MAX_VALUE;
//        for( int i=0; i< strs.length; i++){
//        	int l = strs[i].length();
//        	len = Math.min(len, l);
//        }
//        boolean flag = false;
//        for( int i=0;i<len;i++){
//        	for( int j=1;j<strs.length;j++){
//        		if( strs[j].charAt(i) == strs[j-1].charAt(i)){
//        			flag = true;
//        		}else{
//        			flag = false;
//        			break;
//        		}
//        	}
//        	if( flag )
//        		sb.append(strs[0].charAt(i));
//        	else
//        	    break;
//        }
//        return sb.toString();
//    }
	
	//a easier soltuion
	
	public String longestCommonPrefix(String[] strs) {
		if( strs.length < 1 || strs == null)
			return "";
		for( int i=0;i<strs[0].length();i++){
			char x = strs[0].charAt(i);
			for( int j=1;j<strs.length;j++){
				if( strs[j].length() == i || strs[j].charAt(i)!=x)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
	
	public static void main(String[] args) {
		String[] strs = { "abcbd", "abeee","abgggg"};
		LongestCommonPrefix solution = new LongestCommonPrefix();
		String prefix = solution.longestCommonPrefix(strs);
		System.out.println(prefix);
	}
}
