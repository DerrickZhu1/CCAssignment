package ch4;

//Successor
public class Solution06 {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	private static TreeNode getLeftMost(TreeNode head) {
		TreeNode current = head;
	    while (current.left != null)
	    	current = current.left;
	    return current;
	}
	private static TreeNode getRightMost(TreeNode head) {
		TreeNode current = head;
		while (current.right != null) 
			current = current.right;
		return current;
	}
	public static int getSuccessor(TreeNode head, int target) {
		TreeNode current = head;
		int successor = 0;
		while (current != null) {
			if (current.val < target && current.right != null)
				current = current.right;
			else if (current.val > target) {
				if (current.left != null && getRightMost(current.left).val > target)
					current = current.left;
				else {
					successor = current.val;
					current = null;
				}
			} else {
				if (current.right != null)
					successor = getLeftMost(current.right).val;
				current = null;
			}
		}
		return successor;
	}
}
