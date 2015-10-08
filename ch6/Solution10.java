package ch6;

import java.util.ArrayList;

public class Solution10 {
	public static class Bottle {
		private boolean poisoned = false;
		private int id;
		public Bottle(int id) {
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setAsPoisoned() {
			poisoned = true;
		}
		public boolean isPoisoned() {
			return poisoned;
		}
	}
	public static class TestStrip {
		public static int DAYS_FOR_RESULT = 7;
		private ArrayList<ArrayList<Bottle>> dropsByDay = 
				new ArrayList<ArrayList<Bottle>>();
		private int id;
		public TestStrip(int id) {
			this.id = id;
		}
		public int getId() {
			return id;
		}
		//Resize list of days/drops to be large enough
		private void sizeDropsForDay(int day) {
			while (dropsByDay.size() <= day) {
				dropsByDay.add(new ArrayList<Bottle>());
			}
		}
		//Add drop from bottle on specific day
		public void addDropOnDay(int day, Bottle bottle) {
			sizeDropsForDay(day);
			ArrayList<Bottle> drops = dropsByDay.get(day);
			drops.add(bottle);
		}
		//Check if any of the bottles in the set are poisoned
		private boolean hasPoison(ArrayList<Bottle> bottles) {
			for (Bottle b : bottles) {
				if (b.isPoisoned()) {
					return true;
				}
			}
			return false;
		}
		
		//Gets bottles used in the test DAYS_FOR_RESULT days ago
		public ArrayList<Bottle> getLastWeeksBottles(int day) {
			if (day < DAYS_FOR_RESULT) {
				return null;
			}
			return dropsByDay.get(day - DAYS_FOR_RESULT);
		}
		//Check for poisoned bottles since before DAYS_FOR_RESULT
		public boolean isPositiveOnDay(int day) {
			int testDay = day - DAYS_FOR_RESULT;
			if (testDay < 0 || testDay >= dropsByDay.size()) {
				return false;
			}
			for (int d = 0; d <= testDay; d++) {
				ArrayList<Bottle> bottles = dropsByDay.get(d);
				if (hasPoison(bottles)) {
					return true;
				}
			}
			return false;
		}
	}
	public void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips) {
		for (Bottle bottle : bottles) {
			int id = bottle.getId();
			int bitIndex = 0;
			while (id > 0) {
				if ((id & 1) == 1) {
					testStrips.get(bitIndex).addDropOnDay(0, bottle);
				}
				bitIndex++;
				id >>= 1;
			}
		}
	}
	public ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips, int day) {
		ArrayList<Integer> positive = new ArrayList<Integer>();
		for (TestStrip testStrip : testStrips) {
			int id = testStrip.getId();
			if (testStrip.isPositiveOnDay(day)) {
				positive.add(id);
			}
		}
		return positive;
	}
	public int setBits(ArrayList<Integer> positive) {
		int id = 0;
		for (Integer bitIndex : positive) {
			id |= 1 << bitIndex;
		}
		return id;
	}
	public int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		runTests(bottles, strips);
		ArrayList<Integer> positive = getPositiveOnDay(strips, 7);
		return setBits(positive);
	}

}
