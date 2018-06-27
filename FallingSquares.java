package algorithm_java;

//Uber Square 

public class FallingSquares {
	//solutionI, run faster
	public static int firstUniqChar(String s) {
         if(s.length() == 0)
             return -1;
         int len = s.length();
         int[] map = new int[256];
         for(char c: s.toCharArray())
             map[c]++;
         for(int i=0;i<len;i++){
             char c = s.charAt(i);
             if(map[c] == 1)
                 return i;
         }
         return -1;
	}
	
	
	//solution II, shorter code
	//indexOf, first occurrence of the specified character 
	//lastIndexOf, last occurrence of the specified character 
	public static int firstUniqChar_easy(String s) {
        int len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(s.indexOf(c) == s.lastIndexOf(c)) 
                return i;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		String s = "cc";
		int res = firstUniqChar_easy(s);
		System.out.println(res);
	}
}
