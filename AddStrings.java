package algorithm_java;

public class AddStrings {
	public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i=num1.length()-1, j=num2.length()-1; i>=0 || j>=0 || carry == 1;i--, j--){
            int n1 = i<0 ?0: num1.charAt(i) - '0';
            int n2 = j<0 ?0: num2.charAt(j) - '0';
            sb.insert(0, (n1+n2+carry)%10);
            carry = (n1+n2+carry)/10;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String n1 = "567";
		String n2 = "123";
		String res = addStrings(n1, n2);
		System.out.println(res);
	}
}
