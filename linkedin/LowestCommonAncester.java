public class LowestCommonAncester{
  public TreeNode lowestCommonAncester(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null)
			return null;
		if (root == n1 || root == n2)
			return root;
		TreeNode left = lowestCommonAncester(root.left, n1, n2);
		TreeNode right = lowestCommonAncester(root.right, n1, n2);
		if (left != null && right != null)
			return root;
		return left == null ? right : left;
	}
}
