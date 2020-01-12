// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = head;
        while (j != null) {
            while (j.next != null && j.next.val == j.val) {
                j = j.next;
            }
            if (i.next == j) {
                i = i.next;
            } else {
                i.next = j.next;
            }
            j = j.next;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null || fast.next.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
                slow.next = null;
            } else {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
