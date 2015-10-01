package ch10;

//Sorted Matrix Search: Given an M * N matrix in which each row and each column is
//sorted in ascending order, write a method to find an element.
public class Solution09 {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length, m = matrix[0].length;
		return helper(matrix, 0, n - 1, 0, m - 1, target);
	}

	public static boolean helper(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd, int target ){
	    if(rowStart>rowEnd||colStart>colEnd){
	            return false;
	 }
	    int rm=(rowStart+rowEnd)/2, cm=(colStart+colEnd)/2;
	        if(matrix[rm][cm]== target){
	            return true;
	        }
	        else if(matrix[rm][cm] >target){
	            return helper(matrix, rowStart, rm-1,colStart, cm-1,target)||
	                helper(matrix,  rm, rowEnd, colStart,cm-1,target) ||
	                helper(matrix, rowStart, rm-1,cm, colEnd,target);
	        }
	        else{
	            return helper(matrix, rm+1, rowEnd, cm+1,colEnd,target)||
	                helper(matrix,  rm+1, rowEnd, colStart,cm,target) ||
	                helper(matrix, rowStart, rm,cm+1, colEnd,target);
	        }
	}

	public static void main(String[] args) {
		int[] row1 = { 15, 20, 40, 85 };
		int[] row2 = { 20, 35, 80, 95 };
		int[] row3 = { 30, 55, 95, 105 };
		int[] row4 = { 40, 80, 100, 120 };
		int[][] matrix = new int[4][4];
		matrix[0] = row1;
		matrix[1] = row2;
		matrix[2] = row3;
		matrix[3] = row4;
		System.out.println(searchMatrix(matrix, 120));
	}
}
