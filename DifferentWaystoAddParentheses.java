package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * this question is similar to Unique Binary Search Trees II
 * input :  2*3 - 4*5
 *             *                                      *
 *          /     \                                 /      \ 
 *        2       -                              2         *
 *              /     \                                    /    \
 *            3       *                                 -       5
 *                   /    \                            /     \
 *                  4     5                         3      4
 *     2*( 3-(   4 * 5 ) )               2 * ( ( 3 - 4 ) * 5 )
 *     
 *                                  -
 *                               /     \
 *                             *        *
 *                           /   \     /    \      
 *                         2    3   4      5
 *                      ( 2 * 3 ) - ( 4 * 5 )    
 *        
 *            *                                       *
 *          /     \                                 /      \ 
 *        *       5                             -         5
 *       /     \                                /   \
 *      2       -                            *     4  
 *             /    \                       /    \
 *            3     4                    2      3
 *   ( 2 * ( 3- 4)) * 5              ((2 * 3) - 4 ) * 5 
 *                      
 * */

public class DifferentWaystoAddParentheses {
	
//	Map<String, List<Integer>> map = new HashMap<>();
//	public List<Integer> diffWaysToCompute(String input) {
//		if(map.containsKey(input))
//            return map.get(input);
//        List<Integer> res = new ArrayList<>();
//        for(int i=0;i<input.length();++i){
//            char c=input.charAt(i);
//            if(c=='+'|| c=='-' || c=='*'){
//                List<Integer> list1 = diffWaysToCompute(input.substring(0,i));
//                List<Integer> list2 = diffWaysToCompute(input.substring(i+1));
//                for(int v1:list1){
//                    for(int v2: list2){
//                        if(c=='+')
//                            res.add(v1+v2);
//                        if(c=='-')
//                            res.add(v1-v2);
//                        if(c=='*')
//                            res.add(v1*v2);
//                    }
//                }
//            }
//        }
//        if(res.isEmpty())
//            res.add(Integer.parseInt(input));
//        map.put(input, res);
//        return res;
//    }
	
	
	HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if(map.containsKey(input))
            return map.get(input);
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c == '+' ||c == '-' ||c == '*' ){
                List<Integer> l1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> l2 = diffWaysToCompute(input.substring(i+1));
                for(int v1: l1){
                    for(int v2: l2){
                        if(c=='+')
                            res.add(v1+v2);
                        if(c=='-')
                            res.add(v1+v2);
                        if(c=='*')
                            res.add(v1+v2);
                    }
                }
            }
        }
        if(res.size()==0)
            res.add(Integer.parseInt(input));
        map.put(input, res);
        return res;
    }
	
	public static void main(String[] args) {
		DifferentWaystoAddParentheses s = new DifferentWaystoAddParentheses();
		String input = "2*3-4*5";
		List<Integer> res = s.diffWaysToCompute(input);
		res.forEach(i->System.out.print(i+  " "));
	}
}
