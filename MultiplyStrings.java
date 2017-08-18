package algorithm_java;

//Facebook Twitter

//https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation
// `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();
		int[] pos = new int[m+n];
		for(int i=m-1;i>=0;i--){
			int x = num1.charAt(i)-'0';
			for(int j=n-1;j>=0;j--){
				int y = num2.charAt(j)-'0';
				int sum = pos[i+j+1]+x*y;
				pos[i+j+1] = sum%10;
				pos[i+j] += sum/10;
			}
		}
		StringBuilder sb = new StringBuilder();
	    for(int p : pos){
	    	if(sb.length() == 0 && p == 0)
	    		continue;
	    	sb.append(p);
	    }
	    return sb.length() == 0 ? "0" : sb.toString();
    }
    
    public static void main(String[] args) {
		String num1="123", num2 ="45"; //56088
    	//String num1="8", num2 ="8";
		MultiplyStrings s = new MultiplyStrings();
		String res = s.multiply(num1, num2);
		System.out.println(res);
	}
}
