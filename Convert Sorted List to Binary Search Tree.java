// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }
    
    private TreeNode toBST(ListNode head, ListNode tail) {
        // Base case
        if (head == tail) {
            return null;
        }
        // Recursion rule
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head, slow);
        node.right = toBST(slow.next, tail);
        return node;
    }
}


class Solution {
    private ListNode cur;

  private int findSize(ListNode head) {
    ListNode ptr = head;
    int c = 0;
    while (ptr != null) {
      ptr = ptr.next;  
      c += 1;
    }
    return c;
  }

  private TreeNode convertListToBST(int l, int r) {
    // Invalid case
    if (l > r) {
      return null;
    }

    int mid = l + (r - l) / 2;

    // First step of simulated inorder traversal. Recursively form
    // the left half
    TreeNode left = convertListToBST(l, mid - 1);

    // Once left half is traversed, process the current node
    TreeNode node = new TreeNode(cur.val);
    node.left = left;

    // Maintain the invariance mentioned in the algorithm
    cur = cur.next;

    // Recurse on the right hand side and form BST out of them
    node.right = convertListToBST(mid + 1, r);
    return node;
  }

  public TreeNode sortedListToBST(ListNode head) {
    // Get the size of the linked list first
    int size = findSize(head);

    cur = head;

    // Form the BST now that we know the size
    return convertListToBST(0, size - 1);
  }
}
