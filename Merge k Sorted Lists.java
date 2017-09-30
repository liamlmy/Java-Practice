// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

/*
 * Method 1: BFS2
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    // Base case
    if (lists == null || lists.length == 0) {
      return null;
    }
    // BFS2
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode a, ListNode b) {
        if (a.val == b.val) {
          return 0;
        }
        return a.val < b.val ? -1 : 1;
      }
    });
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        minHeap.add(lists[i]);
      }
    }
    while (!minHeap.isEmpty()) {
      cur.next = minHeap.poll();
      cur = cur.next;
      if (cur.next != null) {
        minHeap.add(cur.next);
      }
    }
    return dummyHead.next;
  }
}

/*
 * Method 2: Recursion
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    return partition(lists, 0, lists.length - 1);
  }
  
  private ListNode partition(ListNode[] lists, int i, int j) {
    // Base case
    if (i == j) {
      return lists[i];
    }
    // Recursion rule
    if (i < j) {
      int mid = (i + j) / 2;
      ListNode l1 = partition(lists, i, mid);
      ListNOde l2 = partition(lists, mid + 1, j);
      return merge(l1, l2);
    } else {
      return null;
    }
  }
  
  private ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = merge(l1.next, l2);
      return l1;
    } else {
      l2.next = merge(l1, l2.next);
      return l2;
    }
  }
}
