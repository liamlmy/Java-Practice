// Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
//
// Example:
// Input: The root of a Binary Search Tree like this:
//               5
//             /   \
//            2     13
//
// Output: The root of a Greater Tree like this:
//              18
//             /   \
//           20     13

class Solution {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            root.right = convertBST(root.right);
            sum += root.val;
            root.val = sum;
            root.left = convertBST(root.left);
        }
        return root;
    }
}

class Solution {
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.right;
            }
            cur = stack.pollFirst();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode smallestLarger = getSmallestLarger(node);
                if (smallestLarger.left == null) {
                    smallestLarger.left = node;
                    node = node.right;
                } else {
                    smallestLarger.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    private TreeNode getSmallestLarger(TreeNode node) {
        TreeNode smallestLarger = node.right;
        while (smallestLarger.left != null && smallestLarger.left != node) {
            smallestLarger = smallestLarger.left;
        }
        return smallestLarger;
    }
}
