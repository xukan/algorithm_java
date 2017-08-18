package algorithm_java;

//Facebook

public class AddBinary {
	public static String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        StringBuilder sb = new StringBuilder();
        int i=len1-1, j=len2-1;
        int carry = 0;
        while(i>=0 || j>=0){
            int num1=0, num2=0;
            if(i>=0)
                num1 = a.charAt(i--)-'0';
            if(j>=0)
                num2 = b.charAt(j--)-'0';
            int remain = (num1+num2+carry)%2;
            carry = (num1+num2+carry)/2;
            sb.insert(0, remain);
        }
        if(carry>0)
            sb.insert(0, carry);
        return sb.toString();
    }
	
	public static void main(String[] args){
		String a = "11";
		String b = "1";
		String c = addBinary(a, b);
		System.out.println(c);
	}
}
