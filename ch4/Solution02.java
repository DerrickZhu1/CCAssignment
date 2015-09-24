package ch4;
//Minimal Tree: Given a sorted (increasing order) array with unique integer elements
//write an algorithm to create a binary search tree with minimal height.
public class Solution02 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	public static TreeNode createMinimalTree(int[] array) {
		return createMinimalTree(array, 0, array.length - 1);
	}
	public static TreeNode createMinimalTree(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
	    int mid = (start + end) / 2;
	    TreeNode root = new TreeNode(array[mid]);
	    //construct left subtree
	    root.left = createMinimalTree(array, start, mid - 1);
	    //construct right subtree
	    root.right = createMinimalTree(array, mid + 1, end);
	    return root;
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,7,8};
		TreeNode root = createMinimalTree(array);
		System.out.println(root.val);
	}

}
