package algorithm_java;

//Facebook

public class AddBinary {
	public static String addBinary(String a, String b) {
        int m=a.length();
        int n=b.length();
        StringBuilder sb = new StringBuilder();
        int len = Math.max(m, n);
        int carry=0;
        for(int i=0;i<len;i++){
            int x=0, y=0, sum=0, rem=0;
            if(i<m)
                x= a.charAt(m-1-i)-'0';
            if(i<n)
                y= b.charAt(n-1-i)-'0';
            sum=x+y+carry;
            carry= sum/2;
            rem = sum%2;
            sb.insert(0, rem);
        }
        if(carry !=0)
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
