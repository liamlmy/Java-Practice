// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

public class Solution {
  public TreeNode Convert(TreeNode root) {
    // Base case
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      return root;
    }
    // Recursion rule
    // Process left/before part
    TreeNode left = Convert(root.left);
    TreeNode cur = left;
    while (cur != null && cur.right != null) {
      cur = cur.right;
    }
    if (left != null) {
      cur.right = root;
      root.left = cur;
    }
    // Process right/after part
    TreeNode right = Convert(root.right);
    if (right != null) {
      right.left = root;
      root.right = right;
    }
    
    return left == null ? root : left;
  }
}
