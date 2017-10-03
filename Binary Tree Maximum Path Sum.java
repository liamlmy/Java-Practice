// Given a binary tree, find the maximum path sum.
// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the
// parent-child connections. The path must contain at least one node and does not need to go through the root.
//
// For example:
// Given the below binary tree,
//        1
//       / \
//      2   3
// Return 6.

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        DFS(root, max);
        return max[0];
    }
    
    private int DFS(TreeNode root, int[] max) {
        // Base case
        if (root == null) {
            return 0;
        }
        // Recursion rule
        int left = Math.max(0, DFS(root.left, max));
        int right = Math.max(0, DFS(root.right, max));
        max[0] = Math.max(right + left + root.val, max[0]);
        return Math.max(left, right) + root.val;
    }
}
