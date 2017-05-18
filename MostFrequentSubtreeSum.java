package algorithm_java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 *      26
       /     \
     10      3
    /    \      \
  4      6      3
 * */

//Sum Root to Leaf Numbers
//

public class MostFrequentSubtreeSum {
	int max = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null)
			return new int[0];
		Map<Integer, Integer> map = new HashMap<>();
		helper(root, map);
		List<Integer> res = new LinkedList<>();
		for (Map.Entry<Integer, Integer> me : map.entrySet()) {
			if (me.getValue() == max)
				res.add(me.getKey());
		}
		return res.stream().mapToInt(i -> i).toArray();
	}

	private int helper(TreeNode n, Map<Integer, Integer> map) {
		if (n.left == null)
			return 0;
		int left = helper(n.left, map);
		int right = helper(n.right, map);
		int sum = left + right + n.val;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		max = Math.max(max, map.get(sum));
		return sum;
	}

	public static void main(String[] args) {
		MostFrequentSubtreeSum s = new MostFrequentSubtreeSum();
		TreeNode root = new TreeNode(26);
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		 int[] res = s.findFrequentTreeSum(root);
		 for(int i: res)
			 System.out.print(i+" ");
	}
}
