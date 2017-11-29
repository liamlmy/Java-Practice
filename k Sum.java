// Given n distinct positive integers, integer k (k <= n) and a number target.
// Find k numbers where sum is target. Calculate how many solutions there are?
// Example
// Given [1,2,3,4], k = 2, target = 5.
// There are 2 solutions: [1,4] and [2,3].
// Return 2.

/*
 * Method 1: DP
 */
public class Solution {
  public int kSum(int[] A, int k, int target) {
    // Corner case
    if (A == null || A.length == 0) {
      return 0;
    }
    // DP
    // f[i][j][t] take j numbers from the first i numbers, how many combinations' sum is t
    int[][][] dp = new int[A.length + 1][k + 1][target + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i][0][0] = 1;
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j <= i && j <= k; j++) {
        for (int z = 1; z <= target; z++) {
          dp[i][j][z] = dp[i - 1][j][z];
          if (z >= A[i - 1]) {
            dp[i][j][z] += dp[i - 1][j - 1][z - A[i - 1]];
          }
        }
      }
    }
    return dp[A.length][k][target];
  }
}

/*
 * Method 2: DP
 */
public class Solution {
  public int kSum(int[] A, int k, int target) {
    if (A == null || A.length < k || k <= 0) {
      return 0;
    }
    int n = A.length;
    int[][][] f = new int[2][k + 1][target + 1];
    for (int i = 0; i < 2; i++) {
      f[i][0][0] = 1;
    }
    for (int i = 1; i <= n; i++) {
      f[i % 2][0][0] = 1;
      for (int j = 1; j <= k && j <= i; j++) {
        for (int m = 1; m <= target; m++) {
          f[i % 2][j][m] = f[(i - 1)%2][j][m];
          if (m >= A[i - 1]) {
            f[i % 2][j][m] += f[(i - 1) % 2][j - 1][m - A[i - 1]];
          }
        }
      }
    }
    return f[n % 2][k][target];
  }
}

/*
 * Method 3: DP
 */
public class Solution {
  public int kSum(int A[], int k, int target) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int n = A.length;
    int[][] f = new int[k + 1][target + 1];
    f[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int t = target; t >= 0; t--) {
        for (int j = 1; j <= k && j <= i; j++) {
          if (t >= A[i - 1]) {
            f[j][t] = f[j][t] + f[j - 1][t - A[i - 1]];
          }
        }
      }
    }
    return f[k][target];
  }
}
