package leetCode;

public class IsSubtree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isEqual(TreeNode s, TreeNode t) {
		if (t == s)
			return true;
		if (t == null || s == null)
			return false;
		if (s.val == t.val)
			return isEqual(s.left, t.left) && isEqual(s.right, t.right);
		return false;
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (t == s)
			return true;
		if (t == null || s == null)
			return false;

		boolean isSub = false;
		if (s.val == t.val)
			isSub = isEqual(s.left, t.left) && isEqual(s.right, t.right);
		if (!isSub)
			isSub = isSubtree(s.left, t) || isSubtree(s.right, t);

		return isSub;
	}

	public static void main(String[] args) {
	}

}
