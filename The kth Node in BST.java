// 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。

public class Solution {
  int index = 0;
  
  public TreeNode KthNode(TreeNode root, int k) {
    // Base case
    if (root == null) {
      return null;
    }
    // Recursion rule
    TreeNode node = KthNode(root.left, k);
    if (node != null) {
      return node;
    }
    index++;
    if (index == k) {
      return root;
    }
    node = KthNode(root.right, k);
    if (node != null) {
      return node;
    }
    return null;
  }
}
