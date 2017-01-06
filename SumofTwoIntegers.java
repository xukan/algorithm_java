package algorithm_java;

public class SumofTwoIntegers {
	public int getSum(int a, int b) {
        while( b!=0 ){
        	int c = a&b; // carry
        	a = a^b;       // add
        	b = c <<1;
        }
        return a;
    }
	
	public static void main(String[] args) {
		int a = 5, b=7;
		SumofTwoIntegers solution = new SumofTwoIntegers();
		int res = solution.getSum(a, b);
		System.out.println(res);
	}
}
