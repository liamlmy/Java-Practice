// Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
// Example
// If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5],
// so that the max size we can fill this backpack is 10.
// If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
// You function should return the max size we can fill in the given backpack.

public class Solution {
  public int backPack(int m, int[] A) {
    boolean[][] dp = new boolean[A.length + 1][m + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = false;
        } else {
          dp[i][j] = dp[i - 1][j];
          if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]]) {
            dp[i][j] = true;
          }
        }
      }
    }
    for (int i = m; i >= 0; i--) {
      if (dp[A.length][i]) {
        return i;
      }
    }
    return 0;
  }
}
