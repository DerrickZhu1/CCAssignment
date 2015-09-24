package ch4;

import ch4.Solution03.TreeNode;


//Validate BST
public class Solution05 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	private static boolean isValidBST(TreeNode current, double min, double max) {
		if (current == null) {
			return true;
		}
		if (current.val <= min || current.val >= max) {
			return false;
		}
		return isValidBST(current.left, min, current.val) && isValidBST(current.right, current.val, max);
	}
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		System.out.println(isValidBST(n1));
	}
}
