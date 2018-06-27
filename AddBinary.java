package algorithm_java;

//Facebook

public class AddBinary {
	public static String addBinary(String a, String b) {
        int i=a.length()-1, j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i>=0|| j>=0){
            int v1 = i==-1? 0 : a.charAt(i--) - '0';
            int v2 = j==-1? 0 : b.charAt(j--) - '0';
            int remain = (v1 + v2 + carry)%2;
            carry = (v1 + v2 + carry)/2;
            sb.insert(0, remain);
        }
        if(carry == 1)
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
