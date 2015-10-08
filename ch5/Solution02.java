package ch5;
//Binary to String: Given a real number between 0 and 1 that is passed in as a double,
//print the binary representation. If the number cannot be represented accuately in binary
//with at most 32 characters, print "ERROR".
public class Solution02 {
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			//set the limited length
			if (binary.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
    public static void main(String[] args) {
    	double num = 0.625;
    	System.out.println(printBinary(num));
    }
}
