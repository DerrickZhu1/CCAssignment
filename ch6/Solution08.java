package ch6;
/*
 The Egg Drop Problem: There is a building of 100 floors. If an egg drops from the Nth
 floor or above, it will break. If it's dropped from any floor below, it will not break.
 You're given two eggs. Find N, while minimizing the number of drops for the worst case.
 
 */
public class Solution08 {
	int breakingPoint;
	int countDrops = 0;
	boolean drop(int floor) {
		countDrops++;
		return floor >= breakingPoint;
	}
	int findBreakingPoint(int floors) {
		int interval = 14;
		int previousFloor = 0;
		int egg1 = interval;
		
		//Drop egg1 at decreasing intervals
		while (!drop(egg1) && egg1 <= floors) {
			interval -= 1;
			previousFloor = egg1;
			egg1 += interval;
		}
	    //Drop egg2 at 1 unit increments
		int egg2 = previousFloor + 1;
		while (egg2 < egg1 && egg2 <= floors && !drop(egg2)) {
			egg2 += 1;
		}
		return egg2 > floors ? -1 :egg2;
	}

}
