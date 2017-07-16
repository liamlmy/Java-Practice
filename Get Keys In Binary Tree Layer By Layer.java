// Get the list of list of keys in a given binary tree layer by layer.
// Each layer is represented by a list of keys and the keys are traversed from left to right.
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
// the result is [ [5], [3, 8], [1, 4, 11] ]
//
// Corner Cases
// What if the binary tree is null? Return an empty list of list in this case.
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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    // Corner check
    if (root == null) {
      return result;
    }
    // BFS
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      // The size of current level.
      int layerSize = queue.size();
      // The layer storing all the nodes in the current level.
      List<Integer> layer = new ArrayList<Integer>();
      // Traverse all the nodes on current level, and prepare for the next level.
      for (int i = 0; i < layerSize; i++) {
        TreeNode cur = queue.poll();
        layer.add(cur.key);
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      result.add(layer);
    }
    return result;
  }
}
