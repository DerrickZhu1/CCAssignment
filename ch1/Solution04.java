package ch1;
//Palindrome Permutation: Given a string, write a function to check if it
//is a permutation of a palindrome.
//Assume case insensitive
public class Solution04 {
    public static int getCharNumber(char c) {  	
    	if ('a' <= c && c <= 'z') {
    		return c - 'a';
    	} else if ('A' <= c && c <= 'Z') {  //case insensitive
    		return c - 'A';
    	}
    	return -1;
    }
    
    public static boolean isPermutationOfPalindrome(String s) {
    	int countOdd = 0;
    	int[] table = new int['z' - 'a' + 1];
    	for (char c : s.toCharArray()) {
    		int x = getCharNumber(c);
    		if (x != -1) {
    			table[x]++;
    			if (table[x] % 2 == 1) {
    				countOdd++;
    			} else {
    				countOdd--;
    			}
    		}
    	}
    	return countOdd <= 1;
    }
    public static void main(String[] args) {
    	System.out.println(isPermutationOfPalindrome("Tact Coa"));
    }
}
