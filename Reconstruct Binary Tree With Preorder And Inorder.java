// Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
//
// Assumptions
// The given sequences are not null and they have the same length
// There are no duplicate keys in the binary tree
//
// Examples
// preorder traversal = {5, 3, 1, 4, 8, 11}
// inorder traversal = {1, 3, 4, 5, 8, 11}
// the corresponding binary tree is
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
// The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
//     1
//
//   /   \
//
//  2     3
//
//       /
//
//     4

/*
 * Method 1: Utilizing the inOrder sequence to determine the size of left/right subtrees.
 */
/*
public class Solution {
  public TreeNode reconstruct(int[] in, int[] pre) {
    Map<Integer, Integer> inOrderMap = indexMap(in);
    return reconstruct(in, pre, inOrderMap, 0, in.length - 1, 0, pre.length - 1);
  }
  
  private Map<Integer, Integer> indexMap(int[] array) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      map.put(array[i], i);
    }
    return map;
  }
  
  private TreeNode reconstruct(int[] in, int[] pre, Map<Integer, Integer> inOrderMap,
                               int inLeft, int inRight, int preLeft, int preRight) {
    // Base case
    if (inLeft > inRight) {
      return null;
    }
    // Recursion rule
    TreeNode root = new TreeNode(pre[preLeft]);
    // To determine the left bound and right bound in inOrder array and preOrder array by using the traits of each array.
    int inMid = inOrderMap.get(root.key);
    root.left = reconstruct(in, pre, inOrderMap, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
    root.right = reconstruct(in, pre, inOrderMap, inMid + 1, inRight, preLeft + inMid - inLeft + 1, preRight);
    return root;
  }
}
*/

/*
 * Method 2: another linear solution with traversing and constructing the binary tree using preOrder and inOrder at the
 * same time
 */
public class Solution {
  public TreeNode reconstruct(int[] in, int[] pre) {
    int[] preIndex = new int[] {0};
    int[] inIndex = new int[] {0};
    return reconstruct(in, pre, inIndex, preIndex, Integer.MAX_VALUE);
  }
  
  private TreeNode reconstruct(int[] in, int[] pre, int[] inIndex, int[] preIndex, int target) {
    // Base case
    if (inIndex[0] >= in.length || in[inIndex[0]] == target) {
      return null;
    }
    // Recursion rule
    TreeNode root = new TreeNode(pre[preIndex[0]]);
    // preIndex, advance the index by 1 since we already finish the root.
    preIndex[0]++;
    root.left = reconstruct(in, pre, inIndex, preIndex, root.key);
    // InIndex, after finish the left subtree, we can advance the index by 1.
    inIndex[0]++;
    root.right = reconstruct(in, pre, inIndex, preIndex, target);
    return root;
  }
}
