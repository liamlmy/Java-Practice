// Reverse a singly-linked list.
//
// Examples
// L = null, return null
// L = 1 -> null, return 1 -> null
// L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null

/*
 * Method 1: recursion way
 */
/*
public class Solution {
  public ListNode reverse(ListNode head) {
    // Base case
    if (head == null || head.next == null) {
      return head;
    }
    // Recursion way
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
*/

/*
 * Method 2: Iteration way
 */
public class Solution {
  public ListNode reverse(ListNode head) {
    // Corner check
    if (head == null || head.next == null) {
      return head;
    }
    // Iteration way
    ListNode cur = head;
    ListNode next = null;
    ListNode prev = null;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}

/*
 * Method 3: Iteration way
 */
public class Solution {
  public ListNode reverse(ListNode head) {
    // Corner check
    if (head == null || head.next == null) {
      return head;
    }
    // Iteration way
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode next = head.next;
    head.next = null;
    while (next != null) {
      prev.next = next;
      next = next.next;
      prev.next.next = head;
      head = prev.next;
    }
    
    return dummy.next;
  }
}
