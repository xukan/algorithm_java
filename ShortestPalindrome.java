package algorithm_java;
//Pocket Gems Google

public class ShortestPalindrome {
//	public static String shortestPalindrome(String s) {
//        String p = s + "#" + new StringBuilder(s).reverse().toString();
//        int[] dfa = preprocess(p.toCharArray());
//        
//        for(int i: dfa)
//        	System.out.print(i+" ");
//        System.out.println();
//        
//        String max = s.substring(dfa[dfa.length - 1]);
//        return new StringBuilder(max).reverse().append(s).toString();
//    }
//
//    private static int[] preprocess(char[] p) {
//        int[] dfa = new int[p.length];
//        for (int i = 1, j = 0; i < p.length; i++) {
//            while (j > 0 && p[j] != p[i])
//                j = dfa[j - 1];
//            if (p[j] == p[i])
//                j++;
//            dfa[i] = j;
//        }
//        return dfa;
//    }
	
	
	
	public static String shortestPalindrome(String s) {
        if(s.equals(""))
            return s;
        StringBuilder sb = new StringBuilder(s);
        String str = sb.reverse().toString();
        sb = new StringBuilder(s);
        String comb = sb.append("#").append(str).toString();
        int[] prefix = computePrefix(comb);
        
        for(int i: prefix)
        	System.out.print(i+" ");
        System.out.println();
        
        
        int r=prefix[comb.length() -1];
        
        String pre = str.substring(0, s.length()-r);
        System.out.println(pre);
        sb = new StringBuilder(pre);
        return sb.append(s).toString();
    }
    
    public static int[] computePrefix(String s){
        int len = s.length();
        int[] prefix = new int[len];
        int i=0;
        for(int j=1;j<len;j++){
            while(i>0 && s.charAt(i) != s.charAt(j)){
                i = prefix[i-1];
            }
            if(s.charAt(i) == s.charAt(j))
                i++;
            prefix[j]=i;
        }
        return prefix;
    }
	
	public static void main(String[] args) {
//		String input ="aacecaaa";
//		String input ="abbacd";
//		String input = "aabba";
		String input="abcd";
		String res = shortestPalindrome(input);
		System.out.println(res);
	}
}
