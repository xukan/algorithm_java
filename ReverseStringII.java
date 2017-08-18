package algorithm_java;

//Google

public class ReverseStringII {
	public static String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int len = array.length;
        int i=0;
        for(;i<len;i+=2*k){
            int l=i, r=i+k-1;
            if(r>=len)
            	break;
            swap(array, l, r);
        }
        int l = i, r= Math.min(len-1, i+k-1);
        if(i<len)
            swap(array, l, r);
        return new String(array);
    }
    
    public static void swap(char[] array, int l, int r){
        while(l<r){
            char tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
            l++;
            r--;
        }
    }
	
	public static void main(String[] args) {
		String input = "abcdefgh";
		String s = reverseStr(input, 3);
		System.out.println( s );
	}
}
