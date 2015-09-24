package ch3;
//Stack Min: push, pop and min should all operate in O(1) time.
public class Solution02 {
	public class Node {
		int value;
		int min;
		Node next;
		
		Node(int x) {
			value = x;
			min = x;
			next = null;
		}
	}
	
	public class minStack {
		Node head;
		
		public void push(int x) {
			if (head == null){
				head = new Node(x);
			}
			else {
				Node temp = new Node(x);
			    temp.min = Math.min(x, head.min);
			    temp.next = head;
			    head = temp;
			}
		}
		public void pop() {
			if (head == null)
				return;
			head = head.next;
		}
		public int min() {
			if (head == null) 
				return Integer.MAX_VALUE;
			return head.min;
		}
	}

}
