package ch10;
//Find Duplicates: You have an array with all the numbers from 1 to N, where N is at
//most 32,000. The array may have duplicate entries and you do not know what N is. With
//only 4 kilobytes of memory available, how would you print all duplicate elements in the array?
public class Solution08 {
    public static class BitSet {
    	int[] bitset;
    	public BitSet(int size) {
    		bitset = new int[size >> 5 + 1]; //int => 4 bytes(32 bit)
    	}
    	public boolean get(int pos) {
    		int numberIndex = pos >> 5;
    		int bitIndex = pos & 0x1F;
    		return (bitset[numberIndex] & (1 << bitIndex)) != 0;
    	}
    	public void set(int pos) {
    		int numberIndex = pos >> 5;
    		int bitIndex = pos & 0x1F;
    		bitset[numberIndex] |= 1 << bitIndex;
    	}	
    }
    public static void checkDuplicates(int[] array) {
    	BitSet bs = new BitSet(32000);
    	for (int i = 0; i < array.length; i++) {
    		int num = array[i];
    		int num0 = num - 1;  //bitset starts at 0, numbers start at 1.
    		if (bs.get(num0)) {
    			System.out.println(num);
    		} else {
    			bs.set(num0);
    		}
    	}
    }
    public static void main(String[] args) {
    	int[] array = {1,2,1,5,54,545};
        checkDuplicates(array);
    }
}
