package ch2;

import java.util.HashSet;

//Remove Dups: Write code to remove duplicates from an unsorted linked list.
public class Solution01 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public static void deleteDup(ListNode head) {
		ListNode previous = null;
		ListNode current = head;
		HashSet<Integer> set = new HashSet<Integer>();
		while (current != null) {
			if (set.contains(current.val)) {
				previous.next = current.next;
			} else {
				set.add(current.val);
				previous = current;
			}
			current = current.next;
		}	
	}
	public static void deleteDup2(ListNode head) {
		ListNode current = head;
		while (current != null) {
			ListNode runner = current;
			while (runner.next != null) {
				if (runner.next.val == current.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	public static void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(4);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		printLinkedList(head);
		deleteDup(head);
		System.out.println();
		printLinkedList(head);
		
	}

}
