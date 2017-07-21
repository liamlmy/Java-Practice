// Rotate an N * N matrix clockwise 90 degrees.
//
// Assumptions
// The matrix is not null and N >= 0
//
// Examples
// { {1,  2,  3}
//   {8,  9,  4},
//   {7,  6,  5} }
// after rotation is
// { {7,  8,  1}
//   {6,  9,  2},
//   {5,  4,  3} }

/*
 * Method 1: split into levels and for each level split it into four partitions.
 */
public class Solution {
  public void rotate(int[][] matrix) {
    int length = matrix.length;
    // Corner check
    if (length <= 1) {
      return;
    }
    // Rotate the matrix
    int round = length / 2;
    for (int level = 0; level < round; level++) {
      int left = level;
      int right = length - level - 2;
      for (int i = left; i <= right; i++) {
        int temp = matrix[left][i];
        matrix[left][i] = matrix[length - 1 - i][left];
        matrix[length - 1 - i][left] = matrix[length - 1 - left][length - 1 - i];
        matrix[length - 1 - left][length - 1 - i] = matrix[i][length - 1 - left];
        matrix[i][length - 1 - left] = temp;
      }
    }
  }
}

/*
 * Method 2: rotate a pointer by 90 degree clockwise ==
 *           a. mirror the pointer according to y axis, then
 *           b. mirror the pointer according to the line of y = x
 */
public class Solution {
  public void rotate(int[][] matrix) {
    int length = matrix.length;
    // Corner check
    if (length <= 1) {
      return;
    }
    // Rotate the matrix
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length / 2; j++) {
        swap(matrix, i, j, i, length - 1 - j);
      }
    }
    for (int i = 0; i < length; i++) {
      for (int j = 0; j + i < length - 1; j++) {
        swap(matrix, i, j, length - 1 - j, length - 1 - i);
      }
    }
  }
  
  private void swap(int[][] matrix, int i, int j, int a, int b) {
    int temp = matrix[i][j];
    matrix[i][j] = matrix[a][b];
    matrix[a][b] = temp;
  }
 }
