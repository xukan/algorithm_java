package algorithm_java;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
        if(s.length()==0)
            return true;
        int l=0, r=s.length()-1;
        //easy solution with regular expression
        //s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        s=s.toLowerCase();
        while(l<r){
            char left = s.charAt(l);
            char right = s.charAt(r);
            while(l<r && !isAlpha(left) &&!isNum(left)){
                l++;
                left = s.charAt(l);
            }
            while(l<r&& !isAlpha(right) && !isNum(right)){
                r--;
                right = s.charAt(r);
            }
            if(left == right){
                l++;
                r--;
            }else
                return false;
        }
        return true;
    }
    
    public static boolean isAlpha(char c){
        if('a'<=c && c<= 'z' || 'A'<=c && c <='Z' )
            return true;
        else
            return false;
    }
    
    public static boolean isNum(char c){
    	int a= c-'0';
    	if(0<=a && a<=9)
    		return true;
    	else
    		return false;
    }
	
    //an easier solution
    public boolean isPalindrome_easy(String str) {
        String s = str.toLowerCase();
        int l=0, r=s.length()-1;
        while(l<r){
            while(l<r && !Character.isDigit(s.charAt(l)) && !Character.isLetter(s.charAt(l)))
                l++;
            while(l<r && !Character.isDigit(s.charAt(r)) && !Character.isLetter(s.charAt(r)))
                r--;
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else
                return false;
        }
        return true;
    }
    
	public static void main(String[] args){
		String input = "0aA,.";
		boolean res = isPalindrome(input);
		System.out.println(res);
	}
}
