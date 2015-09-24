package ch4;


public class Solution10 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		return subTree(t1, t2);
	}
	public static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null) {
			return false;
		} else if (r1.val == r2.val && matchTree(r1, r2)) {
			return true;
		}
		return (subTree(r1.left, r2) || subTree(r1.right, r2));
	}
	public static boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r2 == null && r1 == null) {
			return true;
		} else if (r1 == null || r2 == null) {
			return false;
		} else if (r1.val != r2.val) {
			return false;
		} else {
			return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
		}
	}

}
