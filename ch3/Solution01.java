package ch3;

import java.util.EmptyStackException;

//Describe how you could use a single array to implement three stacks
public class Solution01 {
	public class ThreeStacks {
		private int numberOfStacks = 3;
		private int stackCapacity;
		private int[] values;
		private int[] sizes;
		
		public ThreeStacks(int stackSize) {
			stackCapacity = stackSize;
			values = new int[stackSize * numberOfStacks];
			sizes = new int[numberOfStacks];
		}
		//push value onto stack
		public void push(int stackNum, int value) {
			sizes[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}
		//pop item from top stack
		public int pop(int stackNum) {
			if (isEmpty(stackNum)) {
				throw new EmptyStackException();
			}
			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex];
			values[topIndex] = 0;
			sizes[stackNum]--;
			return value;
		}
		//Return top element
		public int peek(int stackNum) {
			if (isEmpty(stackNum)) {
				throw new EmptyStackException();
			}
			return values[indexOfTop(stackNum)];
		}
		public boolean isEmpty(int stackNum) {
			return sizes[stackNum] == 0;
		}
		public boolean isFull(int stackNum) {
			return sizes[stackNum] == stackCapacity;
		}
		private int indexOfTop(int stackNum) {
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size - 1;
		}
	}

}
