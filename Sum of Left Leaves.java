// Find the sum of all left leaves in a given binary tree.
//
// Example:
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }
    
    private int sumOfLeftLeaves(TreeNode root, Boolean isLeft) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        if (root.left != null || root.right != null) {
            sum += sumOfLeftLeaves(root.left, true);
            sum += sumOfLeftLeaves(root.right, false);
        } else if (isLeft) {
            sum += root.val;
        }
        
        return sum;
    }
}
