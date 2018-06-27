package algorithm_java;

//Facebook

public class NumberComplement {
	//solution I
	public static int FindComplement(int num) {
        if(num == 0)
            return 1;
        String s = "";
        while(num>0){
        	s =  num%2 + s;
        	num/=2;
        }
        String str = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0')
                str += "1";
            else
                str += '0';
        }
        int base = 1;
        int res = 0;
        for(int i = str.length()-1;i>=0;i--){
            res += base*(str.charAt(i)-'0');
            base*=2;
        }
        return res;
    }
	
	//solution II
	//100110, its complement is 011001, the sum is 111111. 
	//So we only need get the min number large or equal to num, then do substraction
	public static int findComplement(int num) {
//        int i = 0;
//        int j = 0;
//        
//        while (i < num){
//            i += Math.pow(2, j);
//            j++;
//        }
//        return i - num;
        
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }
        return n - num;
    }
	
	public static void main(String[] args) {
		int res = findComplement(9);
		System.out.println(res);
	}
}
