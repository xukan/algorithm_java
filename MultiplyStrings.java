package algorithm_java;

//Facebook Twitter

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        num1 = reverse(num1);
        num2 = reverse(num2);
        StringBuilder sb = new StringBuilder();
        //Double res =0;
        int carry =0, sum=0, multi=1;
        for(int i=0;i<num1.length();i++){
        	StringBuilder temp = new StringBuilder();
        	carry =0;
        	sum=0;
            int a = num1.charAt(i)-'0';
            for(int k=0;k<i;k++)
            	temp.append("0");
            for(int j=0;j<num2.length();j++){
                int b=num2.charAt(j)-'0';
                int oldSum = a*b+carry;
                carry=oldSum/10;
                sum = oldSum%10;
                temp.append(sum);
            }
            if(carry!=0)
            	temp.append(carry);
            sb = add(temp, sb);
        }
        return reverse(sb.toString());
    }
    
	public StringBuilder add(StringBuilder temp, StringBuilder sb){
		if(sb.toString().equals("")){
			sb=new StringBuilder(temp.toString());
			return sb;
		}
		StringBuilder res = new StringBuilder();
		String s1 = temp.toString(), s2=sb.toString();
		int i=0, j=0, carry =0, remainder =0;
		while(i<s2.length()){
			int a = s2.charAt(i)-'0';
			int b = s1.charAt(j)-'0';
			int oldSum = a+b+carry;
			remainder = oldSum%10;
			carry = oldSum/10;
			res.append(remainder);
			i++;
			j++;
		}
		while(j<s1.length()){
			int c = s1.charAt(j)-'0';
			remainder = (c+carry)%10;
			carry = (c+carry)/10;
			res.append(remainder);
			j++;
		}
		if(carry!=0)
			res.append(carry);
        return res;
	}
	
    public String reverse(String num){
        StringBuilder sb = new StringBuilder(num);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
		String num1="123", num2 ="456"; //56088
    	//String num1="8", num2 ="8";
		MultiplyStrings s = new MultiplyStrings();
		String res = s.multiply(num1, num2);
		System.out.println(res);
	}
}
