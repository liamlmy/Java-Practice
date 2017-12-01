// Given a list, rotate the list to the right by k places, where k is non-negative.
//
// Example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;
        ListNode start = dummy;
        int count = 0;
        while (end.next != null) {
            count++;
            end = end.next;
        }
        int move = count - k % count;
        while (move > 0) {
            start = start.next;
            move--;
        }
        end.next = dummy.next;
        dummy.next = start.next;
        start.next = null;
        return dummy.next;
    }
}
