package ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Implement an algorithm to determine if a string has all unique characters. What if you
//cannot use additional data structure.
public class Solution01 {
	public static boolean isUniqueChars(String string) {
		int checker = 0;//0 represents the char doesn't appear
		for (int i = 0; i < string.length(); i++) {
			int val = string.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {  //appear more than once
				return false;
			}
			checker |= (1 << val); // 1 represents the char appears
		}
	return true;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string = reader.readLine();
        System.out.println(isUniqueChars(string));	
	}
	
}
