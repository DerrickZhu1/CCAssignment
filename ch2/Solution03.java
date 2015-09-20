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

}
