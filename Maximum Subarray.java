// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.

public class Solution {
  public int maxSubArray(int[] nums) {
    // Corner check
    if (nums == null) {
      return Integer.MIN_VALUE;
    }
    // DP
    int[] M = new int[nums.length];
    M[0] = nums[0];
    int result = M[0];
    for (int i = 1; i < M.length; i++) {
      if (nums[i] + M[i - 1] < nums[i]) {
        M[i] = nums[i];
      } else {
        M[i] = nums[i] + M[i - 1];
      }
      result = Math.max(result, M[i]);
    }
    return result;
  }
}
