// Delete the target key K in the given binary search tree if the binary search tree contains K.
// Return the root of the binary search tree.
// Find your own way to delete the node from the binary search tree, after deletion the binary search tree's property
// should be maintained.
//
// Assumptions
// There are no duplicate keys in the binary search tree

public class Solution {
  public TreeNode delete(TreeNode root, int key) {
    // Corner check
    if (root == null) {
      return null;
    }
    // Delete the key node
    if (root.key == key) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else if (root.right.left == null) {
        root.right.left = root.left;
        return root.right;
      } else {
        TreeNode smallestNode = findSmallestNode(root.right);
        smallestNode.left = root.left;
        smallestNode.right = root.right;
        return smallestNode;
      }
    }
    if (root.key > key) {
      root.left = delete(root.left, key);
    } else if (root.key < key) {
      root.right = delete(root.right, key);
    }
    return root;
  }
  
  private TreeNode findSmallestNode(TreeNode root) {
    while (root.left.left != null) {
      root = root.left;
    }
    TreeNode smallestNode = root.left;
    root.left = root.left.right;
    return smallestNode;
  }
}
