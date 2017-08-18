package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://segmentfault.com/a/1190000003791865
//Google

public class EncodeandDecodeStrings {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int start = 0;
        while(start<s.length()){
            int slash = s.indexOf("/", start);
            int len = Integer.parseInt(s.substring(start, slash));
            res.add(s.substring(slash+1, slash+1+len));
            start = slash + 1+len;
        }
        return res;
    }
    
    public static void main(String[] args) {
    	EncodeandDecodeStrings s = new EncodeandDecodeStrings();
    	List<String> input = Arrays.asList("abc", "abcde", "fg");
    	String code = s.encode(input);
    	System.out.println(s.decode(code));
	}
}
