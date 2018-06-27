package algorithm_java;

//Google 


//UTF8 can be from 1 to 4 bytes long
//what b mean in 0b1110 ->binary number

public class UTFEightValidation {
	public static boolean validUtf8(int[] data) {
        int count = 0;
        for (int c : data) {
            if (count == 0) {
                if ((c >> 5) == 0b110)  
                	//这里如果右移6位是11,那么4-byte long and 3-byte long number右移6位也是11,就无法区分了,所以右移5位
                	//满足前n位是1,第n+1位是0
                	count = 1;
                else if ((c >> 4) == 0b1110)
                	count = 2;
                else if ((c >> 3) == 0b11110) 
                	count = 3;
                else if ((c >> 7) != 0)
                	return false;
            } else {
                if ((c >> 6) != 0b10) 
                	return false;
                count--;
            }
        }
        //最后要检查count是不是等于0,i.e data = {237} (11101111)
        return count == 0;
    }
	
	public static void main(String[] args) {
		int[] data = {197, 130, 1};
		boolean res = validUtf8(data);
		System.out.println(res);
	}
}
