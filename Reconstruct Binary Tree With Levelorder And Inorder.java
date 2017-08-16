// Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
//
// Assumptions
// The given sequences are not null and they have the same length
// There are no duplicate keys in the binary tree
//
// Examples
// levelorder traversal = {5, 3, 8, 1, 4, 11}
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

public class Solution {
  public TreeNode reconstruct(int[] in, int[] level) {
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      inMap.put(in[i], i);
    }
    List<Integer> levelList = new ArrayList<Integer>();
    for (int num : level) {
      levelList.add(num);
    }
    return reconstruct(inMap, levelList);
  }
  
  private TreeNode reconstruct(Map<Integer, Integer> inMap, List<Integer> levelList) {
    // Base case
    if (levelList.isEmpty()) {
      return null;
    }
    // Recursion rule
    TreeNode root = new TreeNode(levelList.remove(0));
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();
    for (int num : levelList) {
      if (inMap.get(num) < inMap.get(root.key)) {
        left.add(num);
      } else {
        right.add(num);
      }
    }
    root.left = reconstruct(inMap, left);
    root.right = reconstruct(inMap, right);
    return root;
  }
}
