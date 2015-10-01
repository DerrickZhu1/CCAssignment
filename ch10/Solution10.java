package ch10;
/*Rank from Stream
Implement the method track(int x), which is called when each number is generated,
and the method getRankOfNumber(int x), which returns the number of values less than
or equal to x(not including x itself).
*/
public class Solution10 {
     public class RankNode {
    	 public int leftSize = 0;
    	 public RankNode left, right;
    	 public int data = 0;
    	 public RankNode(int d) {
    		 data = d;
    	 }
    	 public void insert(int d) {
    		 if (d <= data) {
    			 if (left != null) {
    				 left.insert(d);
    			 } else {
    				 left = new RankNode(d);
    			 }
    			 leftSize++;
    		 } else {
    			 if (right != null) right.insert(d);
    			 else right = new RankNode(d);
    		 }
    	 }
    	 public int getRank(int d) {
    		 if (d == data) {
    			 return leftSize;
    		 } else if (d < data) {
    			 if (left == null) return -1;
    			 else return left.getRank(d);
    		 } else {
    			 int rightRank = right == null ? -1 : right.getRank(d);
    			 if (rightRank == -1) return -1;
    			 else return leftSize + rightRank + 1;
    		 }
    	 }	 
     }
     RankNode root = null;
     public void track(int number) {
    	 if (root == null) {
    		 root = new RankNode(number);
    	 } else {
    		 root.insert(number);
    	 }
     }
     public int getRankOfNumber(int number) {
    	 return root.getRank(number);
     }
}
