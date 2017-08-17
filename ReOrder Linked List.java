// Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be
// N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
//
// Examples
// L = null, is reordered to null
// L = 1 -> null, is reordered to 1 -> null
// L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
// L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null

public class Solution {
  public ListNode reorder(ListNode head) {
    // Corner check
    if (head == null || head.next == null) {
      return head;
    }
    // Reorder the linked list
    // Step 1: find the middle node
    ListNode mid = middleNode(head);
    // Step 2: find the first half of the linked list and second half of the linked list
    ListNode one = head;
    ListNode two = mid.next;
    // Step 3: de-link the second half from the list
    mid.next = null;
    // Step 4: reverse the second half linked list
    two = reverse(two);
    // Step 5: merge the two linked lists
    return merge(one, two);
  }
  
  private ListNode middleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
  
  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
  
  private ListNode merge(ListNode one, ListNode two) {
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;
    while (one != null && two != null) {
      cur.next = one;
      one = one.next;
      cur = cur.next;
      cur.next = two;
      two = two.next;
      cur = cur.next;
    }
    if (one != null) {
      cur.next = one;
    }
    return dummyHead.next;
  }
}

// Time complexity: O(n) = O(n + n / 2 + n) = O(n)
// Space complexity: O(n) = O(1)
