package algorithm_java;

//Facebook

//这道题的输入n是序号，即序列中的序号index, 返回值为序列中的第n个数
//input argument n is the nth element in the array, n starts from 1
//1, 11, 21, 1211, 111221
//the 6th element is 312211...
//for example if n= 2, return value is 11, second element in the array
public class CountandSay {
	public String countAndSay(int n) {
        String input = "1";
        int k=1;
        while(k<n){
            int count=1;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<input.length();i++){
                char c = input.charAt(i);
                if( i+1<input.length() && input.charAt(i+1) == c )
                    count++;
                else{
                    sb.append(count).append(c);
                    count=1;
                    }
            }
            input = sb.toString();
            k++;
        }
        return input;
    }
	
	public static void main(String[] args) {
		CountandSay s = new CountandSay();
		String res =s.countAndSay(6);
		System.out.println(res);
	}
}
