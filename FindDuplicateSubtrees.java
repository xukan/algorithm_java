package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Google

//One question: why "val+left+right" and "left+right+val" are correct, but "left+val+right" is wrong?
/*
 * If you tried "left + val + right"
 * You'll get error for the test case:
 * [0,0,0,0,null,null,0,null,null,null,0]
 *           0
            /    \
          0      0
         /          \         
        0           0
                      \
                       0
 * In this case, left most subtree is:
       0
      / \
    0    #
   / \
  #   #
  So in-order traversal will be : [#0#0#]
  While right most subtree is:
    0
   /  \
 #    0
     /   \
    #    #
 * 
 * */

public class FindDuplicateSubtrees {
	/*
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		Map<String, TreeNode> dup = new HashMap<>();
		List<TreeNode> result = new ArrayList<>();
		traverse(root, dup);

		//return dup.values().stream().filter(a -> a!=null).collect(Collectors.toList());
		for(TreeNode e : dup.values())
			if(e != null)
				result.add(e);
		return result;
	}
	
	private String traverse(TreeNode root, Map<String, TreeNode> dup) {
		if(root == null)
			return "#";
		String left = traverse(root.left, dup);
		String right = traverse(root.right, dup);
		String serializedTree = root.val + left + right;
	
		if(dup.containsKey(serializedTree))
			dup.put(serializedTree, root);
		else 
			dup.put(serializedTree, null);
		return serializedTree;
	}
	*/
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        Map<String, TreeNode> map = new HashMap<String, TreeNode>();
        traverse(root, map);
        for(TreeNode node: map.values())
            res.add(node);
        return res;
    }
    
    public String traverse(TreeNode node, Map<String, TreeNode> map){
        if(node == null)
            return "#";
        String left = traverse(node.left, map);
        String right = traverse(node.right, map);
        String serialTree = node.val + left + right;
        if(!map.containsKey(serialTree))
            map.put(serialTree, null);
        else
            map.put(serialTree, node);
        return serialTree;
    }
	
	public static void main(String[] args) {
		/*
		 *     1
		       / \
		      2  3
		     /   / \
		    4  2  4
		       /
		      4
		 * */
		FindDuplicateSubtrees s = new FindDuplicateSubtrees();
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(4);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node6;
		List<TreeNode> res = s.findDuplicateSubtrees(root);
	}
}
