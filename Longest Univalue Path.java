// Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
// The length of path between two nodes is represented by the number of edges between them. 
//
// Example 1:
// Input:
//               5
//              / \
//             4   5
//            / \   \
//           1   1   5
// Output: 2 
// 
// Example 2:
// Input:
//               1
//              / \
//             4   5
//            / \   \
//           4   4   5
// Output: 2 
//
// Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

class Solution {
    int result;

    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        DFS(root);
        return result;
    }

    private int DFS(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = DFS(node.left);
        int right = DFS(node.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        result = Math.max(result, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
