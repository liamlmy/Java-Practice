// Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
//
// Example:
// Input:
//    1
//     \
//      3
//     /
//    2
// Output:
// 1
// Explanation:
// The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
// 
// Note: There are at least two nodes in this BST.

class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;
        inOrder(root.right);
    }
}
