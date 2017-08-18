package algorithm_java;

//Amazon

//similar question
//solve the equation

public class ComplexNumberMultiplication {
	public static String complexNumberMultiply(String a, String b) {
		String[] v1 = a.split("\\+|i");
		String[] v2 = b.split("\\+|i");
		int real = Integer.valueOf(v1[0])*Integer.valueOf(v2[0]) - Integer.valueOf(v1[1])*Integer.valueOf(v2[1]);
		int img_unit = Integer.valueOf(v1[1])*Integer.valueOf(v2[0]) + Integer.valueOf(v1[0])*Integer.valueOf(v2[1]);
		return real + "+" + img_unit + "i";
	}
	
//	public static String complexNumberMultiply(String a, String b) {
//        int[] valA = getValue(a);
//        int[] valB = getValue(b);
//        
//        int real = valA[0] * valB[0] - valA[1] * valB[1];
//        int img = valA[0] * valB[1] + valA[1] * valB[0];
//        
//        return real + "+" + img + "i";
//    }
//    
//    public static int[] getValue(String s) {
//        String[] str = s.split("\\+");
//        int[] val = new int[2];
//        val[0] = Integer.valueOf(str[0]);
//        int indexOfI = str[1].indexOf("i");
//        val[1] = Integer.valueOf(str[1].substring(0, indexOfI));
//        
//        return val;
//    }
    
    public static void main(String[] args) {
//    	String p1 = "-1+1i";
//    	String p2 = "1+1i";
    	
    	String p1 ="1+-1i";
    	String p2 ="0+0i";
    	String res = complexNumberMultiply(p1, p2);
    	System.out.println(res);
	}
}
