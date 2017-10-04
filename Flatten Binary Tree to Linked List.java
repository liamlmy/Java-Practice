// Given a binary tree, flatten it to a linked list in-place.
//
// For example,
// Given
//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6

/*
 * Method 1: Recursion way
 */
/*
public class Solution {
  TreeNode prev = null;
  
  public void flatten(TreeNode root) {
    // Base case
    if (root == null) {
      return;
    }
    // Recursion rule
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
  }
}
*/

/*
 * Method 2: Iteration way
 */
public class Solution {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      if (cur.right != null) {
        stack.offerFirst(cur.right);
      }
      if (cur.left != null) {
        stack.offerFirst(cur.left);
      }
      if (!stack.isEmpty()) {
        cur.right = stack.peekFirst();
      }
      cur.left = null;
    }
  }
}