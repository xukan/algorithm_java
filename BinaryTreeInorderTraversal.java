package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Morris Algorithm
//http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
/*
* 算法具体分情况如下：
1. 如果当前结点的左孩子为空，则输出当前结点并将其当前节点赋值为右孩子。
2. 如果当前节点的左孩子不为空，则寻找当前节点在中序遍历下的前驱节点（也就是当前结点左子树的最右孩子）。接下来分两种情况：
a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点（做线索使得稍后可以重新返回父结点）。
  然后将当前节点更新为当前节点的左孩子。
b) 如果前驱节点的右孩子为当前节点，表明左子树已经访问完，可以访问当前节点。
  将它的右孩子重新设为空（恢复树的结构）。输出当前节点。
  当前节点更新为当前节点的右孩子。
*/
/*
*                         5
*                       /    \
*                     4       8
*                   /         /  \
*                 11      13   4
*                /    \          /  \
*              7      2       5    1
* */


public class BinaryTreeInorderTraversal {
	public static List<Integer> inorderTraversal(TreeNode root) {
		//Morris  Traversal Algorithm
		//Time Complexity: O(n)
		//Space Complexity: O(1)
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root, prev = null;
        while(cur!=null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                prev = cur.left;
                while(prev.right!=null && prev.right !=cur){
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right = cur;
                    cur = cur.left;
                }else{
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
	public static void main(String[] args){
		 TreeNode root = new TreeNode(5);
		 TreeNode node1 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(11);
		 TreeNode node4 = new TreeNode(13);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(7);
		 TreeNode node7 = new TreeNode(2);
		 TreeNode node8 = new TreeNode(5);
		 TreeNode node9 = new TreeNode(1);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;
		 node5.left = node8;
		 node5.right = node9;
		 List<Integer> res = inorderTraversal(root);
		 for(Integer i : res)
			 System.out.print(i+" ");
		 System.out.println();
	} 
	
}
