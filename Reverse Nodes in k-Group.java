// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
// k is a positive integer and is less than or equal to the length of the linked list.
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
// You may not alter the values in the nodes, only nodes itself may be changed.
// Only constant memory is allowed.
//
// For example,
// Given this linked list: 1->2->3->4->5
// For k = 2, you should return: 2->1->4->3->5
// For k = 3, you should return: 3->2->1->4->5

/*
 * Method 1: Recursion way
 */
/*
public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode cur = head;
    int count = 0;
    while (cur != null && count != k) {
      cur = cur.next;
      count++;
    }
    if (count == k) {
      cur = reverseKGroup(cur, k);
      while (count > 0) {
        ListNode temp = head.next;
        head.next = cur;
        cur = head;
        head = temp;
        count--;
      }
      head = cur;
    }
    return head;
  }
}
*/

/*
 * Method 2: Iteration way
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int i = 0;

        while (cur != null) {
            i++;
            if (i % k == 0) {
                pre = reverse(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
 
/*
 * 0->1->2->3->4->5->6
 * |           |   
 * pre        next
 *
 * after calling pre = reverse(pre, next)
 * 
 * 0->3->2->1->4->5->6
 *          |  |
 *          pre next 
 */
    private ListNode reverse(ListNode pre, ListNode next) {
        ListNode start = pre.next;
        ListNode then = start.next;

        while (then != next) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return start;
    }
}
