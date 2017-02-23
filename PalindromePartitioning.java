package algorithm_java;

import java.util.ArrayList;
import java.util.List;
//Bloomberg

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        dfs(s, 0, temp, res);
        return res;
    }
    
	public void dfs(String s, int start, List<String> temp, List<List<String>> res){
		if(start == s.length()){
			res.add(new ArrayList<String>(temp));
			return;
		}
		for(int i=start;i<s.length();i++){
			String str = s.substring(start, i+1);
			if(isValidPalindrome(str)){
				temp.add(str);
				dfs(s, i+1, temp, res);
				temp.remove(temp.size()-1);
			}
		}
	}
    
    
    public boolean isValidPalindrome(String str){
    	int low =0;
    	int high = str.length()-1;
    	while(low<high){
    		if(str.charAt(low)==str.charAt(high)){
    			low++;
    			high--;
    		}
    		else{
    			return false;
    		}
    	}
    	return true;
    }
    
    //Palindrome Partitioning II
    //reference:
    //http://www.programcreek.com/2014/04/leetcode-palindrome-partitioning-ii-java/
    //http://www.cnblogs.com/springfor/p/3891896.html
    /*这道题需要先明确判断回文需要满足的条件
     * 1.  s.charAt(i) == s.charAt(j) 而且i-j<=1(i,j两个字符或者相邻或者重合)
     * 2.  s.charAt(i) == s.charAt(j) && dp[j+1][i-1]==true, 举个例子 ab.......bc
     *                                                                                               i        j 
     *数组cut,cut[i]表示从第0位置到第位置的切割数，这个数字初始值就是cut[i]=i,
     *表示初始时， 最坏情况的切割数                                                                                             
     * */
    
    public int minCut(String s) {
        int n = s.length();
        //dp[i][j]表示字符串[i,j]从第i个位置（包含）到第j个位置（包含） 是否是回文。
    	boolean dp[][] = new boolean[n][n];
    	int cut[] = new int[n];
    	for (int i = 0; i < n; i++) 
    		cut[i] = i; //set maximum # of cut
    	
    	for (int i = 0; i < n; i++) {
    		//cut[i] = i; //set maximum # of cut
    		for (int j = 0; j <= i; j++) {
    			//j must be less than i
    			if (s.charAt(j) == s.charAt(i) && (i - j <= 1 || dp[j+1][i-1])) {
    				dp[j][i] = true;
     
    				// if need to cut, add 1 to the previous cut[i-1]
    				if (j > 0){
    					cut[i] = Math.min(cut[i], cut[j-1] + 1);
    				}else{
    				// if [0...i] is palindrome, no need to cut    
    					cut[i] = 0; 
    				}	
    			}
    		}
    	}
     
    	return cut[n-1];
    }
    
    public static void main(String[] args){
    	//String input = "aabaa";
    	String input = "aaaba";
    	PalindromePartitioning s = new PalindromePartitioning();
    	List<List<String>> res=s.partition(input);
    	for(List<String> l:res){  
    		for(String ss : l)
    			System.out.print(ss+" ");
    		System.out.println();
    	}
    	String input2 = "caaaba";
    	int cut = s.minCut(input2);
    	System.out.println(cut);
    }
}
