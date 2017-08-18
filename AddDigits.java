package algorithm_java;

public class AddDigits {
	public static int addDigits(int num) {
        if(num <10)
            return num;
        while(num>=10){
        	int sum = 0;
            while(num>0){
                sum += num%10;
                num/=10;
            }
            num = sum;
        }
        return num;
    }
	
	//one-line
	//http://www.cnblogs.com/grandyang/p/4741028.html
	public static int addDigits_oneline(int num) {
		return (num-1)%9 + 1;  //-1%9=8
	}
	public static void main(String[] args) {
		int res = addDigits(19);
		System.out.println(res);
	}
}
