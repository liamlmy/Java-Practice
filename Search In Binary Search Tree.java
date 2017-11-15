// Find the target key K in the given binary search tree, return the node that contains the key if K is found,
// otherwise return null.
//
// Assumptions
// There are no duplicate keys in the binary search tree

public class Solution {
  public TreeNode search(TreeNode root, int key) {
    // Corner check
    if (root == null) {
      return null;
    }
    // Find the key node
    TreeNode current = root;
    while (current != null) {
      if (current.key > key) {
        current = current.left;
      } else if (current.key < key) {
        current = current.right;
      } else {
        return current;
      }
    }
    return null;
  }
}

// Time complexity: O(height)
// Space complexity: O(1)
