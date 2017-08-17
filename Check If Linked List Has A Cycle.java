// Check if a given linked list has a cycle. Return true if it does, otherwise return false.

public class Solution {
  public boolean hasCycle(ListNode head) {
    // Corner case
    if (head == null || head.next == null) {
      return false;
    }
    // Checking
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(1)
