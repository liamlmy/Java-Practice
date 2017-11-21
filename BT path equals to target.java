// 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> cur = new ArrayList<>();
        DFS(root, result, cur, target);
        return result;
    }
    
    private void DFS(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cur, int target) {
        // Base case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            cur.add(root.val);
            if (valid(cur, target)) {
                result.add(new ArrayList(cur));
            }
            cur.remove(cur.size() - 1);
            return;
        }
        // Recursion rule
        cur.add(root.val);
        DFS(root.left, result, cur, target);
        DFS(root.right, result, cur, target);
        cur.remove(cur.size() - 1);
    }
    
    private boolean valid(ArrayList<Integer> cur, int target) {
        if (cur.size() == 0) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < cur.size(); i++) {
            result += cur.get(i);
        }
        if (result == target) {
            return true;
        } else {
            return false;
        }
    }
}
