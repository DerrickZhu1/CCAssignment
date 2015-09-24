package ch4;

import java.util.Random;

public class Solution11 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		int size = 0;
		TreeNode(int x) {
			val = x;
			size = 1;
		}
		int size() {
			return size;
		}
		public TreeNode getIthNode(int i) {
			int leftSize = left == null ? 0 : left.size();
			if (i < leftSize) {
				return left.getIthNode(i);
			} else if (i == leftSize) {
				return this;
			} else {
				return right.getIthNode(i - (leftSize + 1));
			}
		}
		public TreeNode find(int d) {
			if (d == val) {
				return this;
			} else if (d <= val) {
				return left != null ? left.find(d) : null;
			} else if (d >= val) {
				return right != null ? right.find(d) : null;
			}
			return null;
		}
		public void insertInOrder(int d) {
			if (d <= val) {
				if (left == null) {
					left = new TreeNode(d);
				} else {
					left.insertInOrder(d);
				}
			} else {
				if (right == null) {
					right = new TreeNode(0);
				} else {
					right.insertInOrder(d);
				}
			}
			size++;
		}
	}
	public class Tree {
		TreeNode root = null;
		public int size() {
			return root == null ? 0 : root.size();
		}
		public TreeNode getRandomNode() {
			if (root == null)
				return null;
			Random random = new Random();
			int i = random.nextInt(size());
			return root.getIthNode(i);
		}
		
		public void insertInOrder(int value) {
			if (root == null) {
				root = new TreeNode(value);
			} else {
				root.insertInOrder(value);
			}
		}
	}

}
