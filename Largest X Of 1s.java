// Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s,
// with the same arm lengths and the four arms joining at the central point.
// Return the arm length of the largest X shape.
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
// the largest X of 1s has arm length 2.

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
    // up records the longest possible length for the two upper arms ending at each cells in the matrix
    int[][] up = up(matrix, M, N);
    // down records the longest possible length for the two down arms ending at each cells in teh matrix
    int[][] down = down(matrix, M, N);
    // merge the two matrxi by getting the min value for each cell, and among all the cells get the max value
    return merge(up, down, M, N);
  }
  
  // calculate the max possible length of down arms for each of the cells in the matrix
  private int[][] up(int[][] matrix, int M, int N) {
    int[][] left = new int[M][N];
    int[][] right = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 1) {
          if (i == 0) {
            left[i][j] = 1;
            right[i][j] = 1;
          } else if (j == 0) {
            left[i][j] = 1;
            if (right[i - 1][j + 1] > 0) {
              right[i][j] = right[i - 1][j + 1] + 1;
            } else {
              right[i][j] = 1;
            }
          } else if (j == N - 1) {
            right[i][j] = 1;
            if (left[i - 1][j - 1] > 0) {
              left[i][j] = left[i - 1][j - 1] + 1;
            } else {
              left[i][j] = 1;
            }
          } else {
            if (left[i - 1][j - 1] > 0) {
              left[i][j] = left[i - 1][j - 1] + 1;
            } else {
              left[i][j] = 1;
            }
            if (right[i - 1][j + 1] > 0) {
              right[i][j] = right[i - 1][j + 1] + 1;
            } else {
              right[i][j] = 1;
            }
          }
        }
      }
    }
    merge(left, right, M, N);
    return left;
  }
  
  // calculate the max possible length of up arms for each of the cells in the matrix
  private int[][] down(int[][] matrix, int M, int N) {
    int[][] left = new int[M][N];
    int[][] right = new int[M][N];
    for (int i = M - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          if (i == M - 1) {
            left[i][j] = 1;
            right[i][j] = 1;
          } else if (j == 0) {
            left[i][j] = 1;
          } else if (j == N - 1) {
            right[i][j] = 1;
          } else {
            if (left[i + 1][j - 1] > 0) {
              left[i][j] = left[i + 1][j - 1] + 1;
            } else {
              left[i][j] = 1;
            }
            if (right[i + 1][j + 1] > 0) {
              right[i][j] = right[i + 1][j + 1] + 1;
            } else {
              right[i][j] = 1;
            }
          }
        }
      }
    }
    merge(left, right, M, N);
    return left;
  }
  
  // merge up and down matrix in to up,
  // the value of each cell is min value of the corresponding cells in the two matrix,
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
