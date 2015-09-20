package ch1;
//Zero Matrix:Write an algorithm such that if an element in an M X N matrix is 0,
//its entire row and column are set to 0.
public class Solution08 {
	public static void setRowZeros(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}
	public static void setColumnZeros(int[][] matrix, int column) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][column] = 0;
		}
	}
	public static void setZeros(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		//Check if first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		//Check if first column has a zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}
		//Check for zeros in the rest of the matrix
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		//Nullify rows based on values in first column
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				setRowZeros(matrix, i);
			}
		}
		//Nullify columns based on values in first row
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				setColumnZeros(matrix, j);
			}
		}
		//Nullify first row
		if (rowHasZero) {
			setRowZeros(matrix, 0);
		}
		//Nullify first column
		if (colHasZero) {
			setColumnZeros(matrix, 0);
		}		
	}
	public static void main(String[] args) {
		int[][] A = {{1,0,3},{4,5,6},{0,8,9}};
		int m = A.length;
		int n = A[0].length;
		setZeros(A);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
}
