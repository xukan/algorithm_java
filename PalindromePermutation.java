package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Palindrome Permutation
//Google Uber Bloomberg
/*
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 * */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		//I Google Uber Bloomberg 
        // HashMap<Character, Integer> map = new HashMap<>();
        // for(char c: s.toCharArray()){
        //     map.put(c, map.getOrDefault(c,0)+1);
        // }
        // int count = 0;
        // for(Map.Entry<Character, Integer> entry: map.entrySet()){
        //     if(entry.getValue()%2==0)
        //         continue;
        //     if(entry.getValue()%2!=0){
        //         count++;
        //         if(count>1)
        //             return false;
        //     }
        // }
        // return true;
        
		//There are 128 characters in total in ASCII table 
        int[] map = new int[128];
        for(char c: s.toCharArray())
            map[c]++;
        int count = 0;
        for(int i: map){
            count += i%2;
            if(count>1)
                return false;
        }
        return true;
    }
	
	 public boolean canPermutePalindromeI(String s) {
		 //a better solution, just one loop
         int[] map = new int[128];
         int count = 0;
         for (int i = 0; i < s.length(); i++) {
             map[s.charAt(i)]++;
             if (map[s.charAt(i)] % 2 == 0)
                 count--;
             else
                 count++;
         }
         return count <= 1;
     }
	
	//II
	//tc: O((n/2)!)
	 //sc: O(n)
	 //先判断给定字符串s是否能构成回文,Palindrome Permutation I
	 //如果可以就用s的一半来拼回文的前一半，如果s的长度为奇数,那么单独记录多出来的字符ch,放在中间即可
	 //后一半就是前一半的反转
	public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        int[] map = new int[128];
        if(!canPermute(s, map))
            return res;
        char[] arr = new char[s.length()/2];
        char ch = 0;
        int k=0;
        for(int i=0;i<map.length;i++){
            if(map[i]%2==1)
                ch = (char)i;
            for(int j=0;j<map[i]/2;j++)
                arr[k++] = (char)i;
        }
        
        boolean[] visited = new boolean[arr.length];
        permute(arr, ch, "", visited, res);
        return res;
    }
    
    public void permute(char[] arr, char c, String str, boolean[] visited, List<String> res){
        if(str.length() == arr.length){
            res.add(str + (c==0?"":c) + new StringBuilder(str).reverse());
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i] == arr[i-1] && !visited[i-1])
                continue;
            if(!visited[i]){
                visited[i] = true;
                permute(arr, c, str + arr[i], visited, res);
                visited[i] = false;
            }
        }
    }
    
    public boolean canPermute(String s, int[] map){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
}
