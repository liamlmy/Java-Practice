// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
// Note: Do not modify the linked list.
// Follow up:
// Can you solve it without using extra space?

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
