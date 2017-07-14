// Check if a given binary tree is balanced.
// A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.
//
// Examples
//         5
//
//       /    \
//
//     3        8
//
//   /   \        \
//
// 1      4        11
// is balanced binary tree,
//         5
//
//       /
//
//     3
//
//   /   \
//
// 1      4
// is not balanced binary tree.
//
// Corner Cases
// What if the binary tree is null? Return true in this case.
// How is the binary tree represented?
// We use the level order traversal sequence with a special symbol "#" denoting the null node.
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
  public boolean isBalanced(TreeNode root) {
    // Corner check
    if (root == null) {
      return true;
    }
    // Check whether it is balaned
    // Use -1 to denote the tree is not balanced.
    // >= 0 means that the tree is balanced and it is the height of the tree.
    return height(root) != -1;
  }
  
  private int height(TreeNode root) {
    // Base case
    if (root == null) {
      return 0;
    }
    // Recursion rule
    int left = height(root.left);
    // If the left subtree is not balanced, we do not need to continue and just return -1.
    if (left == -1) {
      return -1;
    }
    // If the right subtree is not balanced, we do not need to continue and just return -1.
    int right = height(root.right);
    if (right == -1) {
      return -1;
    }
    // If the tree is not balanced, return -1.
    if (Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }
}
