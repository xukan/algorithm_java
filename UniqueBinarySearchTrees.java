package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Snapchat

public class UniqueBinarySearchTrees {
	public static List<TreeNode> generateTrees(int n) {
		if(n==0) return new ArrayList<TreeNode>();
		return generate(1, n);
	}

	public static ArrayList<TreeNode> generate(int start, int end) {
		ArrayList<TreeNode> rst = new ArrayList<TreeNode>(); 
		if (start > end) {
			rst.add(null);// 这里需要加入一个空元素进去来表示这是一颗空树哈～
							// 并且同时也是保证下面循环时即使一边是空树，也会跑另一边
			return rst;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = generate(start, i - 1);
			ArrayList<TreeNode> right = generate(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					// should new a root here because it need to
					// be different for each tree
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					rst.add(root);
				}
			}
		}
		return rst;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
		List<TreeNode> res = s.generateTrees(3);
		for (TreeNode treeNode : res) {
			System.out.print(treeNode.val);
			System.out.println();
		}
	}
}
