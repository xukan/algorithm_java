package algorithm_java;

public class ReverseVowelsofaString {
	static final String vowels = "aeiouAEIOU";
	public String reverseVowels(String s) {
	    int l = 0, r = s.length() - 1;
	    char[] array = s.toCharArray();
	    while(l < r){
	        while(l < r && vowels.indexOf(array[l]) == -1){
	            l++;
	        }
	        while(l < r && vowels.indexOf(array[r]) == -1){
	            r--;
	        }
	        char temp = array[l];
	        array[l] = array[r];
	        array[r] = temp;
	        l++;
	        r--;
	    }
	    return new String(array);
	}
}
