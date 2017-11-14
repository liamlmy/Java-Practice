// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        List<Integer> cur = new ArrayList<>();
        DFS(root, sum, result, cur);
        return result;
    }
    
    private void DFS(TreeNode root, int sum, List<List<Integer>> result, List<Integer> cur) {
        // Basic case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            cur.add(root.val);
            if (sum == root.val) {
                result.add(new ArrayList(cur));
            }
            cur.remove(cur.size() - 1);
            return;
        }
        // Recursion rule
        cur.add(root.val);
        DFS(root.left, sum - root.val, result, cur);
        DFS(root.right, sum - root.val, result, cur);
        cur.remove(cur.size() - 1);
    }
}
