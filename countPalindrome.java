package algorithm_java;

public class countPalindrome {
	public int countPalindroms(String str) {
		if(str == null || str.length() == 0)
			return 0;
		int count = 1;
		for(int i=1;i<str.length();i++){
			int c1 = isValid(str, i, i);
				count+=c1;
			int c2 = isValid(str, i-1, i);
				count+=c2;
		}
		return count;
	}
	
	public int isValid(String s, int low, int hi){
		int l = low, r = hi;
		int res = 0;
		while(l>=0 && r<s.length() &&s.charAt(l) == s.charAt(r)){
			l--;
			r++;
			res++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		countPalindrome s = new countPalindrome();
//		String str = "hellolle";
		String str = "wowpurerocks";
		int res = s.countPalindroms(str);
		System.out.println(res);
	}
}
