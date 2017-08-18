package algorithm_java;

import java.util.Arrays;

public class AssignCookies {
	//solution1:
	//反向看greed factor
	public int findContentChildren(int[] g, int[] s) {
        if(s.length==0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for(int i=g.length-1, j=s.length-1;i>=0;i--){
            if(s[j]>=g[i]){
                count++;
                j--;
            }
            if(j<0)
                break;
        }
        return count;
    }
	
	//solution2:
	//正向看cookie
	public int findContentChildren_(int[] g, int[] s) {
        if(s.length==0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j=0;
        for(int i=0;i<s.length;i++){
            if(s[i]>=g[j]){
                count++;
                j++;
                if(j==g.length)
                    break;
            }
        }
        return count;
    }
}
