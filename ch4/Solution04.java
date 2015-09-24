package ch4;

import ch4.Solution03.TreeNode;

//Check Balanced
public class Solution04 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
    public static int getHeight(TreeNode root) {
    	if (root == null) 
    		return 0;
    	//check if left tree is balanced
    	int leftLength = getHeight(root.left);
    	if (leftLength == -1) {
    		return -1;
    	}
    	//check if right tree is balanced
    	int rightLength = getHeight(root.right);
    	if (rightLength == -1) {
    		return -1;
    	}
    	if (Math.abs(leftLength - rightLength) > 1) {
    		return -1;
    	} else {
    		return Math.max(leftLength, rightLength) + 1;
    	}
    		
    }
    public static boolean isBlanced(TreeNode root) {
    	if (getHeight(root) == -1) {
    		return false;
    	} else {
    		return true;
    	}	
    }
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		System.out.println(isBlanced(n1));
    }
}
