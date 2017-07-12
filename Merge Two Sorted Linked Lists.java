// Merge two sorted lists into one large sorted list.
//
// Examples
// L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
// L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
// L1 = null, L2 = null, merge L1 and L2 to null

public class Solution {
  public ListNode merge(ListNode one, ListNode two) {
    ListNode dummyNode = new ListNode(0);
    ListNode cur = dummyNode;
    while (one != null && two != null) {
      if (one.value <= two.value) {
        cur.next = one;
        one = one.next;
      } else {
        cur.next = two;
        two = two.next;
      }
      cur = cur.next;
    }
    // Link the possible remaining nodes
    if (one != null) {
      cur.next = one;
      one = one.next;
      cur = cur.next;
    }
    if (two != null) {
      cur.next = two;
      two = two.next;
      cur = cur.next;
    }
    return dummyNode.next;
  }
}
