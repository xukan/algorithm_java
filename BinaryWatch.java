package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Google
//bit manipulation

public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<String>();
        for(int i=0;i<12;i++){
        	for(int j=0;j<60;j++){
        		int count = countDigit(i) + countDigit(j);
        		if(count == num){
        			StringBuilder sb = new StringBuilder();
        			sb.append(i);
        			sb.append(":");
        			if(j<10)
        				sb.append("0");
        			sb.append(j);
        			res.add(sb.toString());
        		}
        	}
        }
        return res;
    }
	
	public int countDigit(int num){
		int count = 0;
		while(num>0){
			if( (num & 1) == 1){
				count++;
			}
			num >>=1;
		}
		return count;
	}
	
	public List<String> readBinaryWatch_bitcount(int num) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		BinaryWatch s = new BinaryWatch();
		List<String> res = s.readBinaryWatch(2);
		for(String str : res)
			System.out.print(str+" ");
	}
}
