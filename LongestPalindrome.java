package algorithm_java;
//Google

public class LongestPalindrome {
	public static int longestPalindrome(String s) {
		//solution1, hashMap can also be done with hashSet
        // HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // for(int i=0;i<s.length();i++){
        //     char c = s.charAt(i);
        //     if(map.containsKey(c)){
        //         map.put(c, map.get(c)+1);
        //     }else{
        //         map.put(c, 1);
        //     }
        // }
        // boolean single = false;
        // int res =0;
        // for (Integer v : map.values()) {
        //     if(v>1){
        //         if(v%2==0)
        //             res += v;
        //         else{
        //             res+=(v-1);
        //             single = true;
        //         }
        //     }else if(v==1 && !single)
        //         single = true;
        // }
        
        // if(single)
        //     return res+1;
        // return res;
		
		//solution2
		//这个解法,在计算奇数的个数，比如单独的字母'b', 'd'和多次出现的字母'ccc','cacac',其中c出现了奇数次,
		//奇数就加1，偶数就再减掉1，这样odd最后就是多出来的字母的个数，这个多出来的字母最多只能有一个加入到回文中
		//'A'==65
		//'a' == 97
		//'z' == 122
		//122-65+1 = 58
        int[] count = new int[58];
        int odd =0;
        for(int i=0;i<s.length();i++){
            odd+=(++count[s.charAt(i)-'A'] & 1)==1?1:-1;
        }
        return s.length()-odd+(odd>0?1:0);
    }
	
	public static void main(String[] args) {
		String input="abccccdd";
		int res = longestPalindrome(input);
		System.out.println(res);
	}
}
