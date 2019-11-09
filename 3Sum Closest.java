// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
// Return the sum of the three integers. You may assume that each input would have exactly one solution.
// For example, given array S = {-1 2 1 -4}, and target = 1.
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 99999999;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                result = Math.abs(target - sum) < Math.abs(target - result) ? sum : result;
                if (sum == target) {
                	return result;
                } else if (sum > target) {
                	right--;
                } else {
                	left++;
                }
            }
        }
        return result;
    }
}
