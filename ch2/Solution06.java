package ch2;

import java.util.Stack;
//Accepted
//Implement a function to check if a linked list is palindrome
public class Solution06 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int a) {
		    val = a;
		}
	}
	public static boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		//If it has odd number of elements, skip the middle element
		if (fast != null) {
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop();
			//if they are different, so it's not a palindrome.
			if (top != slow.val)
				return false;
			slow = slow.next;
		}
		return true;
	}
       public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
    	ListNode l2 = new ListNode(1);
    	l1.next = l2;
    	ListNode l3 = new ListNode(2);
    	l2.next = l3;
    	ListNode l4 = new ListNode(1);
    	l3.next = l4;
    	ListNode l5 = new ListNode(0);
    	l4.next = l5;
    	System.out.println(isPalindrome(l1));
	}

}
