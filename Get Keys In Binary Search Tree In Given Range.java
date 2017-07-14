// Get the list of keys in a given binary search tree in a given range[min, max] in ascending order,
// both min and max are inclusive.
//
// Examples
//         5
//
//       /    \
//
//     3        8
//
//   /   \        \
//
//  1     4        11
// get the keys in [2, 5] in ascending order, result is  [3, 4, 5]
//
// Corner Cases
// What if there are no keys in the given range? Return an empty list in this case.
// How is the binary tree represented?
// We use the level order traversal sequence with a special symbol "#" denoting the null node.
//
// For Example:
// The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> result = new ArrayList<Integer>();
    findResult(root, min, max, result);
    return result;
  }
  
  private void findResult(TreeNode root, int min, int max, List<Integer> result) {
    // Base case
    if (root == null) {
      return;
    }
    // Recursion rule
    if (root.key > min) {
      findResult(root.left, min, max);
    }
    if (root.key >= min && root.key <= max) {
      result.add(root.key);
    }
    if (root.key < max) {
      findResult(root.right, min, max);
    }
  }
}
