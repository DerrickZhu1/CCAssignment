package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Missing int: Given an input file with four billion non-negative integers, provide 
//an algorithm to generate an integer that is not contained in the file. Assume you
//have 1 GB of memory available for this task.
public class Solution07 {
      long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
      byte[] bitfield = new byte[(int) (numberOfInts / 8)];
      String filename;
      public void findOpenNumber() throws FileNotFoundException {
    	  Scanner in = new Scanner(new FileReader(filename));
    	  while (in.hasNext()) {
    		  int n =  in.nextInt();
    		  bitfield[n / 8] |= 1 << (n % 8);
    	  }
    	  for (int i = 0; i < bitfield.length; i++) {
    		  for (int j = 0; j < 8; j++) {
    			  //if equals 0, then is the corresponding value
    			  if ((bitfield[i] & (1 << j)) == 0) {
    				  System.out.println(i * 8 + j);
    				  return;
    			  }
    		  }
    	  }
      }
}
