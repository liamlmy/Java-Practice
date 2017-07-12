// Insert a value in a sorted linked list.
//
// Examples
// L = null, insert 1, return 1 -> null
// L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
// L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
// L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null

public class Solution {
  public ListNode insert(ListNode head, int value) {
    ListNode node = new ListNode(value);
    // Case 1: determin if the inserted node is before the head
    if (head == null || head.value >= value) {
      node.next = head;
      return node;
    }
    // Case 2: insert the node to the right position
    ListNode cur = head;
    while (cur.next != null && cur.next.value < value) {
      cur = cur.next;
    }
    ListNode next = cur.next;
    cur.next = node;
    node.next = next;
    return head;
  }
}
