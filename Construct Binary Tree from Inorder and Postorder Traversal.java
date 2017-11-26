// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        int[] inIndex = new int[]{inorder.length - 1};
        int[] postIndex = new int[]{postorder.length - 1};
        return buildTree(inorder, postorder, inIndex, postIndex, Integer.MAX_VALUE);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int[] inIndex, int[] postIndex, int target) {
        // Base case
        if (inIndex[0] < 0 || inorder[inIndex[0]] == target) {
            return null;
        }
        
        // Recursion rule
        TreeNode node = new TreeNode(postorder[postIndex[0]]);
        postIndex[0]--;
        node.right = buildTree(inorder, postorder, inIndex, postIndex, node.val);
        inIndex[0]--;
        node.left = buildTree(inorder, postorder, inIndex, postIndex, target);
        return node;
    }
}
