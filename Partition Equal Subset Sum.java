// Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
// Note:
// Each of the array element will not exceed 100.
// The array size will not exceed 200.
//
// Example 1:
// Input: [1, 5, 11, 5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
//
// Example 2:
// Input: [1, 2, 3, 5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
        	return false;
        }
        if (nums.length == 2) {
        	return nums[0] == nums[1];
        }

        int sum = 0;
        for (int num : nums) {
        	sum += num;
        }

        if (sum % 2 != 0) {
        	return false;
        }

        return helper(nums, sum / 2, sum / 2, nums.length - 1);
    }

    private boolean helper(int[] nums, int t1, int t2, int idx) {
    	// base case
    	if (idx < 0) {
    		return t1 == 0 && t2 == 0;
    	}
    	if (t1 < 0 || t2 < 0) {
    		return false;
    	}

    	// recursion rule
    	return helper(nums, t1 - nums[idx], t2, idx - 1) || helper(nums, t1, t2 - nums[idx], idx - 1);
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = computeArraySum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int num : nums) {                 // 0-1 背包一个物品只能用一次
            for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
