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
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	head.next.next.next.next.next = new ListNode(3);
    	ListNode result = FindBeginningOfLoop(head);
    	System.out.println(result.val);
    	
    }
    
    
}
