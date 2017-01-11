package algorithm_java;

public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		if(numRows==1 || numRows > s.length())
            return s;
        StringBuilder sb = new StringBuilder();
        int count=1;
		for(int r=0;r<numRows;r++){
			sb.append(s.charAt(r));
			int step = 2*numRows-2;
			for(int c=1;c*(step)-r<s.length();c++){
				if(r==0)
					sb.append(s.charAt(c*(step)));
				if(0<r && r<numRows-1){
					sb.append(s.charAt(c*(step)-r));
					if((c*(step)+r)<s.length())
						sb.append(s.charAt(c*(step)+r));
				}
				if(r == numRows-1 && (c*(step)+r) <s.length()){
					sb.append(s.charAt(c*(step)+r));
				}
			}
        }
		return sb.toString();
    }
	
	public static void main(String[] args){
		String input = "ABCD";
		String res =convert(input , 3);
		System.out.println(res);
	}
}
