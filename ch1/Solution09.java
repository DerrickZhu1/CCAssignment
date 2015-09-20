package ch1;
//String Rotation
public class Solution09 {
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}
	
	public static boolean isSubstring(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			for (int j = i; j < s1.length(); j++) {
				if (s1.substring(i, j) == s2)
					return true;
			}
		}
		return false;
	}
   public static void main(String[] args) {
	   String s1 = "waterbottle";
	   String s2 = "erbottlewat";
	   System.out.println(isRotation(s1, s2));
   }
}
