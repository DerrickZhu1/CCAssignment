package ch4;

import java.util.ArrayList;
import java.util.LinkedList;

//List of Depths: Given a binary tree, design an algorithm which create a linkedlist
//of all the nodes at each depth.
public class Solution03 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
		}
		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode p : parents) {
				if (p.left != null) {
					current.add(p.left);
				}
				if (p.right != null) {
					current.add(p.right);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		ArrayList<LinkedList<TreeNode>> result = createLevelLinkedList(n1);
		for (LinkedList<TreeNode> l : result) {
			for (TreeNode m : l) {
				System.out.print(m.val + " ");
			}
			System.out.println( );
		}
		
	}
}
