package ch5;
//Next number: Given a positive number, print the next smallest and the next largest 
//number that have the same number of 1 bits in their binary representation
public class Solution04 {
	public static int getNext(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0)
			return -1;
		int p = c0 + c1; // position of rightmost non-trailing zero
		n |= (1 << p); // flip rightmost non-trailing zero
		n &= ~((1 << p) - 1);// clear all bits to the right of p
		n |= (1 << (c1 - 1)) - 1;// insert (c1 - 1) ones on the right
		return n;
	}
	public static int getPrev(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		int p = c0 + c1; //position of rightmost non-trailing one
		n &= ((~0) << (p + 1)); //clear from bit p onwards
		int mask = (1 << (c1 + 1)) - 1;
		n |= mask << (c0 - 1);
		return n;
	}
	public static void main(String[] args) {
		int n = 3;
		System.out.println(getNext(n) + " " + getPrev(n));
	}
	

}
