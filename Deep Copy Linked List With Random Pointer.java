Each of the nodes in the linked list has another pointer pointing to a random node in the list or null.
Make a deep copy of the original list.

/*
 * Method 1: Use HashMap
 */
/*
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // Corner check
    if (head == null) {
      return null;
    }
    // Deep copy the random linkedlist
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode cur = dummy;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    while (head != null) {
      if (!map.containsKey(head)) {
        map.put(head, new RandomListNode(head.value));
      }
      cur.next = map.get(head);
      if (head.random != null) {
        if (!map.containsKey(head.random)) {
          map.put(head.random, new RandomListNode(head.random.value));
        }
        cur.next.random = map.get(head.random);
      }
      head = head.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
*/

/*
 * Method 2: Do not use HashMap
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // Corner check
    if (head == null) {
      return null;
    }
    // Deep copy the random linkedlist
    RandomListNode cur = head;
    // First trace
    while (cur != null) {
      RandomListNode copy = new RandomListNode(cur.value);
      copy.next = cur.next;
      cur.next = copy;
      cur = cur.next.next;
    }
    // Second trace
    cur = head;
    while (cur != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }
    // Third trace
    cur = head;
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode prev = dummy;
    while (cur != null) {
      prev.next = cur.next;
      cur.next = cur.next.next;
      prev = prev.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
