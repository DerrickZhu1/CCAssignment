package ch1;
//Rotate Matrix: Given an image represented by an N X N matrix, where each pixel
//in the image is 4 bytes, write a method to rotate the image by 90 degrees.
public class Solution07 {
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 -layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				//left -> top
				matrix[first][i] = matrix[last - offset][first];
				//bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				//right -> bottom
	            matrix[last][last - offset] = matrix[i][last];
	            //top -> right
	            matrix[i][last] = top;
			}
		}
	}
	public static void main(String[] args) {
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		int m = A.length;
		int n = A[0].length;
		rotate(A);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

}
