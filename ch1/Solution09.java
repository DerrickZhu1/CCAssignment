package ch1;
//String Rotation
public class Solution09 {
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		String s1s1 = s1 + s1;
		return s1s1.contains(s2);
	}
	
   public static void main(String[] args) {
	   String s1 = "waterbottle";
	   String s2 = "erbottlewat";
	   System.out.println(isRotation(s1, s2));
   }
}
