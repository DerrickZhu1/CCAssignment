package ch1;
// One edit distance
public class Solution05 {
	public static boolean isOneEditDistance(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		//keep m < n
		if (m > n) 
			return isOneEditDistance(s2, s1);
		if (n - m > 1)
			return false;
		int i = 0, shift = n - m;
		while (i < m && s1.charAt(i) == s2.charAt(i)) 
			i++;
		//append
		if (i == m) return shift > 0;
		//modify
		if (shift == 0) i++;
		//insert
		while (i < m && s1.charAt(i) == s2.charAt(i + shift))
			i++;
		return i == m;			
  }
   public static void main(String[] args) {
	   String s1 = "adfb";
	   String s2 = "adfbe";
	   System.out.println(isOneEditDistance(s1, s2));
   }
}
