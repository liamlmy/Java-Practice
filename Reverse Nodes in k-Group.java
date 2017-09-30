// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
// k is a positive integer and is less than or equal to the length of the linked list.
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
// You may not alter the values in the nodes, only nodes itself may be changed.
// Only constant memory is allowed.
//
// For example,
// Given this linked list: 1->2->3->4->5
// For k = 2, you should return: 2->1->4->3->5
// For k = 3, you should return: 3->2->1->4->5

/*
 * Method 1: Recursion way
 */
/*
public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode cur = head;
    int count = 0;
    while (cur != null && count != k) {
      cur = cur.next;
      count++;
    }
    if (count == k) {
      cur = reverseKGroup(cur, k);
      while (count > 0) {
        ListNode temp = head.next;
        head.next = cur;
        cur = head;
        head = temp;
        count--;
      }
      head = cur;
    }
    return head;
  }
}
*/

/*
 * Method 2: Iteration way
 */
public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || k == 1) {
      return head;
    }
 
    ListNode fake = new ListNode(0);
    fake.next = head;
    ListNode pre = fake;
    int i=0;
 
    ListNode p = head;
    while(p != null) {
      i++;
      if (i % k == 0) {
        pre = reverse(pre, p.next);
        p = pre.next;
      } else {
        p = p.next; 
      }
    }
    return fake.next; 
  }
 
/*
 * 0->1->2->3->4->5->6
 * |           |   
 * pre        next
 *
 * after calling pre = reverse(pre, next)
 * 
 * 0->3->2->1->4->5->6
 *          |  |
 *          pre next 
 */
  public ListNode reverse(ListNode pre, ListNode next){
    ListNode last = pre.next;
    ListNode curr = last.next;
 
    while (curr != next) {
      last.next = curr.next;
      curr.next = pre.next;
      pre.next = curr;
      curr = last.next;
    }
    return last; 
  }
}
