package algorithm_java;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if( x< 0)
			return false;
		int count = 1;
		// in this way, it will not change x
		while( x/ count >= 10 ){
			count *= 10;
		}
		while( x !=0){
			int remainder = x % 10;
			int carry = x/ count;
			if( remainder == carry ){
				x%= count;
				x/=10;
				count /=100;
				continue;
			}else
				return false;
		}
		return true;
		
    }
	
	public static void main(String[] args) {
		//int input = 10;
		int input = 12321;
		PalindromeNumber solution = new PalindromeNumber();
		boolean result = solution.isPalindrome(input);
		System.out.println(result);
	}
}
