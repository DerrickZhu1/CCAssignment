package ch2;
//Intersection: Given two (singly) linked lists, determine if the two lists intersect.
//Return the intersecting node.
public class Solution07 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public static class Result {
		public ListNode tail;
		public int size;
		public Result(ListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}
	public static Result getTailAndSize(ListNode list) {
		if (list == null)
			return null;
		int size = 1;
		ListNode current = list;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}
	public static ListNode getKthNode(ListNode head, int k) {
		ListNode current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}
	public static ListNode findIntersection(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null)
			return null;
		//Get tail and sizes
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);
		
		if (result1.tail != result2.tail) {
			return null;
		}
		ListNode shorter = result1.size < result2.size ? list1 : list2;
		ListNode longer = result1.size < result2.size ? list2 : list1;
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return longer;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(9);
		ListNode l5 = new ListNode(7);
		ListNode l6 = new ListNode(2);
		ListNode l7 = new ListNode(1);
		ListNode m1 = new ListNode(4);
		ListNode m2 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		m1.next = m2;
		m2.next = l5;
		System.out.println(findIntersection(l1, m1).val);
	}
}
