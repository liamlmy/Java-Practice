// Given a binary tree, return all root-to-leaf paths.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Input:
//    1
//  /   \
// 2     3
//  \
//   5
//
// Output: ["1->2->5", "1->3"]
//
// Explanation: All root-to-leaf paths are: 1->2->5, 1->3

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if(root != null){
            searchNode(root, "", ans);
        }
        return ans;
    }
    
    public void searchNode(TreeNode root, String path, List<String> ans){
        if(root.left == null && root.right == null){
            ans.add(path + root.val);
        }
        if(root.left != null){
            searchNode(root.left, path + root.val + "->", ans);
        }
        if(root.right != null){
            searchNode(root.right, path + root.val + "->", ans);
        }
    }
}
