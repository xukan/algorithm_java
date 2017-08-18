package algorithm_java;

import java.util.List;

//Definition of ExpressionTreeNode:
class ExpressionTreeNode {
	public String symbol;
	public ExpressionTreeNode left, right;

	public ExpressionTreeNode(String symbol) {
		this.symbol = symbol;
		this.left = this.right = null;
	}
}

public class ExpressionTreeBuild {
	public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if(expression == null || expression.length == 0)
            return null;
        List<ExpressionTreeNode> res = helper(expression, 0, 0);
        return res.get(0);
    }
    
    public List<ExpressionTreeNode> helper(String[] exp, int l, int r){
    	if(l>=r)
    		return ;
        while("0"<=exp[l] && exp[l]<="9")
            str += exp[l++];
        List<ExpressionTreeNode> left = helper(exp);
        List<ExpressionTreeNode> right = helper(exp);
        
        if(exp[l] == "+" || exp[l] == "-" || exp[l] == "*" || exp[l] == "/"){
            for(ExpressionTreeNode l : left){
                for(ExpressionTreeNode r: right){
                    ExpressionTreeNode node = new ExpressionTreeNode(exp[l]);
                    node.left = l;
                    node.right = r;
                }
            }
        }
        
    }
}
