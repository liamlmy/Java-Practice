// Find the middle node of a given linked list.
//
// Examples
// L = null, return null
// L = 1 -> null, return 1
// L = 1 -> 2 -> null, return 1
// L = 1 -> 2 -> 3 -> null, return 2
// L = 1 -> 2 -> 3 -> 4 -> null, return 2

public class Solution {
  public ListNode middleNode(ListNode head) {   // This is an on-line algorithm
    // Corner check
    if (head == null || head.next == null) {
      return head;
    }
    // Finding the middle ListNode
    ListNode slow = head;
    ListNode fast = head;
    // When fast pointer pointing to the last non-null ListNode or second last non-null ListNode,
    // the slow pointer is pointing the middle ListNode.
    while (fast.next != null && fast.next.next != null) {     
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(1)
