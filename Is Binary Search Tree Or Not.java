// Determine if a given binary tree is binary search tree.
//
// Assumptions
// There are no duplicate keys in binary search tree.
// You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
//
// Corner Cases
// What if the binary tree is null? Return true in this case.

public class Solution {
  public boolean isBST(TreeNode root) {
    // Corner check
    if (root == null) {
      return true;
    }
    // Check whether it is a BST
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    return check(root, min, max);
  }
  
  private boolean check(TreeNode root, int min, int max) {
    // Base case
    if (root == null) {
      return true;
    } else if (root.key > max || root.key < min) {
      return false;
    }
    // Recursion rule
    // For left node, max is changed to root.key - 1, and for right node, min is changed to root.key + 1.
    return check(root.left, min, root.key - 1) && check(root.right, root.key + 1, max);
  }
}
