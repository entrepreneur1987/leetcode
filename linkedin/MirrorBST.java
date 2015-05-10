public class MirrorBST {
	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int v;

		TreeNode(int v) {
			this.v = v;
		}
	}

	public static TreeNode mirrorBST(TreeNode root) {
		if (root == null)
			return null;
		TreeNode leftChild = mirrorBST(root.left);
		TreeNode rightChild = mirrorBST(root.right);
		root.left = rightChild;
		root.right = leftChild;
		return root;
	}
}
