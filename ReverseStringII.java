package algorithm_java;

//Google

public class ReverseStringII {
	public static String reverseStr(String s, int k) {
		int len = s.length();
        if(k>len)
            k%=len;
        int start = 0;
        StringBuilder ss = new StringBuilder();
        while(start<len){
            int end = Math.min( start + 2*k,  len );
            String str = s.substring(start, end);
            if(k>str.length())
            	k=str.length();
            String r = str.substring(0, k);
            StringBuilder sb = new StringBuilder( r );
            sb.reverse();
            ss.append(sb.toString());
            String remain = str.substring(k, str.length());
            ss.append(remain);
            start += 2*k;
        }
        return ss.toString();
    }
	
	public static void main(String[] args) {
		String input = "abcdefg";
		String s = reverseStr(input, 3);
		System.out.println( s );
	}
}
