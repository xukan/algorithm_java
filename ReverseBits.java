package algorithm_java;

import java.util.HashMap;

//Apple Airbnb

public class ReverseBits {
	public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            res<<=1;
            res+=(n&1);
            n>>=1;
        }
        return res;
    }
	
	//How to optimize if this function is called multiple times? 
	//We can divide an int into 4 bytes, and reverse each byte then combine into an int. 
	//For each byte, we can use cache to improve performance.
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int reverseBits_bigdata(int n) {
        int res = 0;
        for(int i = 0; i < 4; i++){
        	//“& 0xff” effectively masks the variable so it leaves only the value in the last 8 bits, and ignores all the rest of the bits.
        	//0xff is the hexadecimal number FF which has a integer value of 255. 
        	//And the binary representation of FF is 00000000000000000000000011111111 (under the 32-bit integer).
            int tmp = n & 0xFF; 
            if(map.containsKey(tmp)){
                res = (res << 8) + map.get(tmp);  //don't forget parentheses here
            }else{
                res = (res << 8) + reverse8Bits(tmp);
            }
            n >>= 8;
        }
        return res;
    }
    
    private int reverse8Bits(int n){
        int res = 0;
        int tmp = n;
        for(int i = 0; i < 8; i++){
            res = (res << 1) + (tmp & 1);
            tmp >>= 1;
        }
        map.put(n, res);
        return res;
    }
    
    public static void main(String[] args) {
    	ReverseBits  s = new ReverseBits ();
    	int res = s.reverse8Bits(1);
    	System.out.println(res);
	}
}
