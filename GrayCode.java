package algorithm_java;
import java.util.*;
/* integer n representing the total number of bits in the code
 * n位的格雷码由两部分构成，一部分是n-1位格雷码，再加上 1<<(n-1)和n-1位格雷码的倒序,注意理解这个倒序，
 * 举个例子，n=3时，前四个格雷码，自动继承n=2的，也就是[000,001,011,010],那么后四个格雷码，1<<2=100, 100和前四个格雷码从后往前相加得到110, 111,101,100
 * 
 * n = 0时，[0]
 * n = 1时，[0,1]
 * n = 2时，[00,01,11,10]
 * n = 3时，[000,001,011,010,110,111,101,100]
 * 当n=1时，0，1
 * 当n=2时，原来的list 0，1不变，只是前面形式上加了个0变成00，01。
 * 然后加数是1<<1为10，依次：10+1=11 10+0=10。结果为：00 01 11 10
 * 当n=3时，原来的list 00,01,11,10（倒序为：10，11，01，00）。
 * 加数1<<2为100。倒序相加为：100+10=110, 100+11=111,100+01=101, 100+00= 100。
 * 最终结果为000 001 011 010 110 111 101 100 
 * 
 * */

//amazon

public class GrayCode {
		public static List<Integer> grayCode(int n) {
			List<Integer> res = new ArrayList<Integer>();
			res.add(0);
			for(int i=1;i<=n;i++){
				//倒序就是这个意思,反向遍历n-1的格雷码
				for(int j= res.size()-1;j>=0;j--){
					int tmp = 1<<(i-1);
					tmp+=res.get(j);
					res.add(tmp);
				}
			}
			return res;
			
	//recursion		
//			if(n==0) {  
//	            ArrayList<Integer> result = new ArrayList<Integer>();  
//	            result.add(0);  
//	            return result;  
//	        }  
//	          
//	        List<Integer> result = grayCode(n-1);  
//	        int addNumber = 1 << (n-1);
//	        int originalsize=result.size();
//	        
//	        for(int i=originalsize-1;i>=0;i--) {  
//	            result.add(addNumber + result.get(i));  
//	        }  
//	        return result;  
	    }
		
		public static void main(String[] args){
			List<Integer> res = grayCode(3);
			for(int i:res)
				System.out.print(i+" ");
		}
}
