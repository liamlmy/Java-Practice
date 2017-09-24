// Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s,
// with the same arm lengths and the four arms joining at the central point.
// Return the arm length of the largest cross.
//
// Assumptions
// The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
//
// Examples
// { {0, 0, 0, 0},
//   {1, 1, 1, 1},
//   {0, 1, 1, 1},
//   {1, 0, 1, 1} }
//
// the largest cross of 1s has arm length 2.

public class Solution {
  public int largest(int[][] matrix) {
    int M = matrix.length;
    if (M == 0) {   // Corner case
      return 0;
    }
    int N = matrix[0].length;
    if (N == 0) {   // Corner case
      return 0;
    }
    // leftup records the longest possible length for left and up arms ending at each cells in the matrix
    int[][] leftup = leftup(matrix, M, N);
    // rightdown records the longest possible length for right and down arms ending at each cells in the matrix
    int[][] rightdown = rightdown(matrix, M, N);
    // merge two matrix by getting the min value for each cell, and among all cells get the max value
    return merge(leftup, rightdown, M, N);
  }
  
  // get the max possible length of left and up arms for each of the cells in the matrix
  private int[][] leftup(int[][] matrix, int M, int N) {
    int[][] left = new int[M][N];
    int[][] up = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 1) {
          if (i == 0) {
            up[i][j] = 1;
          } else if (j == 0) {
            left[i][j] = 1;
          } else {
            if (up[i - 1][j] > 0) {
              up[i][j] = up[i - 1][j] + 1;
            } else {
              up[i][j] = 1;
            }
            if (left[i][j - 1] > 0) {
              left[i][j] = left[i][j - 1] + 1;
            } else {
              left[i][j] = 1;
            }
          }
        }
      }
    }
    // merge the left and up matrix, return the merged matrix
    merge(left, up, M, N);
    return left;
  }
  
  // get the max possible length of right and bottom arms for each of the cells in the matrix
  private int[][] rightdown(int[][] matrix, int M, int N) {
    int[][] right = new int[M][N];
    int[][] down = new int[M][N];
    for (int i = M - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          if (i == M - 1) {
            down[i][j] = 1;
          } else if (j == N - 1) {
            right[i][j] = 1;
          } else {
            if (down[i + 1][j] > 0) {
              down[i][j] = down[i + 1][j] + 1;
            } else {
              down[i][j] = 1;
            }
            if (right[i][j + 1] > 0) {
              right[i][j] = right[i][j + 1] + 1;
            } else {
              right[i][j] = 1;
            }
          }
        }
      }
    }
    // merge the right and down matrix, return the merged matrix
    merge(right, down, M, N);
    return right;
  }
  
  // merge leftup and rightdown matrix into leftup matrix,
  // the value of each cell in the min value of the corresponding cells in the two matrix,
  // also it returns the max value among all the cells in the merged matrix
  private int merge(int[][] A, int[][] B, int M, int N) {
    int result = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        A[i][j] = Math.min(A[i][j], B[i][j]);
        result = Math.max(result, A[i][j]);
      }
    }
    return result;
  }
}

// Time complexity: O(n ^ 2)
// Space complexity: O(n ^ 2)
