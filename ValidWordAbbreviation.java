package algorithm_java;

//Google 

public class ValidWordAbbreviation {
	public static boolean validWordAbbreviation(String word, String abbr) {
        int len1 = word.length(), len2 = abbr.length();
        int i=0, j = 0;
        for(;i<len2;i++){
            if('0'<=abbr.charAt(i) && abbr.charAt(i) <= '9'){
                int start = i;
                while( i+1 <len2 && '0'<=abbr.charAt(i+1) && abbr.charAt(i+1) <= '9' )
                    i++;
                String num = abbr.substring(start, i+1);
                if(num.startsWith("0"))
                	return false;
                int val = Integer.parseInt(num);
                j+=val;
            }else{
                if(j >= len1 || word.charAt(j)!=abbr.charAt(i))
                    return false;
                else
                    j++;
            }
        }
        return j == len1 && i == len2;
    }
	
	public static void main(String[] args) {
//		String s = "internationalization";
//		String t = 	"i5a11o1";
		String s = "a";
		String t = "01";
		boolean res = validWordAbbreviation(s, t);
		System.out.println(res);
	}
}
