// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

public class Solution {
  public int maxProduct(int[] nums) {
    int result = nums[0];
    int maxPre = nums[0];
    int minPre = nums[0];
    int max = 0;
    int min = 0;
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(nums[i], Math.max(nums[i] * maxPre, nums[i] * minPre));
      min = Math.min(nums[i], Math.min(nums[i] * maxPre, nums[i] * minPre));
      result = Math.max(result, max);
      maxPre = max;
      minPre = min;
    }
    return result;
  }
}
