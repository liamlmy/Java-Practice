// Given K nodes in a binary tree, find their lowest common ancestor.
//
// Assumptions
// K >= 2
// There is no parent pointer for the nodes in the binary tree
// The given K nodes are guaranteed to be in the binary tree
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
// The lowest common ancestor of 2, 3, 14 is 5
// The lowest common ancestor of 2, 3, 9 is 9

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    Set<TreeNode> set = getSet(nodes);
    int size = nodes.size();
    return helper(root, set);
  }
  
  private TreeNode helper(TreeNode root, Set<TreeNode> set) {
    // Base case
    if (root == null) {
      return root;
    }
    if (set.contains(root)) {
      return root;
    }
    // Recursion rule
    TreeNode left = helper(root.left, set);
    TreeNode right = helper(root.right, set);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }
  
  private Set<TreeNode> getSet(List<TreeNode> nodes) {
    Set<TreeNode> set = new HashSet<TreeNode>();
    for (TreeNode node : nodes) {
      set.add(node);
    }
    return set;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n)
