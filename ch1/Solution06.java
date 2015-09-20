package ch1;

import java.io.IOException;

//String compression   a2b1c5a3
public class Solution06 {
    public static String compress(String s) {
    	StringBuilder compressedS = new StringBuilder();//use StringBuider instead of String
    	int count = 0;
    	for (int i = 0; i < s.length(); i++) {
    		count++;
    		//if ith element not equals to (i + 1)th element
    		//pay attention to the last index
    		if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
    			compressedS.append(s.charAt(i));
    			compressedS.append(count);
    			count = 0;
    		}
    	}
    	return compressedS.length() < s.length() ? compressedS.toString() : s;
    }
    public static void main(String[] args) throws IOException {
    	//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	//String s = reader.readLine();
    	String s;
    	s = compress("aabccccaaa");
    	System.out.println(s);
    }
}
