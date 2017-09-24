// Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.
//
// Assumptions
// The given array is not null and has length of at least 1.
//
// Examples
// {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
// {-2, -1, -3}, the largest subarray sum is -1

public class Solution {
  public int largestSum(int[] array) {
    int cur = array[0];
    int result = array[0];
    // dp[i] (actually do not need to declare on the memory) means the largest sum of subarray ending at index i
    // dp[i] = array[i], if dp[i - 1] <= 0
    // dp[i] = array[i] + dp[i - 1], if dep[i - 1] > 0
    // So that we can reduce the space consumption by recording the latest largest sum
    for (int i = 1; i < array.length; i++) {      // In this case, if the length of array is 1, it also works
      cur = Math.max(array[i] + cur, array[i]);
      result = Math.max(result, cur);
    }
    return result;
  }
}

// Time complexity: O(n)
// Space complexity: O(1)
