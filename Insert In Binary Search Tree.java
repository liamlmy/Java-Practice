// Insert a key in a binary search tree if the binary search tree does not already contain the key.
// Return the root of the binary search tree.
//
// Assumptions
// There are no duplicate keys in the binary search tree
// If the key is already existed in the binary search tree, you do not need to do anything
//
// Examples
//         5
//
//       /    \
//
//     3        8
//
//   /   \
//
//  1     4
// insert 11, the tree becomes
//         5
//
//       /    \
//
//     3        8
//
//   /   \        \
//
//  1     4       11
// insert 6, the tree becomes
//         5
//
//       /    \
//
//     3        8
//
//   /   \     /  \
//
//  1     4   6    11

/*
 * Method 1: Iteration way
 */
public class Solution {
  public TreeNode insert(TreeNode root, int key) {
    TreeNode target = new TreeNode(key);
    // Corner check
    if (root == null) {
      root = target;
      return root;
    }
    // Insert the key node
    TreeNode current = root;
    TreeNode parent = null;
    while (current != null) {
      if (current.key > key) {
        parent = current;
        current = current.left;
      } else if (current.key < key) {
        parent = current;
        current = current.right;
      } else {
        return root;
      }
    }
    if (parent.key > key) {
      parent.left = target;
    } else {
      parent.right = target;
    }
    return root;
  }
}

/*
 * Method 2: Recursion way
 */
public class Solution {
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }
    
    if (root.key > key) {
      root.left = insert(root.left, key);
    }
    if (root.key < key) {
      root.right = insert(root.right, key);
    }
    if (root.key == key) {
      return root;
    }
    return root;
  }
}
