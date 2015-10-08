package ch5;
//Conversion: Write a function to determine the number of bits you would need to flip to
//convert integer A to B
public class Solution06 {
     public static int bitNeeded(int A, int B) {
    	 int count = 0;
    	 //Check every bit of C to see if it equals 1
    	 for (int C = A ^ B; C != 0; C = C >> 1) {
    		 count += C & 1;  
    	 }
    	 return count;
     }
     public static void main(String[] args) {
    	 int A = 1, B = 5;
    	 System.out.println(bitNeeded(A, B));
     }
}
