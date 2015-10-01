package ch10;
//Peaks and Valleys. Given an array of integers, sort the array into an alternating
//sequence of peaks and valleys.
public class Solution11 {
    public static int maxIndex(int[] array, int a, int b, int c) {
    	int len = array.length;
    	int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
    	int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
    	int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;
    	
    	int max = Math.max(aValue, Math.max(bValue, cValue));
    	if (aValue == max)
    		return a;
    	else if (bValue == max)
    		return b;
    	else 
    		return c;
    }
    public static void sortValleyPeak(int[] array) {
    	for (int i = 1; i < array.length; i += 2) {
    		int biggestIndex = maxIndex(array, i - 1, i, i + 1);
    		if (i != biggestIndex) {
    			swap(array, i, biggestIndex);
    		}
    	}
    }
    //swap function
    public static void swap(int[] array, int left, int right) {
    	int temp = array[left];
    	array[left] = array[right];
    	array[right] = temp;
    }
    public static void main(String[] args) {
    	int[] array = {5,3, 1, 2, 3};
    	sortValleyPeak(array);
    	for (int i = 0; i < array.length; i++)
    		System.out.print(array[i] + " ");
    }
}
