package ch2;
//Partition: Write code to partition a linked list around a value x, such that
//all node less than x come before all nodes greater than or equal to x.
public class Solution04 {
	public static class ListNode {
		ListNode next;
		int val;
		ListNode(int x) {
			val = x;
		}
	}
	public static ListNode partition(ListNode node, int x) {
		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;
		
		//Partition list
		while (node != null) {
			ListNode next = node.next;
			node.next = null;
			if (node.val < x) {
				//Insert node into end of before list
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				//Insert node into end of after list
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		if (beforeStart == null) {
			return afterStart;
		}
		//Merge before list and after list
		beforeEnd.next = afterStart;
		return beforeStart;		
	}
	public static void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode node1 = new ListNode(5);
		head.next = node1;
		ListNode node2 = new ListNode(8);
		node1.next = node2;
		ListNode node3 = new ListNode(5);
		node2.next = node3;
		ListNode node4 = new ListNode(10);
		node3.next = node4;
		ListNode node5 = new ListNode(2);
		node4.next = node5;
		ListNode node6 = new ListNode(1);
		node5.next = node6;
		printLinkedList(head);
		System.out.println();
		head = partition(head, 5);
		printLinkedList(head);
		
	}
}
