package ch5;
//Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and j
//Write a method to insert M into N such that M starts at bit j and ends at bit i.
public class Solution01 {
	public static int insertionMtoN(int N, int M, int i, int j) {
		int allOnes = ~0;
		//Create 1s before position j, 0s after position j
		int left = allOnes << (j + 1);
		//create 1s after position i
		int right = (1 << i) - 1;
		//create mask which has all 0s between i and j
		int mask = left | right;
		//clear bits j through i 
		int clearedN = N & mask;
		//move m to right position
		int shiftedM = M << i;
		//merge M into N
		return clearedN | shiftedM;
	}
	public static void main(String[] args) {
		int N = 1024;
		int M = 19;
		int i = 2, j = 6;
		System.out.println(insertionMtoN(N, M, i, j));
	}
	

}
