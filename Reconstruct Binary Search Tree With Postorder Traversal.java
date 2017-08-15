// Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.
//
// Assumptions
// The given sequence is not null
// There are no duplicate keys in the binary search tree
//
// Examples
// postorder traversal = {1, 4, 3, 11, 8, 5}
// the corresponding binary search tree is
//         5
//
//       /    \
//
//     3        8
//
//   /   \        \
//
// 1      4        11
// How is the binary tree represented?
// We use the pre order traversal sequence with a special symbol "#" denoting the null node.
// For Example:
// The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:
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
  public TreeNode reconstruct(int[] post) {
    // We traverse and construct the binary search tree from the postOrder right to left
    int[] index = new int[] {post.length - 1};
    return reconstruct(post, index, Integer.MIN_VALUE);
  }
  
  private TreeNode reconstruct(int[] post, int[] index, int min) {
    // Since it is a binary search tree, the "min" is actually the root, and we are using the root value to
    // determine the boundary of left/right subtree.
    if (index[0] < 0 || post[index[0]] <= min) {
      return null;
    }
    TreeNode root = new TreeNode(post[index[0]--]);
    root.right = reconstruct(post, index, root.key);
    root.left = reconstruct(post, index, min);
    return root;
  }
}
