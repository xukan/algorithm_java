package algorithm_java;

public class LongestRepeatingCharacterReplacement {
	public static int characterReplacement(String s, int k) {
		int len = s.length();
		int start = 0;
		int[] count = new int[26];
		int maxCount = 0, maxLen = 0;
		for(int end=0;end<len;end++){
			char c = s.charAt(end);
			int f = ++count[c-'A'];
			maxCount = Math.max(maxCount, f);
			while(end-start+1-maxCount>k){
				char ch = s.charAt(start);
				count[ch-'A']--;
				start++;
			}
			maxLen = Math.max(maxLen, end-start+1);
		}
		return maxLen;
    }
	
	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		int res = characterReplacement(s, k);
		System.out.println(res);
	}
}
