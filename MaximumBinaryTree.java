package algorithm_java;

//Microsoft 

public class MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;
        TreeNode root = helper(nums,  0, nums.length-1);
        return root;
    }
    
    public TreeNode helper(int[] nums, int l, int r){
        if(l>r)
            return null;
        int index = getMax(nums, l, r);
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums, l, index-1);
        node.right = helper(nums, index+1, r);
        return node;
    }
    
    public int getMax(int[] nums, int l, int r){
        int index = l;
        for(int i=l+1;i<=r;i++)
            if(nums[i]>nums[index])
                index = i;
        return index;
    }
    
    public static void main(String[] args) {
    	MaximumBinaryTree s = new MaximumBinaryTree();
		int[] nums = {3,2,1,6,0,5};
		TreeNode root = s.constructMaximumBinaryTree(nums);
		
	}
}
