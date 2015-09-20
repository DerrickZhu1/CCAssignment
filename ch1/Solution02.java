package ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given two strings, write a method to decide if one is a permutation of the other
//assume case sensitive and whitespace is significant.
public class Solution02 {
	public static boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		
		int[] letters = new int[128]; // assume the character set is ASCII.
		char[] str1_array = str1.toCharArray();
		for (char c : str1_array) {
			letters[c]++;
		}
		for (int i = 0; i < str2.length(); i++) {
			char c = str2.charAt(i);
			letters[c]--;
			if (letters[c] < 0) // there are more c in str2, or no c. 
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str1 = reader.readLine();
		String str2 = reader.readLine();
		System.out.println(checkPermutation(str1, str2));
	}

}
