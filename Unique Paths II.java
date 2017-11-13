// Follow up for "Unique Paths":
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.
// Note: m and n will be at most 100.

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Corner case
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        // DP
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = 1;
                } else if (i == 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (i != 0 && j != 0 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
