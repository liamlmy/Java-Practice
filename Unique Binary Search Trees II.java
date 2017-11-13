// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        if (n == 0) {
            return dp[0];
        }
        
        dp[0].add(null);
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode left : dp[j - 1]) {
                    for (TreeNode right : dp[i - j]) {
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = clone(right, j);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }
    
    private TreeNode clone(TreeNode root, int offset) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val + offset);
        node.left = clone(root.left, offset);
        node.right = clone(root.right, offset);
        return node;
    }
}
