package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Permutation Sequence
//Twitter

public class PermutationSequence {
	public String getPermutation(int n, int k) {
        int mod = 1;
        int factorial = 1;
        StringBuilder sb = new StringBuilder();
        k--;
        for(int i=1;i<=n;i++)
            mod*=i;
        ArrayList<Integer> numlist = new ArrayList<Integer>();
        for(int i=1;i<=n;i++)
            numlist.add(i);
        for(int i=n;i>0;i--){
            mod = mod/i;
            int pos = k/mod;
            sb.append(numlist.get(pos));
            numlist.remove(pos);
            k%=mod;
            //k用来帮助确定下一个循环的numlist中要移除的数的所在位置
            //也可以理解为pos是分组，k为组内偏移量
        }
        return sb.toString();
        
    }
    
    public static void main(String[] args) {
		
    	PermutationSequence s = new PermutationSequence();
		String res = s.getPermutation(4,10);
		System.out.println(res);
	}
}
