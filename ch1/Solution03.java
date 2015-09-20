package ch1;

import java.io.IOException;

//URLify:Wiite a method to replace all spaces in a string with '%20', given the actual
//length of the string
public class Solution03 {
	public static void replaceSpace(char[] str, int length) {
		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ')
				spaceCount++;
		}
	    int newLength = length + 2 * spaceCount;
	    str[newLength] = '\0';
	    for (int i = length - 1; i >= 0; i--) {
	    	if (str[i] == ' ') {
	    		str[--newLength] = '0';
	    		str[--newLength] = '2';
	    		str[--newLength] = '%';
	    	}
	    	else {
	    		str[--newLength] = str[i];
	    	}
	    }
	}
	public static void main(String[] args) throws IOException {
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = "Mr John Smith     ";
		char[] str = s.toCharArray();
		int length = 13;
		replaceSpace(str, length);
		System.out.println(String.valueOf(str));		
	}

}
