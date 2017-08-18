package algorithm_java;

public class ReverseWordsinaString {
	public String reverseWordsI(String s) {
        String[] parts = s.trim().split("\\s+"); //This groups all white spaces as a delimiter.
        String res = "";
        for(int i=parts.length-1;i>=0;i--)
            res+=parts[i]+" ";
        return res.substring(0,res.length()-1);
    }
	
	//II in-place reverse
	//Amazon Microsoft Uber
	public void reverseWordsII(char[] s) {
	    reverse(s, 0, s.length-1);  // reverse the whole string first
	    int r = 0;
	    while (r < s.length) {
	        int l = r;
	        while (r < s.length && s[r] != ' ')
	            r++;
	        reverse(s, l, r-1);  // reverse words one by one
	        r++;
	    }
	}

	public void reverse(char[] s, int l, int r) {
	    while (l < r) {
	        char tmp = s[l];
	        s[l++] = s[r];
	        s[r--] = tmp;
	    }
	}
	
	public static String reverseWordsIII(String s) {
        String[] parts= s.split(" ");
        String res = "";
        for(int i=0;i<parts.length;i++){
            String str = parts[i];
            char[] array = str.toCharArray();
            int j=0, k=array.length-1;
            while(j<k){
                char tmp = array[j];
                array[j] = array[k];
                array[k] = tmp;
                j++;
                k--;
            }
            res+=(new String(array));
            res+=" ";
        }
        return res.substring(0,res.length()-1);
    }
	
	public static void main(String[] args) {
		String str = "Let's take LeetCode contest";
		String res3 = reverseWordsIII(str);
		System.out.println(res3);
	}
	
}
