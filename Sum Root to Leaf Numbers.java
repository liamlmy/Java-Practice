// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
// An example is the root-to-leaf path 1->2->3 which represents the number 123.
// Find the total sum of all root-to-leaf numbers.
// For example,
//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
// Return the sum = 12 + 13 = 25.

public class Solution {
  public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        DFS(root, result, sb);
        int sum = 0;
        for (String str : result) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }
    
    private void DFS(TreeNode root, List<String> result, StringBuilder sb) {
        // Base case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            result.add(new String(sb));
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        // Recursion rule
        sb.append(root.val);
        DFS(root.left, result, sb);
        
        //sb.deleteCharAt(sb.length() - 1);
        DFS(root.right, result, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
