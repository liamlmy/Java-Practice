// You are given an n x n 2D matrix representing an image.
// Rotate the image by 90 degrees (clockwise).
//
// Note:
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
// DO NOT allocate another 2D matrix and do the rotation.

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
