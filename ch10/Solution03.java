package ch10;
//Given a sorted array of n integers that has been rotated an unknown number of times,
//write code to find an element in the array. You may assume the array was originally sorted
//in increasing order.
public class Solution03 {
   public static int search(int a[], int left, int right, int x) {
	   int mid = (left + right) / 2;
	   if ( x == a[mid]) {
		   return mid;
	   }
	   if (right < left) {
		   return -1;
	   }
	   
	   //We need to find out which side is normally order.
	   if (a[left] < a[mid]) {
		   if (x >= a[left] && x < a[mid]) {
			   return search(a, left, mid - 1, x);
		   } else {
			   return search(a, mid + 1, right, x);
		   }
	   } else if (a[mid] < a[left]) {
		   if (x > a[mid] && x <= a[right]) {
			   return search(a, mid + 1, right, x);
		   } else {
			   return search(a, left, mid - 1, x);
		   }
	   } else if (a[left] == a[mid]) {   //left side is all repeats
		   if (a[mid] != a[right]) {
			   return search(a, mid + 1, right, x);
		   } else {  //have to search both halves
			   int result = search(a, left, mid - 1, x); 
			   if (result == -1) {
				   return search(a, mid + 1, right, x);
			   } else {
				   return result;
			   }
		   }
	   }
	   return -1;
   }
   public static void main(String[] args) {
	   int[] a = {15,16,19,20,25,1,3,4,5,7,10,14};
	   System.out.println(search(a, 0, 11, 5));   
   }
}
