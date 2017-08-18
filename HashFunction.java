package algorithm_java;

//http://www.lintcode.com/en/problem/hash-function/

// (a+b)%M  = (a%M+b)%M
// (a*b)%M = (a%M)*(b%M)
  
public class HashFunction {
	static final int MAGIC_NUM = 33;
	public static int hashCode(char[] key,int HASH_SIZE) {
		long hashcode = 0;
        for(int i=0;i<key.length;i++){
        	int num = (int)key[i];
            hashcode = (33*hashcode + num)%HASH_SIZE;
        }
        return (int)hashcode;
    }
	
	public static void main(String[] args) {
		String s = "ubuntu";
		int size = 1007;
		int hashcode = hashCode(s.toCharArray(), size);
		System.out.println(hashcode);
	}
}
