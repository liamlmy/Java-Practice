// Implement an iterative, post-order traversal of a given binary tree,
// return the list of keys of each node in the tree as it is post-order traversed.
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
// Post-order traversal is [1, 4, 3, 11, 8, 5]
//
// Corner Cases
// What if the given binary tree is null? Return an empty list in this case.
// How is the binary tree represented?
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
  public List<Integer> postOrder(TreeNode root) {
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
    traverse(root.right, result);
    result.add(root.key);
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n) ???
*/

/*
 * Method 2: Iteration way with reverse pre-order.
 */
/*
public class Solution {
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    // Corner check
    if (root == null) {
      return result;
    }
    // Traverse the tree
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    // Post-order is the reverse order of pre-oreder with traversing right subtree before left subtree.
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      // Conduct the result for the special pre-order traversal.
      if (cur.left != null) {
        stack.offerFirst(cur.left);
      }
      if (cur.right != null) {
        stack.offerFirst(cur.right);
      }
      result.add(cur.key);
    }
    // Reverse the pre-order traversal sequence to get the post-order traversal sequence.
    Collections.reverse(result);
    return result;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n) ???
*/

/*
 * Method 3: Iteration way
 */
public class Solution {
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    // Corner check
    if (root == null) {
      return result;
    }
    // Traverse the tree
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    // Check the relation of current node and previous node to determine which direction should go next.
    TreeNode prev = null;
    // To record the previous node on the way of DFS so that we can determine the direction.
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.peekFirst();
      // If we are going down, either left or right direction.
      if (prev == null || cur == prev.left || cur == prev.right) {
        // If we can still go down, try go left first.
        if (cur.left != null) {
          stack.offerFirst(cur.left);
        } else if (cur.right != null) {
          stack.offerFirst(cur.right);
        } else {
          // If we cannot go either way, meaning cur is a leaf.
          result.add(cur.key);
          stack.pollFirst();
        }
      } else if (prev == cur.right || prev == cur.left && cur.right == null) {
        // If we are going up from the right side or going up from the left side but we cannot go right afterwards.
        result.add(cur.key);
        stack.pollFirst();
      } else {
        // Otherwise, we are going up from the left side and we can go down right side.
        stack.offerFirst(cur.right);
      }
      prev = cur;
    }
    return result;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n) ???
