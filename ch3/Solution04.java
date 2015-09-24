package ch3;

import java.util.Stack;

//Queue via Stacks
public class Solution04 {
	Stack<Integer> temp = new Stack<Integer>();
	Stack<Integer> value = new Stack<Integer>();
	
	//Push element x to the back of queue.
	public void push(int x) {
		if (value.isEmpty()) {
			value.push(x);
		} else {
			//put all the element
			while(!value.isEmpty()) {
				temp.push(value.pop());
			}
			value.push(x);
			
			while(!temp.isEmpty()) {
				value.push(temp.pop());
			}
		}
	}
	
	//Remove the element from in front of queue.
	public void pop() {
		value.pop();
	}
	public int peek() {
		return value.peek();
	}
	public boolean empty() {
		return value.isEmpty();
	}
}
