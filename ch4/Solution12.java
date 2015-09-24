package ch4;

import java.util.HashMap;


//Paths with Sum: it must go downwards,does not need to start or end at the root or a leaf
public class Solution12 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	public static int countPathsWithSum(TreeNode node, int target, int runningSum,
			HashMap<Integer, Integer> pathCount) {
		 if (node == null) return 0;
		 runningSum += node.val;
		 incrementHashTable(pathCount, runningSum, 1);
		 
		 //Count paths with sum ending at the current node
		 int sum = runningSum - target;
		 int totalPaths = pathCount.containsKey(sum) ? pathCount.get(sum) : 0;
		 
		 //Count path with sum on the left and right
		 totalPaths += countPathsWithSum(node.left, target, runningSum, pathCount);
		 totalPaths += countPathsWithSum(node.right, target, runningSum, pathCount);
		 incrementHashTable(pathCount, runningSum, -1);
		 return totalPaths;
	}
	public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		if (!hashTable.containsKey(key)) {
			hashTable.put(key, 0);
		}
		hashTable.put(key, hashTable.get(key) + delta);
	}
	public static int countPathsWithSum(TreeNode root, int target) {
		if (root == null)
			return 0;
		HashMap<Integer, Integer> pathCount = new HashMap<Integer, Integer>();
		incrementHashTable(pathCount, 0, 1);
		return countPathsWithSum(root, target, 0, pathCount);
	}
	
	
}
