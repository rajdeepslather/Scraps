package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class IsSymmetric {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(final int x) {
			val = x;
		}
	}

	public boolean isMirror(final TreeNode t1, final TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;

		return (t1.val == t2.val)
				&& isMirror(t1.right, t2.left)
				&& isMirror(t1.left, t2.right);
	}

	public boolean isSymmetricRecursive(final TreeNode root) {
		return isMirror(root.left, root.right);
	}

	public boolean isSymmetric(final TreeNode root) {
		final Deque<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);

		while (!q.isEmpty()) {
			final TreeNode t1 = q.poll();
			final TreeNode t2 = q.poll();

			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return false;
			if (t1.val != t2.val)
				return false;

			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}

	public static void main(final String[] args) {
	}

}
