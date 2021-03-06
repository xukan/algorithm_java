package algorithm_java;

public class RecoverBinarySearchTree {
//	public static void recoverTree(TreeNode root) {
//		TreeNode cur = root;
//		TreeNode prev = null;
//		TreeNode first = null, second = null;
//		while(cur != null){
//			if(cur.left == null){
//				if(prev!=null && prev.val > cur.val){
//					if(first == null){
//						first = prev;
//						second = cur;
//					}else
//						second = cur;
//				}
//				prev = cur;
//				cur = cur.right;
//			}else{
//				TreeNode temp = cur.left;
//				while(temp.right!=null && temp.right != cur){
//					temp = temp.right;
//				}
//				if(temp.right == null){
//					temp.right = cur;
//					cur = cur.left;
//				}else{
//					if(prev != null && prev.val>cur.val){
//						if(first == null){
//							first = prev;
//							second = cur;
//						}else
//							second = cur;
//					}
//					prev = cur;
//					temp.right = null;
//					cur = cur.right;
//				}
//			}
//		}
//		int k = first.val;
//		first.val = second.val;
//		second.val = k;
//	}
	
	//morris traversal algorighm
	//The idea is to use prev to remeber previous node, cur is current node,
	//one, two, three, four remember two pairs of nodes that cur.val <= prev.val
	//if only one pair of nodes is swapped, three and four will be null.
	//if one~four are not null, then swap one.val and four.val.
	TreeNode one=null;
    TreeNode two = null;
    TreeNode three = null;
    TreeNode four = null;
	
	public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur!=null){
            if(cur.left == null){
                if(prev!=null && cur.val <= prev.val){
                	if(one == null){
                        one = prev;
                        two = cur;
                    }else if(three == null){
                        three = prev;
                        four = cur;
                    }
                }
                prev = cur;
                cur = cur.right;
            }else{
                TreeNode temp = cur.left;
                while(temp.right!=null && temp.right != cur){
                    temp = temp.right;
                }
                if(temp.right==null){
                    temp.right = cur;
                    cur = cur.left;
                }else{
                    if(prev!=null && cur.val<=prev.val){
                    	if(one == null){
                            one = prev;
                            two = cur;
                        }else if(three == null){
                            three = prev;
                            four = cur;
                        }
                    }
                    prev = cur;
                    temp.right = null;
                    cur = cur.right;
                }
            }
        }
        if(three == null){
            int tmp = one.val;
            one.val = two.val;
            two.val = tmp;
        }else{
            int tmp = one.val;
            one.val = four.val;
            four.val = tmp;
        }
    }
	
	
	public static void main(String[] args) {
		RecoverBinarySearchTree s = new RecoverBinarySearchTree();
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		root.right=node1;
		node1.right = node2;

		s.recoverTree(root);
	}
}
