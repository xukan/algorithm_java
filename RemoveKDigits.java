package algorithm_java;
//Google Snapchat

public class RemoveKDigits {
//	public String removeKdigits(String num, int k) {
//	    if(num.length()==k)
//	        return "0";
//	 
//	    StringBuilder sb = new StringBuilder(num);
//	    for(int j=0; j<k; j++){
//	        int i=0;
//	        while(i<sb.length()-1&&sb.charAt(i)<=sb.charAt(i+1)){
//	            i++;
//	        }
//	        sb.delete(i, i+1);
//	    }
//	 
//	    //remove leading 0's        
//	    while (sb.length() > 1 && sb.charAt(0)=='0')
//	        sb.delete(0,1);
//	 
//	    if(sb.length()==0){
//	        return "0";
//	    }
//	 
//	    return sb.toString();
//	}
	
	public String removeKdigits(String num, int k) {
        if(k>=num.length())
            return "0";
        StringBuilder sb = new StringBuilder(num);
        
        for(int i=0;i<k;i++){
        	int j=0;
            while(j<num.length()-1 && sb.charAt(j)<=sb.charAt(j+1)){
                j++;
            }
            sb.deleteCharAt(j);
        }
        
        //if(num.length()==k)
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        if(sb.length()==0)
            return "0";
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String input = "1432219";
		String input1 = "1111111";
		RemoveKDigits s = new RemoveKDigits();
		String res = s.removeKdigits(input1, 3);
		System.out.println(res);
	}
}
