package ch2;
//Loop Detection: Given a circular linked list, implement an algorithm that returns
//the node at the beginning of the loop.
public class Solution08 {
    public static class ListNode {
    	ListNode next;
    	int val;
    	ListNode(int x) {
    		val = x;
    	}
    }
    public static ListNode FindBeginningOfLoop(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	//find the meeting point
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if (slow == fast) {
    			break;
    		}
    	}
    	if (fast == null || fast.next == null) {
    		return null;
    	}
    	
    	slow = head;
    	while (slow != fast) {
    		slow = slow.next;
    		fast = fast.next;
    	}
    	return fast;
    }
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	ListNode first = new ListNode(2);
    	ListNode second = new ListNode(3);
    	ListNode third = new ListNode(4);
    	ListNode fourth = new ListNode(5);
    	head.next = first;
    	first.next = second;
    	second.next = third;
    	third.next = fourth;
    	fourth.next = second;
    	System.out.println(findBeginningOfLoop(head).val);
    }
}
