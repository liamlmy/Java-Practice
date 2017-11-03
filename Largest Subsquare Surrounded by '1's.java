// Given a matrix (not null) where every element is either '0' or '1', find the largest subsquare surrounded by '1's.

public class Solution {
  public int largerst(int[][] matrix) {
    // Corner check
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    // DP
    int result = 0;
    int M = matrix.length;
    int N = matrix[0].length;
    int[][] right = new int[M][N];
    int[][] bottom = new int[M][N];
    for (int i = M - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        if (i == M - 1) {
          bottom[i][j] = matrix[i][j] == 1 ? 1 : 0;
        } else if (j == N - 1) {
          right[i][j] = matrix[i][j] == 1 ? 1 : 0;
        } else if (matrix[i][j] == 1) {
          right[i][j] = right[i][j + 1] + 1;
          bottom[i][j] = bottom[i + 1][j] + 1;
        }
      }
    }
    int solution = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        int length = Math.min(bottom[i][j], right[i][j]);
        while (length > 0) {
          if (bottom[i][j + length - 1] >= length && right[i + length - 1][j] >= length) {
            solution = Math.max(solution, length);
            break;
          }
          length--;
        }
      }
    }
    return solution;
  }
}

// Time complexity: O(n) = O(n^3)
// Space complexity: O(n) = O(n^2)
