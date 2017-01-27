package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
//class ListNode {
//	int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

public class Test {
	private String text;
	private String pattern;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
			
	public void KMPMatcher() {
		int n = text.length();
		int m = pattern.length();
		
		int prefix[] = computePrefix();
		for(int i: prefix)
			System.out.print(i+" ");
		int q=0;
		for(int i=0;i<n;i++){
			while(q>0 && text.charAt(i)!=pattern.charAt(q))
					q = prefix[q-1];
			if(text.charAt(i) == pattern.charAt(q))
				q++;
			if(q==m){
				System.out.println();
				q = prefix[q-1];
			}
		}
	}
	
	private int[] computePrefix() {
		int len = pattern.length();
		int[] prefix = new int[len];
		int k=0;
		for(int i=1;i<len;i++){
			while(k>0 && pattern.charAt(k)!=pattern.charAt(i)){
				k = prefix[k-1];
			}
			if(pattern.charAt(k) == pattern.charAt(i))
				k++;
			prefix[i] = k;
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		
		//String ptrn = "aabaabaaa";    prefix[] = {0,1,0,1,2,3,4,5,2}
		//另外一个对于理解prefix[]数组比较有帮助的例子：
		//ptrn = "acacabacacabacacac",  prefic[] = {0,0,1,2,3,0,1,2,3,4,5,6,7,8,9,10,11,4}
 	    String ptrn = "abcaby";
        String text = "abxabcabcaby";  
		

		Test kmp = new Test();
		//kmp.setText("ababacabacbababababacabcbabababaca");
//				kmp.setPattern("ababaca");
		//kmp.setPattern("ababaca");
		kmp.setPattern(ptrn);
		kmp.setText(text);
		kmp.KMPMatcher();
		
	}
}