// Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1),
// return the length of the largest square.
//
// Assumptions
// The given matrix is not null and guaranteed to be of size N * N, N >= 0
//
// Examples
// { {0, 0, 0, 0},
//   {1, 1, 1, 1},
//   {0, 1, 1, 1},
//   {1, 0, 1, 1}}
// the largest square of 1s has length of 2

public class Solution {
  public int largest(int[][] matrix) {
    int N = matrix.length;
    int[][] largest = new int[N][N];
    int result = 0;
    // largest[i][j] means the largest square of 1's with right bottom corner as matrix[i][j]
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i == 0 || j == 0) {
          largest[i][j] = matrix[i][j] == 1 ? 1 : 0;
        } else {
          if (matrix[i][j] == 1) {
            largest[i][j] = Math.min(largest[i - 1][j] + 1, largest[i][j - 1] + 1);
            largest[i][j] = Math.min(largest[i][j], largest[i - 1][j - 1] + 1);
          }
        }
        result = Math.max(result, largest[i][j]);
      }
    }
    return result;
  }
}

// Time complexity: O(n ^ 2)
// Space complexity: O(n ^ 2)
