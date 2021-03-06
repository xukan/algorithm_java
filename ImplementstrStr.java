package algorithm_java;

//Pocket Gems Microsoft Apple Facebook

public class ImplementstrStr {
	//KMP, tc: O(n + k)
	public static int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        int n = haystack.length();
        int m=needle.length();
        int[] prefix = computePrefix(needle);
        
        //output prefix array
        for(int i: prefix)
        	System.out.print(i+" ");
        System.out.println();
        
        int q = 0;
        for(int i=0;i<n;i++){
            while(q>0 && haystack.charAt(i) != needle.charAt(q))
                q = prefix[q-1];
            if(haystack.charAt(i) == needle.charAt(q))
                q++;
            if(q==m)
                return i-m+1;
        }
        return -1;
    }
    
    public static int[] computePrefix(String pattern){
    	//the array helps keep track of if suffix is prefix
        int len = pattern.length();
        int[] prefix = new int[len];
        int i=0;
        for(int j=1;j<len;j++){
            while(i>0 && pattern.charAt(i) != pattern.charAt(j) ){
                i= prefix[i-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j))
                i++;
            prefix[j] = i;
        }
        return prefix;
    }
    
    //brute force, tc: O(nk)
    public int strStr_bf(String haystack, String needle) {
        if(needle.length() ==0)
            return 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        char c = needle.charAt(0);
        for(int i=0;i<=len1-len2;i++){
            if(haystack.charAt(i) == c){
                if(haystack.substring(i, i+len2).equals(needle))
                    return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
//		String text = "mississippi";
//		String pattern = "issip";
		String text = "abxabcabcaby";
		String pattern = "abcaby";
		int res = strStr(text, pattern);
		System.out.println(res);
	}
}
