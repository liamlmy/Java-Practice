// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
// the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
// it will automatically contact the police if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
// money you can rob tonight without alerting the police.

/*
 * Method 1: DP
 */
/*
public class Solution {
  public int rob(int[] nums) {
    int[][] M = new int[nums.length + 1][2];
    for (int i = 1; i <= nums.length; i++) {
      M[i][0] = Math.max(M[i - 1][0], M[i - 1][1]);
      M[i][1] = M[i - 1][0] + nums[i - 1];
    }
    return Math.max(M[nums.length][0], M[nums.length][1]);
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n)
*/

/*
 * Method 2: DP
 */
public class Solution {
  public int rob(int[] nums) {
    int prevNo = 0;
    int prevYes = 0;
    for (int i = 0; i < nums.length; i++) {
      int temp = prevNo;
      prevNo = Math.max(prevNo, prevYes);
      prevYes = temp + nums[i];
    }
    return Math.max(prevNo, prevYes);
  }
}

// Time complexity: O(n)
// Space complexity: O(1)
