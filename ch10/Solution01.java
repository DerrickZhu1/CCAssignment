package ch10;
//You are given two sorted arrays, A and B, where A has a large enough buffer at the 
//end to hold B. Write a method to merge B into A in sorted order.
public class Solution01 {
   public static void merge(int[] A, int[] B, int numberA, int numberB) {
	   int indexA = numberA - 1; //index of last element in array A
	   int indexB = numberB - 1; //index of last element in array B
	   int indexMerged = numberA + numberB - 1;//index of last element in merged array
	   
	   //Merge A and B, starting from the last element in each
	   while (indexB >= 0) {
		   if (indexA >= 0 && A[indexA] > B[indexB]) {
			   A[indexMerged] = A[indexA]; //copy element
			   indexA--;
		   } else {
			   A[indexMerged] = B[indexB]; //copy element
			   indexB--;
		   }
		   indexMerged--;   //move indices
	   }	   
   }
   public static void main(String[] args) {
	   int[] A = new int[30];
	   int[] B = {4,5,8,10,21};
	   A[0] = 1;
	   A[1] = 11;
	   A[2] = 34;
	   merge(A, B, 3, 5);
	   for (int i = 0; i <= 7; i++) {
		   System.out.print(A[i] + " ");
	   }
   }
}
