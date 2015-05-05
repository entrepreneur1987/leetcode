public class TreeSerializationRelated {
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		String c;

		TreeNode(String c) {
			this.c = c;
		}
	}

	public String serializeNormal(TreeNode n) {
		StringBuilder ret = new StringBuilder();
		serializeHelper(n, ret);
		return ret.toString().trim();
	}

	private void serializeHelper(TreeNode n, StringBuilder builder) {
		if (n == null) {
			builder.append("# ");
			return;
		}
		builder.append(n.c + " ");
		serializeHelper(n.left, builder);
		serializeHelper(n.right, builder);
	}

	private int index = 0;

	public TreeNode deserializeNormal(String s) {
		index = 0;
		String[] tokens = s.split("\\s+");
		return deserializeNormal(tokens);
	}

	private TreeNode deserializeNormal(String[] tokens) {
		if (tokens[index].equals("#")) {
			index++;
			return null;
		}
		TreeNode root = new TreeNode(tokens[index++]);
		root.left = deserializeNormal(tokens);
		root.right = deserializeNormal(tokens);
		return root;
	}

	public static void main(String[] args) {
		TreeSerializationRelated tr = new TreeSerializationRelated();
		TreeNode t = new TreeNode("a");
		t.left = new TreeNode("b");
		t.right = new TreeNode("c");
		t.right.left = new TreeNode("d");
		t.right.right = new TreeNode("e");
		t.right.right.right = new TreeNode("f");
		String serialized = tr.serializeNormal(t);
		System.out.println(serialized);
		TreeNode t2 = tr.deserializeNormal(serialized);
		System.out.println();
	}
}
