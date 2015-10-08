package ch5;
//Flip Bits to Win: You have an integer and you can flip exactly one bit from a 0 to 
//a 1. Write code to find the length of the longest sequence of 1s you could create.
public class Solution03 {
	static int SEQUENCE_LENGTH = 32;
	static int finalSequence = 0;
	public static int getMaxSequence(int[] sequences) {
		if (sequences[1] == 1) {
			return sequences[0] + sequences[2] + 1;
		} else if (sequences[1] == 0) {
			return Math.max(sequences[0], sequences[2]);
		} else {
			return Math.max(sequences[0], sequences[2]) + 1;
		}
	}
	public static void shift(int[] sequences) {
		sequences[2] = sequences[1];
		sequences[1] = sequences[0];
		sequences[0] = 0;
	}
	public static int longestSequence(int n) {
		int searchingFor = 0;
		int[] sequences = {0, 0, 0};
		int maxSequence = 1;
		for (int i = 0; i < SEQUENCE_LENGTH; i++) {
			if ((n & 1) != searchingFor) {
				if (searchingFor == 1) {
					maxSequence = Math.max(maxSequence, getMaxSequence(sequences));
				}
				searchingFor = n & 1;
				shift(sequences);
			}
			sequences[0]++;
			n >>>= 1;
		}
		// check final set of sequences
		if (searchingFor == 0) {
			shift(sequences);
		}
		return Math.max(finalSequence, getMaxSequence(sequences));
	}
	public static void main(String[] args) {
		System.out.println(longestSequence(9));
	}

}
