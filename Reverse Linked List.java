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
    if (head == null) {
      return head;
    }
    // Iteration way
    while (head.next != null) {
      ListNode newHead = head.next.next
    }
  }
}
