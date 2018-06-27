package algorithm_java;

public class CountingBits {
	//An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
	//从1开始，遇到偶数时，其1的个数和该偶数除以2得到的数字的1的个数相同，
	//遇到奇数时，其1的个数等于该奇数除以2得到的数字的1的个数再加1
	//规律可以从十进制转化二进制的算法中得出
	public static int[] countBits(int num) {
        int[] f = new int[num+1];
        for(int i=1;i<num+1;i++){
            f[i] = f[i/2] + i%2;
        	//f[i] = f[i>>1]+(i&1);
        }
        return f;
    }
	
	public static void main(String[] args) {
		int num = 5;
		int[] res = countBits(num);
		for(int i: res)
			System.out.print(i + " ");
	}
}
