// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

public class Solution {
  public void setZeroes(int[][] matrix) {
    boolean i0 = false;
    boolean j0 = false;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) {
            i0 = true;
          }
          if (j == 0) {
            j0 = true;
          }
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (i0) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }
    if (j0) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
