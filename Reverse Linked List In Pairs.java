// Reverse pairs of elements in a singly-linked list.
//
// Examples
// L = null, after reverse is null
// L = 1 -> null, after reverse is 1 -> null
// L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
// L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null

public class Solution {
  /*
   * Recursion method
   */
  public ListNode reverseInPairs(ListNode head) {
    // Base case
    if (head == null || head.next == null) {
      return head;
    }
    
    // Recursion rule
    ListNode restHead = reverseInPairs(head.next.next);
    ListNode newHead = head.next;
    newHead.next = head;
    newHead.next.next = restHead;
    return newHead;
  }
  
  /*
   * Iteration method
   */
   /*
   public ListNode reverseInPairs(ListNode head) {
    ListNode dummyHead = new ListNode(0);     // Need a dummy head
    dummyHead.next = head;
    ListNode current = dummyHead;
    while (current.next != null && current.next.next != null) {     // Known four nodes
      ListNode next = current.next.next;                            // Operate the two middle nodes
      current.next.next = next.next;
      next.next = current.next;
      current.next = next;
      current = current.next.next;
    }
    return dummyHead.next;
   }
   */
}

class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value) {
    this.value = value;
    next = null;
  }
}
