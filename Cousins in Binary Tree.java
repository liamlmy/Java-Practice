// In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
// Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
// We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
// Return true if and only if the nodes corresponding to the values x and y are cousins.

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> depth = new HashMap<>();
        Map<Integer, TreeNode> parent = new HashMap<>();
        
        DFS(root, null, depth, parent);
        
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }
    
    private void DFS(TreeNode c, TreeNode p, Map<Integer, Integer> depth, Map<Integer, TreeNode> parent) {
        if (c != null) {
            depth.put(c.val, p == null ? 0 : depth.get(p.val) + 1);
            parent.put(c.val, p);
            DFS(c.left, c, depth, parent);
            DFS(c.right, c, depth, parent);
        }
    }
}
