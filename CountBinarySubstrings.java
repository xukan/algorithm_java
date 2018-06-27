package algorithm_java;
 
//Helix 

//two pointers

public class CountBinarySubstrings {
	public static int countBinarySubstrings(String s) {
		int prev = 0, cur = 1;
        int res = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1))
                cur++;
            else{
                prev = cur;
                cur = 1;
            }
            if(prev >= cur)
                res++;
        }
        return res;
    }
	
	public static void main(String[] args) {
//		String s= "00110011";
		String s = "100101";
		int res = countBinarySubstrings(s);
		System.out.println(res);
	}
}
