// Given a Binary Search Tree and a target number,
// return true if there exist two elements in the BST such that their sum is equal to the given target.

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(root, set, k);
    }
    
    private boolean findTarget(TreeNode root, Set<Integer> set, int target) {
        // Base case
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        // Recursion rule
        return findTarget(root.left, set, target) || findTarget(root.right, set, target);
    }
}
