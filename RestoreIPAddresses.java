package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public static List<String> restoreIpAddressesII(String s) {
	    List<String> res = new ArrayList<String>();
	    restoreIp(s, res, "", 0);
	    return res;
	}

	private static void restoreIp(String ip, List<String> res, String restored, int count) {
		if((count == 3 && ip.length()>3) || ip.length()==0 )
	    	return;
	    if(count == 3 && isValid(ip)){
	    	res.add(restored + ip);
	    	return;
	    }
	    for (int i=0; i<3 && i<ip.length(); i++) {
	        String str = ip.substring(0, i+1);
	        if(isValid(str))
	        	restoreIp(ip.substring(i+1), res, restored+str+".", count+1);
	    }
	}
	
	public static boolean isValid(String s){
        if(s.charAt(0)=='0')
            return s.equals("0");
        int ip = Integer.parseInt(s);
        return (0<ip && ip <=255);
    }
	
	public static void main(String[] args) {
		//String str = "25525511135";
		String str ="1111";
		RestoreIPAddresses s = new RestoreIPAddresses();
		List<String> res = s.restoreIpAddressesII(str);
		res.forEach(ss -> System.out.println(ss + " "));
	}
}
