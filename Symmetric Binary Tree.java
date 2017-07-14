// Check if a given binary tree is symmetric.
//
// Examples
//         5
//
//       /    \
//
//     3        3
//
//   /   \    /   \
//
// 1      4  4      1
// is symmetric.
//         5
//
//       /    \
//
//     3        3
//
//   /   \    /   \
//
// 1      4  1      4
// is not symmetric.
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
  public boolean isSymmetric(TreeNode root) {
    // Corner check
    if (root == null) {
      return true;
    }
    // Check whether it is symmetric
    return check(root.left, root.right);
  }
  
  private boolean check(TreeNode left, TreeNode right) {
    // Base case
    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    } else if (left.key != right.key) {
      return false;
    }
    // Recursion rule'
    return check(left.left, right.right) && check(left.right, right.left);
  }
}
