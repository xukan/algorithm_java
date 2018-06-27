package algorithm_java;

//Uber

/*
 * Steps:
 * Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
 * Once the node is found, have to handle the below 4 cases
 * 1.node doesn't have left or right - return null
 * 2.node only has left subtree- return the left subtree
 * 3.node only has right subtree- return the right subtree
 * 4.node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, 
 *    then recursively delete the minimum value in the right subtree
 *    
 *    The worst case time complexity of delete operation is O(h) where h is height of Binary Search Tree.
 *     In worst case, we may have to travel from root to the deepest leaf node. 
 *     The height of a skewed tree may become n and the time complexity of delete operation may become O(n)
 * */

public class DeleteNodeinaBST {
	//recursion in text books
	/*
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

//			TreeNode minNode = findMin(root.right);
//			root.val = minNode.val;
//			root.right = deleteNode(root.right, root.val);
			
			TreeNode maxNode = findMax(root.left);
            root.val = maxNode.val;
            root.left = deleteNode(root.left, root.val);
		}
		return root;
	}

	private TreeNode findMin(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	private TreeNode findMax(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
	*/

	//iteration
	//https://discuss.leetcode.com/topic/67962/iterative-solution-in-java-o-h-time-and-o-1-space/2
	//https://discuss.leetcode.com/topic/67962/iterative-solution-in-java-o-h-time-and-o-1-space
	private TreeNode deleteRootNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode next = root.right;
        TreeNode pre = null;
        //for(; next.left != null; pre = next, next = next.left);
        while(next.left!=null){
			pre = next;
			next = next.left;
		}
        next.left = root.left;
        if(root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null && cur.val != key) {
            pre = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            }
        }
        if (pre == null) {
            return deleteRootNode(cur);
        }
        if (pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;
    }
	
    //recursion
    public TreeNode deleteNode_recursion(TreeNode root, int key) {
        if (root == null)
        	return null;
        if (root.val > key)
        	root.left = deleteNode_recursion(root.left, key);
        else if (root.val < key) 
        	root.right = deleteNode_recursion(root.right, key);
        else { // found node to be deleted
            if (root.left == null) 
            	return root.right;
            else if (root.right == null) 
            	return root.left;
            // node with two children, replace with the inOrder successor(minVal) in the right subtree
            root.val = getMin(root.right);
            root.right = deleteNode_recursion(root.right, root.val);
        }
        return root;
    }
    
    public int getMin(TreeNode root) {
        while (root.left != null)
        	root = root.left;
        return root.val;
    }
    
	public void inorder(TreeNode cur){
		if(cur.left!=null)
			inorder(cur.left);
		System.out.print(cur.val+" ");
		if(cur.right!=null)
			inorder(cur.right);
	}
	
	public static void main(String[] args) {
		DeleteNodeinaBST s = new DeleteNodeinaBST();
		/*case1, node to be deleted is a leaf
		 * just delete the node
		 *      50                                 50
               /     \         delete(20)      /     \
             30      70       --------->   30     70 
            /   \     /   \                         \     /  \ 
          20   40 60  80                     40  60  80
		 * 
		 * */
		
//		TreeNode root = new TreeNode(50);
//		TreeNode node1 = new TreeNode(30);
//		TreeNode node2 = new TreeNode(70);
//		TreeNode node3 = new TreeNode(20);
//		TreeNode node4 = new TreeNode(40);
//		TreeNode node5 = new TreeNode(60);
//		TreeNode node6 = new TreeNode(80);
//		
//		root.left = node1;
//		root.right = node2;
//		node1.left = node3;
//		node1.right = node4;
//		node2.left = node5;
//		node2.right = node6;
//		
//		TreeNode node= s.deleteNode(root,20 );
//		s.inorder(node);
		
		/*case2, node to be deleted has one child
		 * copy the value of child to the node, then delete child node
		 *  50                                50
           /     \         delete(30)      /   \
         30      70       --------->   40     70 
            \     /   \                               /  \ 
            40 60  80                          60   80
		 * 
		 * */
		/*
		TreeNode root = new TreeNode(50);
		TreeNode node1 = new TreeNode(30);
		TreeNode node2 = new TreeNode(70);
		TreeNode node3 = new TreeNode(40);
		TreeNode node4 = new TreeNode(60);
		TreeNode node5 = new TreeNode(80);
		
		root.left = node1;
		root.right = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		TreeNode node= s.deleteNode(root,30 );
		s.inorder(node);
		*/
		/*case3, node to be deleted has two children
		 * find inorder successor of the node, copy the contents of inorder successor to the node and then delete the inorder successor. 
		 * Note that inorder predecessor can also be used.
		 *                   10
		 *                 /      \ 
		 *               6        12
		 *            /     \        \ 
 		 *          3        9      18
 		 *        /   \      /
 		 *       1    5   7
 		 *                   \
 		 *                    8    
		 * */
		
		TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(12);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(9);
		TreeNode node5 = new TreeNode(18);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(5);
		TreeNode node8 = new TreeNode(7);
		TreeNode node9 = new TreeNode(8);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		node3.left =node6;
		node3.right=node7;
		node4.left = node8;
		node8.right = node9;
//		TreeNode node= s.deleteNode(root,6 );
		TreeNode node= s.deleteNode_recursion(root, 6);
		s.inorder(node);
	}
}
