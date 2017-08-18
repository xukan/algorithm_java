package algorithm_java;

//Google

public class LicenseKeyFormatting {
	public static String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "").toUpperCase();
        int len = S.length();
        StringBuilder sb = new StringBuilder(S);
        int i = len-1;
        while(i>=K){
            i -= (K-1);
            sb.insert(i, "-");
            i--;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String str = "2-4A0r7-4k";
		String res = licenseKeyFormatting(str, 3);
		System.out.println(res);
	}
}
