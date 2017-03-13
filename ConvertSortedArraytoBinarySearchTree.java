package algorithm_java;

//Airbnb

/*
 * An empty tree is height-balanced. A non-empty binary tree T is balanced if:
 * 1) Left subtree of T is balanced
 * 2) Right subtree of T is balanced
 * 3) The difference between heights of left subtree and right subtree is not more than 1.  
 * 
 * */

//Convert Sorted List to Binary Search Tree
//Zenefits

public class ConvertSortedArraytoBinarySearchTree {
	public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
        	return null;
        return helper(nums, 0, nums.length-1);
    }
	
	public static TreeNode helper(int[] nums, int l, int r){
		if(l>r)
			return null;
		int m = (l+r)/2;
		TreeNode node = new TreeNode(nums[m]);
		node.left = helper(nums, l, m-1);
		node.right = helper(nums, m+1, r);
		return node;
	}
	
	public static void main(String a[]){        
        int[] input = {1,2,3,4,5,6};
        TreeNode root = sortedArrayToBST(input);
            System.out.println(root.val);;
    }
}
