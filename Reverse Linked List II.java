// Reverse a linked list from position m to n. Do it in-place and in one-pass.
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
// return 1->4->3->2->5->NULL.
// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.

public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    // Corner check
    if (head == null) {
      return head;
    }
    
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;               // make a pointer pre as a marker for the node before reversing
    while (int i = 0; i < m - 1; i++) {
    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
    // dummy-> 1 -> 2 -> 3 -> 4 -> 5   
      pre = pre.next;
    }
    ListNode start = pre.next;          // a pointer to the beginning of a sub-list that will be reversed
    ListNode then = start.next;         // a pointer to a node that will be reversed
    for (int i = 0; i < n - m; i++) {
      start.next = then.next;
      then.next = pre.next;
      pre.next = then;
      then = start.next;
    }
    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
    return dummy.next;
  }
}
