// Check if a given binary tree is completed. A complete binary tree is one in which every level of
// the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.
//
// Examples
//         5
//
//       /    \
//
//     3        8
//
//   /   \
//
// 1      4
// is completed.
//         5
//
//       /    \
//
//     3        8
//
//   /   \        \
//
// 1      4        11
// is not completed.
//
// Corner Cases
// What if the binary tree is null? Return true in this case.
// How is the binary tree represented?
// We use the level order traversal sequence with a special symbol "#" denoting the null node.
//
// For Example:
// The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
//     1
//
//   /   \
//
//  2     3
//
//       /
//
//     4

public class Solution {
  public boolean isCompleted(TreeNode root) {
    // Corner check
    if (root == null) {
      return true;
    }
    // Check whether the tree is completed
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    // If the notCompleted is set to true, there should not be any child nodes afterwards.
    boolean notCompleted = false;
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      // If any of the child is not presented, set the notCompleted to true;
      if (cur.left == null) {
        notCompleted = true;
      } else if (notCompleted) {
        // If the notCompleted is set to true but we still see cur has a left child,
        // the binary tree is not a completed tree.
        return false;
      } else {
        // If the notCompleted is not set to true but we see cur has a left child,
        // offer it to the queue.
        queue.offer(cur.left);
      }
      // Same logic as left subtree.
      if (cur.right == null) {
        notCompleted = true;
      } else if (notCompleted) {
        return false;
      } else {
        queue.offer(cur.right);
      }
    }
    return true;
  }
}
