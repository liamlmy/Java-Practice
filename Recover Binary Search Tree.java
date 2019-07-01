// Two elements of a binary search tree (BST) are swapped by mistake.
// Recover the tree without changing its structure.
// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

public class Solution {
  TreeNode first;
  TreeNode second;
  TreeNode prev;
  
  public void recoverTree(TreeNode root) {
    inOrderTraverse(root);
    swap(first, second);
  }
  
  private void inOrderTraverse(TreeNode root) {
    // Base case
    if (root == null) {
      return;
    }
    // Recursion rule
    inOrderTraverse(root.left);
    if (prev != null && root.val < prev.val) {
      second = root;
      if (first == null) {
        first = prev;
      } else {
        return;
      }
    }
    prev = root;
    inOrderTraverse(root.right);
  }
  
  private void swap(TreeNode node1, TreeNode node2) {
    int temp = node1.val;
    node1.val = node2.val;
    node2.val = temp;
  }
}
