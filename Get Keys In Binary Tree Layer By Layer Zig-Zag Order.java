// Get the list of keys in a given binary tree layer by layer in zig-zag order.
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
//  1     4        11
// the result is [5, 3, 8, 11, 4, 1]
//
// Corner Cases
// What if the binary tree is null? Return an empty list in this case.
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
  public List<Integer> zigZag(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    // Corner check
    if (root == null) {
      return result;
    }
    // Breadth-first-searching
    Deque<TreeNode> deque = new LinkedList<TreeNode>();
    int layer = 0;
    deque.offerFirst(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        if (layer % 2 == 0) {
          TreeNode cur = deque.pollLast();
          result.add(cur.key);
          if (cur.right != null) {
            deque.offerFirst(cur.right);
          }
          if (cur.left != null) {
            deque.offerFirst(cur.left);
          }
        } else {
          TreeNode cur = deque.pollFirst();
          result.add(cur.key);
          if (cur.left != null) {
            deque.offerLast(cur.left);
          }
          if (cur.right != null) {
            deque.offerLast(cur.right);
          }
        }
      }
      layer++;
    }
    return result;
  }
}

// Time complexity: O(n)
// Space complexity: O(n)
