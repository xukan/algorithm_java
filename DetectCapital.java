package algorithm_java;

//Google

/*
 * Character class
 * 
 * isLetter()
 * isDigit()
 * isWhitespace()
 * isUpperCase()
 * isLowerCase()
 * toUpperCase()  char ch4 = Character.toUpperCase(ch2);
 * toLowerCase()
 * toString()
 * */

public class DetectCapital {
	public static boolean detectCapitalUse(String word) {
        int len = word.length();
        int numUpper = 0;
        for( char c: word.toCharArray())
            if(Character.isUpperCase(c))
                numUpper++;
        if(numUpper == len)
            return true;
        return  numUpper == 0 || ( numUpper == 1 && Character.isUpperCase(word.charAt(0)) );
    }
	
	public static void main(String[] args) {
		String word = "Canada"; //canada, Canada
		boolean res = detectCapitalUse(word);
	}
}
