package algorithm_java;

//Yahoo

public class LargestPalindromeProduct {
	public static int largestPalindrome(int n) {
        if (n==1) return 9;
        int upper=(int)Math.pow(10, n)-1;
        int lower = upper/10;
        for (int v=upper;v>lower;v--) {
            long palindrome=Long.valueOf(v+new StringBuilder().append(v).reverse().toString());
            for (long x=upper;x*x>=palindrome;x--)
                if (palindrome%x==0)
                    return (int)(palindrome%1337);
        }
        return 0;
    }
	
	public static void main(String[] args) {
		int res = largestPalindrome(5);
		System.out.println(res);
	}
}
