package ch2;
//Sum Lists: Write a function that adds the two numbers and returns the sum as a linked list
public class Solution05 {
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    	}
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummyHead = new ListNode(0);
    	ListNode curr = dummyHead;
    	int carry = 0;
    	while (l1 != null || l2 != null) {
    		int x = (l1 != null) ? l1.val : 0;
    		int y = (l2 != null) ? l2.val : 0;
    		int digit = carry + x + y;
    		carry = digit / 10;
    		curr.next = new ListNode(digit % 10);
    		curr = curr.next;
    		if (l1 != null) l1 = l1.next;
    		if (l2 != null) l2 = l2.next;
    	}
    	if (carry > 0) {
    		curr.next = new ListNode(carry);
    	}
    	return dummyHead.next;
    }
    public static void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(7);
    	ListNode l2 = new ListNode(1);
    	l1.next = l2;
    	ListNode l3 = new ListNode(6);
    	l2.next = l3;
    	ListNode m1 = new ListNode(5);
    	ListNode m2 = new ListNode(9);
    	m1.next = m2;
    	ListNode m3 = new ListNode(2);
    	m2.next = m3;
    	ListNode head = addTwoNumbers(l1, m1);
    	printLinkedList(head);
    }
}
