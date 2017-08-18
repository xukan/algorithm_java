package algorithm_java;

//Tencent

public class MinimumFactorization {
	public static int smallestFactorization(int a) {
        if (a < 2)
            return a;
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                res = mul * i + res;
                mul *= 10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ? (int)res : 0;
    }
	
	public static void main(String[] args) {
		MinimumFactorization s = new MinimumFactorization();
		int res = s.smallestFactorization(18000000); //0
		System.out.println(res);
	}
}
