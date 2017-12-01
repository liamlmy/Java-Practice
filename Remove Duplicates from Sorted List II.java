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
