// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    return buildBST(nums, 0, nums.length - 1);
  }
  
  private TreeNode buildBST(int[] nums, int left, int right) {
    // Base case
    if (left > right) {
      return null;
    }
    // Recursion rule
    int mid = left + (right - left) / 2;
    TreeNode cur = new TreeNode(nums[mid]);
    cur.left = buildBST(nums, left, mid - 1);
    cur.right = buildBST(nums, mid + 1, right);
    return cur;
  }
}
