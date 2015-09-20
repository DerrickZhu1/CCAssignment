package ch2;
//Partition: Write code to partition a linked list around a value x, such that
//all node less than x come before all nodes greater than or equal to x.
public class Solution04 {
	public class ListNode {
		ListNode next;
		int val;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode partition(ListNode node, int x) {
		ListNode head = node;
		ListNode tail = node;
		
		while (node != null) {
			ListNode next = node.next;
			if (node.val < x) {
				//Insert node at head
				node.next = head;
				head = node;
			} else {
				//Insert node at tail
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		return head;
	}

}
