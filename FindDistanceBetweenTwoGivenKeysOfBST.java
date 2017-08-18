package algorithm_java;

//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=225078&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
/*
 *  construct BST 后找俩node之间distance
 *  Given a list of unique integers, construct the binary tree by given order without rebalancing, then find out the distance between two nodes.
 *  public static int bstDistance(int[] values, int n, int node1, int node2)
 *  for example, values= [5,6,3,1,2,4], n is the size of values, node1 is 2, node2 is 4, then function return 3
 *  构建完BST如下，2和4呢，距离就是3
 *           5
 *        /      \
 *       3       6
 *    /      \
 *  1        4
 *    \
 *     2
 * */
//build BST
//http://blog.csdn.net/yhhazr/article/details/7944089
/*
 * 两个Node的距离取决于从node1到node2经过的edge数，如果考虑用类似LCA的解法的话，如果两个node的LCA是其中一个node，
 * 因为我们的算法不会再往下递归了，所以没法得到两者的距离。
 * 所以这里我们先计算LCA，之后算出node1和node2和LCA的depth，depth1 + depth2 - 2 * depthLCA就是最终的结果。
 * 找LCA的时间复杂度是O(n)，因为是binary tree，找depth的时间复杂度也是O(n)，所以总的时间复杂度是O(n)
 * http://hehejun.blogspot.com/2015/01/algorithmget-distance-between-two-nodes.html
 * */

public class FindDistanceBetweenTwoGivenKeysOfBST {
	TreeNode root = null;
	public void buildBST(int[] input){
		for (int i = 0; i < input.length; i++) {  
			buildTree(root, input[i]);  
        }
	}
	
	public void buildTree(TreeNode node,int data){  
        if(root == null){  
            root = new TreeNode(data);  
        }else{  
            if(data < node.val){  
                if(node.left == null){  
                    node.left = new TreeNode(data);  
                }else{  
                    buildTree(node.left,data);  
                }  
            }else{  
                if(node.right == null){  
                    node.right = new TreeNode(data);  
                }else{  
                    buildTree(node.right,data);  
                }  
            }  
        }  
    }
	public void inOrder(TreeNode node){  
        if(node != null){  
            inOrder(node.left);  
            System.out.print(node.val+ " ");  
            inOrder(node.right);  
        }  
    }
	
	public int getDistanace(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || node1 == null || node2 == null)
			return -1;
		TreeNode ancestor = LCA(root, node1, node2);
		int depth1 = getDepth(root, ancestor); 
		int depth2 = getDepth(root, node1); 
		int depth3 = getDepth(root, node2); 
		return depth2 + depth3 - 2 * depth1;
	}

	public TreeNode LCA(TreeNode curr, TreeNode node1, TreeNode node2) {
		if (curr == null)
			return null;
		if (curr == node1 || curr == node2)
			return curr;
		TreeNode left = LCA(curr.left, node1, node2); 
		TreeNode right = LCA(curr.right, node1, node2); 
		if(left != null && right != null)
			return curr;
		return left == null? right: left;
	}

	public int getDepth(TreeNode curr, TreeNode target) {
		if (curr == null)
			return -1;
		if (curr == target)
			return 0;
		int left = getDepth(curr.left, target);
		int right = getDepth(curr.right, target);
		if (left == -1 && right == -1)
			return -1;
		return left == -1? right + 1: left + 1;
	}
	
	public static void main(String[] args) {
		FindDistanceBetweenTwoGivenKeysOfBST bTree= new FindDistanceBetweenTwoGivenKeysOfBST();
		int[] input = {5,6,3,1,2,4};
		bTree.buildBST(input);
		bTree.inOrder(bTree.root);
	}
}
