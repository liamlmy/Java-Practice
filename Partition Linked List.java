// Given a linked list and a target value T,
// partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T.
// The original relative order of the nodes in each of the two partitions should be preserved.
//
// Examples
// L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null

public class Solution {
  public ListNode partition(ListNode head, int target) {
    ListNode small = new ListNode(0);
    ListNode large = new ListNode(0);
    ListNode smallCur = small;
    ListNode largeCur = large;
    while (head != null) {
      if (head.value < target) {
        smallCur.next = head;
        smallCur = smallCur.next;
      } else {
        largeCur.next = head;
        largeCur = largeCur.next;
      }
      head = head.next;
    }
    // Connect the two partitions
    smallCur.next = large.next;
    // De-link the last node in the large partition
    largeCur.next = null;
    return small.next;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(1)
