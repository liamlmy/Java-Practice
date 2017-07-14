// Implement an iterative, in-order traversal of a given binary tree,
// return the list of keys of each node in the tree as it is in-order traversed.
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
// 1      4        11
// In-order traversal is [1, 3, 4, 5, 8, 11]
//
// Corner Cases
// What if the given binary tree is null? Return an empty list in this case.
// How is the binary tree represented?
//
// We use the level order traversal sequence with a special symbol "#" denoting the null node.
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

/*
 * Method 1: Recursion way
 */
/*
public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    // Corner check
    if (root == null) {
      return result;
    }
    // Traverse the tree
    traverse(root, result);
    return result;
  }
  
  private void traverse(TreeNode root, List<Integer> result) {
    // Base case
    if (root == null) {
      return;
    }
    // Recursion rule
    traverse(root.left, result);
    result.add(root.key);
    traverse(root.right, result);
  }
}
*/

public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      // Always try to go left side to see if there is any node should be traversed before the current node,
      // current node is stored on stack since it has not been traversed yet.
      if (cur != null) {
        stack.offerFirst(cur);
        cur = cur.left;
      } else {
        // If cannot go left meaning that all the nodes on the left side of the top node on stack have been
        // traversed, the next traversing node should be the top node on the stack.
        cur = stack.pollFirst();
        result.add(cur.key);
        // The next subtree we want to traverse is current's right node.
        cur = cur.right;
      }
    }
    return result;
  }
}
