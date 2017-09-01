package algorithm_java;



/*
 *              5
 *           /      \
 *          4       8
 *         /       /    \
 *       11     13    4
 *      /    \             \
 *     7     2            1 
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Test {
	class Movie{
		String name;
		int time;
		public Movie(String name, int t){
			this.name = name;
			this.time = t;
		}
		
		public String toString(){
			return name + ":" + time;
		}
	}
	
	public List<Movie> play(HashMap<String, List<Integer>> schedule){
		List<String> movies = new ArrayList<String>(schedule.keySet());
		List<Movie> res = new ArrayList<>();
		if(helper(movies, schedule, 0, new HashSet<Integer>(), res))
			return res;
		return new ArrayList<Movie>();
	}
	
	public boolean helper(List<String> movies, HashMap<String, List<Integer>> schedule, int index, HashSet<Integer> set, List<Movie> res ){
		if(index == movies.size())
			return true;
		String m = movies.get(index);
		for(int t: schedule.get(m)){
			if(!set.contains(t)){
				res.add(new Movie(m, t));
				set.add(t);
				if(helper(movies, schedule, index+1, set, res))
					return true;
				set.remove(t);
				res.remove(res.size()-1);
			}
		}
		return false;
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l1= 0, l2=0, r1 = m-1, r2 = n-1;
        while(l1<=l2 && r1 <= r2){
            int m1 = l1 + (r1 - l1)/2;
            int m2 = l2 + (r2 - l2)/2;
            if(matrix[m1][m2] == target)
                return true;
            else if(matrix[m1][m2] < target){
                l1 = m1 +1;
                l2 = m2 +1;
            }else{
                r1 = m1 - 1;
                r2 = m2 - 1;
            }
        } 
        return false;
    }
	
	public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = String.join("", sentence)+" ";
        int len = str.length();
        int count = 0;
        for(int i=0;i<rows;i++){
            count+=cols;
            if(str.charAt(count%len)==' ')
                count++;
            else{
                while(count>0 && str.charAt((count-1)%len)!=' ')
                      count--;
            }
        }
        return count/len;
    }
	
	public boolean isPalindrome(int x) {
        int i=1;
        while(x/i>=10)
            i*=10;
        while(x!=0){
            if(x/i == x%10){
                x%=i;
                x/=10;
                i/=100;
            }else
                return false;
        }
        return true;
    }
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.start, i2.start);
            }
        });
        int k=0;
        for(int i=1;i<intervals.size();i++){
            while( i< intervals.size() && intervals.get(i).start<intervals.get(i-1).end){
//            	System.out.println(intervals.get(i).start + " " + intervals.get(i).end);
                intervals.get(i-1).end = Math.max(intervals.get(i).end, intervals.get(i-1).end);
                intervals.remove(i);
            }
        }
        return intervals;
    }
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(k<=0)
            return new int[0];
        int[] res = new int[nums.length-k+1];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty() && queue.peek() == i-k)
                queue.poll();
            if(!queue.isEmpty() && nums[queue.peekLast()] < nums[i] )
                queue.pollLast();
            queue.offer(i);
            if(i+1>=k)
                res[i-k+1] = nums[queue.peek()];
        }
        return res;
    }
	
	public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || k<=0)
            return 0;
        int pos = quickSelect(nums, 0, nums.length-1, nums.length-k+1);
        return nums[pos];
    }
    
    public int quickSelect(int[] nums, int low, int hi, int k){
        int pivot = nums[hi];
        int i=low;
        for(int j=low;j<hi;j++){
            if(nums[j]<=pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, hi);
        int m = i-low+1;
        if(m == k)
            return i;
        else if(m>k)
            return quickSelect(nums, low, i-1, k);
        else
            return quickSelect(nums, i+1, hi, k-m);
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m] == target){
                return m;
            }else if(nums[m]>target){
                if(nums[l]>target){
                    l = m+1;
                }else
                    r = m-1;
            }else{
                if(nums[r]<target)
                    r = m -1;
                else
                    l = m+1;
            }
        }
        return -1;
    }
	
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, "", 0, res);
        return res;
    }
    
    public void helper(String ip, String cur, int count, List<String> res){
        if(count == 3 && ip.length()>3 || ip.length() ==0)
            return;
        if(count == 3 && isValid(ip)){
            res.add(cur + ip);
            return;
        }
        for(int i=0;i<3 && i< ip.length();i++){
            String str = ip.substring(0, i+1);
            if(isValid(str))
                helper(ip.substring(i+1), cur+str+".", count+1, res);
        }   
    }
    
    public boolean isValid(String ip){
        if(ip.startsWith("0"))
            return ip.equals("0");
        int num = Integer.parseInt(ip);
        return 0<num && num <256;
    }
    
    public int titleToNumber(String s) {
        if(s.length()==0)
            return 0;
        int res = 0;
        for(int i = s.length()-1;i>=0;i--){
            int product = 1;
            for(int j=0;j<i;j++){
                product*=26;
            }
            res+=product*(s.charAt(i)-'A'+1);
        }
        return res;
    }
    
    public int calculate(String s) {
        if(s==null || s.length()==0)
            return 0;
        String postfix = convertToPostfix(s);
        System.out.println(postfix);
        return 0;
    }
    
    public String convertToPostfix(String s){
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + s.charAt(i++) - '0';
                }
                i--;
                sb.append(num).append("#");
            }else{
                switch(c){
                    case '(': case '^':
                        stack.push(c);
                        break;
                    case '+': case '-': case '*': case '/':
                        while(!stack.empty() && getPrecedence(c) <= getPrecedence(stack.peek()))
                            sb.append(stack.pop()).append("#");
                        stack.push(c);
                        break;
                    case ')':
                        if(!stack.empty()){
                            char top = stack.pop();
                            while(top!='('){
                                sb.append(top).append("#");
                                top = stack.pop();
                            }
                        }
                        break;
                }
            }
        }
        while(!stack.empty())
            sb.append(stack.pop()).append("#");
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    public int getPrecedence(char c){
        int p = 0;
        switch(c){
            case '(': case ')':
                return 0;
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
    public int hIndex(int[] citations) {
        if(citations.length == 1)
            return 0;
        Arrays.sort(citations);
        int len = citations.length;
        int hindex = 0;
        for(int i=0;i<len;i++){
            if((len - i>= citations[i]) && i<=citations[i])
                hindex = Math.max(hindex, citations[i]);
        }
        return hindex;
    }
    
    /***************************************************/
    class TrieNode{
        char c;
        boolean isWord;
        List<TrieNode> children;
        public TrieNode(){
            this.c = ' ';
            isWord = false;
            children = new ArrayList<TrieNode>();
        }
        public TrieNode(char c){
            this.c = c;
            isWord = false;
            children = new ArrayList<TrieNode>();
        }
        public TrieNode subNode(char c){
            for(TrieNode node: children)
                if(node.c == c)
                    return node;
            return null;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Test() {
        root = new TrieNode();        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
//        if(search(word))
//            return;
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            TrieNode node = cur.subNode(c);
            if(node == null){
                TrieNode n = new TrieNode(c);
                cur.children.add(n);
                cur = n;
            }else{
                cur = node;
            }
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word.length() == 0)
            return false;
        TrieNode cur = root;
        return helper(cur, 0, word);
    }
    
    public boolean helper(TrieNode node, int index, String word){
        if(node == null)
            return false;
        if(index == word.length())
            return node.isWord;
        char c = word.charAt(index);
        if(c!='.'){
            TrieNode n = node.subNode(c);
            return helper(n, index+1, word);
        }else{
            for(TrieNode n: node.children)
                if( helper(n, index+1, word))
                	return true;
        }
        return false;
    }
    
    
	public static void main(String[] args) {
//		"addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
//		["at"]          ,["and"],       ["an"],      ["add"],     ["a"],      [".at"],    ["bat"],   [".at"],    ["an."],  ["a.d."],  ["b."],   ["a.d"],  ["."]]
//		false,false,null,true,true,false,false,true,false]
		Test t = new Test();
		List<String> dict = Arrays.asList("aaaa","aaa");
		boolean res = t.wordBreak("aaaaaaa", dict);	
		System.out.println(res);
	}
}