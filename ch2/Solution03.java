package ch2;
//Delete middle Node
public class Solution03 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public void deleteMiddle(ListNode n) {
		if (n == null || n.next == null)
			return;
		ListNode nextNode = n.next;
		n.val = nextNode.val;
		n.next = nextNode.next;
	}
	public static void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode first = new ListNode(2);
		head.next = first;
		ListNode second = new ListNode(3);
		first.next = second;
		ListNode third = new ListNode(4);
		second.next = third;
		deleteMiddle(second);
		printLinkedList(head);
	}

}
