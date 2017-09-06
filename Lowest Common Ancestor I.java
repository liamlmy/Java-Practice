// Given two nodes in a binary tree, find their lowest common ancestor.
//
// Assumptions
// There is no parent pointer for the nodes in the binary tree
// The given two nodes are guaranteed to be in the binary tree
//
// Examples
//         5
//
//       /   \
//
//      9     12
//
//    /  \      \
//
//   2    3      14
// The lowest common ancestor of 2 and 14 is 5
// The lowest common ancestor of 2 and 9 is 9

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // Return:
    // null - there is no one or two in the subtree.
    // non-null:
    // 1. if there is only one node in subtree, return the one / two node itself.
    // 2. if there are both one and two nodes in subtree, return the LCA.
    //    a. one is two's descendant, return one.
    //    b. two is one's descendant, return two.
    //    c. otherwise, return the lowest node with one and two in the two different subtrees.
    // Base case
    if (root == null) {
      return null;
    }
    if (root == one || root == two) {
      return root;
    }
    // Recursion rule
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n)
