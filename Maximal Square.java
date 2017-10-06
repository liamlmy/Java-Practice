// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
// For example, given the following matrix:
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// Return 4.

/*
 * Method 1: DP
 */
/*
public class Solution {
  public int maximalSquare(char[][] matrix) {
    int rows = matrix.length;
    int cols = rows > 0 ? matrix[0].length : 0;
    int result = 0;
    int[][] M = new int[rows + 1][cols + 1];
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          M[i][j] = Math.min(Math.min(M[i - 1][j], M[i][j - 1]), M[i - 1][j - 1]) + 1;
          result = Math.max(M[i][j], result);
        }
      }
    }
    return result * result;
  }
}

// Time complexity: O(mn)
// Space complexity: O(mn)
*/

/*
 * Method 2: DP
 */
public class Solution {
  public int maximalSquare(char[][] matrix) {
    int rows = matrix.length;
    int cols = rows > 0 ? matrix[0].length : 0;
    int[] dp = new int[cols + 1];
    int maxsqlen = 0;
    int prev = 0;
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        int temp = dp[j];
        if (matrix[i - 1][j - 1] == '1') {
          dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
          maxsqlen = Math.max(maxsqlen, dp[j]);
        } else {
          dp[j] = 0;
        }
        prev = temp;
      }
    }
    return maxsqlen * maxsqlen;
  }
}

// Time complexity: O(mn)
// Space complexity: O(n)
