package algorithm_java;

public class AddressSimilarity {
	public static boolean compareAddr(String addr1, String addr2){
		addr1 = addr1.toLowerCase().replace(".", "");
		addr2 = addr2.toLowerCase().replace(".", "");
		String[] parts1 = addr1.split("\\s+");
		String[] parts2 = addr2.split("\\s+");
		if(parts1.length != parts2.length )
			return false;
		int len = parts1.length;
		for(int i=0;i<len-1;i++){
			if(!parts1[i].equals(parts2[i]))
				return false;
		}
		String str1 = new String(parts1[len-1]);
		String str2 = new String(parts2[len-1]);
		if(str1.startsWith(str2) || str2.startsWith(str1))
			return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		String addr1 = "22 Acacia Avenue";
		String addr2 = "22 acacia av." ;
		boolean res = compareAddr(addr1, addr2);
		System.out.println(res );
	}
}
