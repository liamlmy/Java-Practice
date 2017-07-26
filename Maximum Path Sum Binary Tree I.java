// Given a binary tree in which each node contains an integer number.
// Find the maximum possible sum from one leaf node to another leaf node.
// If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
//
// Examples
//    -15
//
//   /    \
//
// 2      11
//
//      /    \
//
//     6     14
// The maximum path sum is 6 + 11 + 14 = 31.
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
  public int maxPathSum(TreeNode root) {
    // Pass by value.
    int[] result = new int[] {Integer.MIN_VALUE};
    DFS(root, result);
    return result[0];
  }
  
  private int DFS(TreeNode root, int[] result) {
    // Base case
    if (root == null) {
      return 0;
    }
    // Recursion rule
    int left = DFS(root.left, result);
    int right = DFS(root.right, result);
    if (root.left != null && root.right != null) {
      result[0] = Math.max(result[0], right + left + root.key);
      return Math.max(left, right) + root.key;
    }
    return root.left == null ? root.key + right : root.key + left;
  }
}
