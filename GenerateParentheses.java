package algorithm_java;

//Google Uber Zenefits

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public List<String> generateParenthesis(int n) {  
        ArrayList<String> res = new ArrayList<String>();
        String item = new String();
        
        if (n<=0)
            return res;  
            
        dfs(res,item,n,n);  
        return res;  
    }  
      
    public void dfs(ArrayList<String> res, String item, int left, int right){ 
        if(left > right)//deal wiith ")("
            return;
            
        if (left == 0 && right == 0){  
            res.add(new String(item));  
            return;  
        }
        
        if (left>0) 
            dfs(res,item+'(',left-1,right);  
        if (right>0) 
            dfs(res,item+')',left,right-1);  
    }
	
	public static void main(String[] args) {
		GenerateParentheses solution = new GenerateParentheses ();
		List<String> res = solution.generateParenthesis(3);
		for( String s : res)
			System.out.println( s + " " );
	}
}
