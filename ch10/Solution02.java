package ch10;
//Write a method to sort an array of strings so that all the anagrams are next to each other
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution02 {
       public static String sortChars(String s) {
    	   char[] content = s.toCharArray();
    	   Arrays.sort(content);
    	   return new String(content);
       }
       public static void sort(String[] array) {
    	   HashMap<String, ArrayList<String>> stringMap = 
    			   new HashMap<>();
    	   //Group words by anagram
    	   for (String s : array) {
    		   String key = sortChars(s);
    		   if (!stringMap.containsKey(key)) {
    			   stringMap.put(key, new ArrayList<String>());
    		   }
    	       stringMap.get(key).add(s);
    	   }
    	   //Convert to array
    	   int index = 0;
    	   for (String key : stringMap.keySet()) {
    		   ArrayList<String> list = stringMap.get(key);
    		   for (String s : list) {
    			   array[index] = s;
    			   index++;
    		   }
    	   }
       }
       public static void main(String[] args) {
    	   String[] array = {"apple", "pplea","boy","fafa","yob","alepp"};
    	   sort(array);
    	   for (String s: array) {
    		   System.out.print(s + " ");
    	   }
       }
}
