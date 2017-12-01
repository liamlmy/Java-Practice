// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.
//
// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smaller = new ListNode(0);
        ListNode s = smaller;
        ListNode larger = new ListNode(0);
        ListNode l = larger;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                s.next = cur;
                s = s.next;
            } else {
                l.next = cur;
                l = l.next;
            }
            cur = cur.next;
        }
        s.next = larger.next;
        l.next = null;
        return smaller.next;
    }
}
