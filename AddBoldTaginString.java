package algorithm_java;

//Google

public class AddBoldTaginString {
	//x is the average string length of dict
	public static String addBoldTag(String s, String[] dict) {
        int len = s.length();
        boolean[] dp = new boolean[len];
        for(String word: dict){
            for(int i=0;i<=len-word.length();i++){
                if(s.substring(i, i+word.length()).equals(word)){
                    for(int j=i;j<i+word.length();j++)
                        dp[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(dp[i]){
                sb.append("<b>");
                while(i<s.length() && dp[i]){
                    sb.append(s.charAt(i++));
                }
                sb.append("</b>");
            }else
                sb.append(s.charAt(i++));
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "haaabbcc";
		String[] dict = {"aaa", "aab", "bc"};
		String res = addBoldTag(s, dict);
		System.out.println(res);
	}
}
