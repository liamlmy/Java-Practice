// Given n items with size Ai and value Vi, and a backpack with size m.
// What's the maximum value can you put into the backpack?
// Example
// Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

public class Solution {
  public int backPackII(int m, int[] A, int V[]) {
    int[][] dp = new int[A.length + 1][m + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i - 1][j];
          if (j - A[i - 1] >= 0) {
            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
          }
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }
}
