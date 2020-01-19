// Given a binary tree, find the leftmost value in the last row of the tree.
//
// Example 1:
// Input:
//     2
//    / \
//   1   3
// Output:
// 1
//
// Example 2:
// Input:
//         1
//        / \
//       2   3
//      /   / \
//     4   5   6
//        /
//       7
// Output:
// 7
//
// Note: You may assume the tree (i.e., the given root node) is not NULL.

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    result = cur.val;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                    continue;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    continue;
                }
            }
        }
        return result;
    }
}
