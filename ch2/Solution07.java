package ch2;
//Intersection: Given two (singly) linked lists, determine if the two lists intersect.
//Return the intersecting node.
public class Solution07 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public class Result {
		public ListNode tail;
		public int size;
		public Result(ListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}
	public Result getTailAndSize(ListNode list) {
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
	public ListNode getKthNode(ListNode head, int k) {
		ListNode current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}
	public ListNode findIntersection(ListNode list1, ListNode list2) {
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

}
