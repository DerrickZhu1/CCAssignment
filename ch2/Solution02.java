package ch2;

import ch2.Solution01.ListNode;

//Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list
public class Solution02 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public static ListNode nthToLast(ListNode head, int k) {
		ListNode p1 = head;
		ListNode p2 = head;
		
		for (int i = 0; i < k; i++) {
			if (p1 == null)
				return null;
			p1 = p1.next;
		}
		
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;	
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(3);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		ListNode result = nthToLast(head, 2);
		System.out.println(result.val);
	}
	

}
