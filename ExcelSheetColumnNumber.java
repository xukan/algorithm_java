package algorithm_java;

//Microsoft Uber

public class ExcelSheetColumnNumber {
	/*
	 * A -> 1
    	B -> 2
    	C -> 3
    	...
    	Z -> 26
    	AA -> 27
    	AB -> 28 
	 * */
	public static int titleToNumber(String s) {
        if(s==null || s.length() ==0)
            return 0;
        int res =0;
        int len = s.length();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int tmp = c-'A'+1;
            for(int j=len-1-i;j>0;j--){
                tmp *=26;
            }
            res += tmp;
        }
        return res;
    }
	
	//Excel Sheet Column Title
	/*
	 * 1 -> A
    	2 -> B
    	3 -> C
    	...
    	26 -> Z
    	27 -> AA
    	28 -> AB 
	 * */
	//Microsoft Facebook Zenefits
	//注意这道题和2进制，16进制的区别是0不在考虑范围内,所以52 = "AZ"， 702="ZZ", 
	//每次遇到0,需要对应的是"Z",并把n-1
	public static String convertToTitle(int n) {
		int remain=0;
        StringBuilder sb = new StringBuilder();
        boolean bar = false;
        while(n>=26){
            remain = n%26;
            n = n/26;
            if(remain!=0)
                sb.append((char)(remain + 'A'-1));
            else{
                sb.append('Z');
                bar = true;
                n-=1;
            }
        }
        if(n!=0)
            sb.append((char)(n + 'A'-1 ));
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		String s = "AB";
		int input = 702; //ZZ
		int res1 = titleToNumber(s);
		System.out.println(res1);
		String res2 = convertToTitle(input);
		System.out.println(res2);
	}
}
