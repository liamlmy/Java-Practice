// Given a binary tree where all the right nodes are leaf nodes,
// flip it upside down and turn it into a tree with left leaf nodes as the root.
//
// Examples
//         1
//
//       /    \
//
//     2        5
//
//   /   \
//
// 3      4
// is reversed to
//         3
//
//       /    \
//
//     2        4
//
//   /   \
//
// 1      5
// How is the binary tree represented?
// We use the pre order traversal sequence with a special symbol "#" denoting the null node.
// For Example:
// The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
//     1
//
//   /   \
//
//  2     3
//
//       /
//
//     4

/*
 * Method 1: recursion way
 */
/*
public class Solution {
  public TreeNode reverse(TreeNode root) {
    // Base case
    if (root == null || root.left == null) {
      return root;
    }
    // Recursion rule
    TreeNode newRoot = reverse(root.left);
    root.left.right = root.right;
    root.left.left = root;
    root.left = null;
    root.right = null;
    return newRoot;
  }
}
*/

/*
 * Method 2: iteration way
 */
public class Solution {
  public TreeNode reverse(TreeNode root) {
    TreeNode prev = null;
    TreeNode prevRight = null;
    while (root != null) {
      TreeNode next = root.left;
      TreeNode right = root.right;
      root.left = prev;
      root.right = prevRight;
      prevRight = right;
      prev = root;
      root = next;
    }
    return prev;
  }
}
