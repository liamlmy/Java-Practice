// Given a binary tree
//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node.
// If there is no next right node, the next pointer should be set to NULL.
// Initially, all next pointers are set to NULL.
//
// Note:
// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

/*
 * Method 1: BFS1 method
 */
/*
public class Solution {
  public void connect(TreeNode root) {
    // Corner check
    if (root == null) {
      return;
    }
    // BFS1
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if (i == size - 1) {
          cur.next = null;
        } else {
          cur.next = queue.peek();
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }
  }
}

// Time complexity: O(n)
// Space complexity: O(n)
*/

/*
 * Method 2
 */
public class Solution {
  public void connect(TreeNode root) {
    TreeNode levelStart = root;
    while (levelStart != null) {
      TreeNode cur = levelStart;
      while (cur != null) {
        if (cur.left != null) {
          cur.left.next = cur.right;
        }
        if (cur.right != null && cur.next != null) {
          cur.right.next = cur.next.left;
        }
        cur = cur.next;
      }
      levelStart = levelStart.left;
    }
  }
}

// Time complexity: O(n)
// Space complexity: O(1)
