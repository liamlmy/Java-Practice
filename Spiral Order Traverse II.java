// Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner.
// Return the list of traversal sequence.
//
// Assumptions
// The 2D array is not null and has size of M * N where M, N >= 0
//
// Examples
// { {1,  2,  3,  4},
//
//   {5,  6,  7,  8},
//
//   {9, 10, 11, 12} }
//
// the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Corner check
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<Integer>();
    }
    
    // Traverse the matrix
    int m = matrix.length;
    int n = matrix[0].length;
    int top = 0;
    int bottom = m - 1;
    int left = 0;
    int right = n - 1;
    List<Integer> result = new ArrayList<Integer>();
    
    while (top < bottom && left < right) {
      /*
       * Top line
       */
      for (int i = left; i < right; i++) {
        result.add(matrix[top][i]);
      }
      /*
       * Right line
       */
      for (int i = top; i < bottom; i++) {
        result.add(matrix[i][right]);
      }
      /*
       * Bottom line
       */
      for (int i = right; i > left; i--) {
        result.add(matrix[bottom][i]);
      }
      /*
       * Left line
       */
      for (int i = bottom; i > top; i--) {
        result.add(matrix[i][left]);
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    /*
     * There are no elements remained
     */
    if (bottom < top || left > right) {
      return result;
    }
    /*
     * There are some elements (one row or one column) remained
     */
    if (bottom == top) {
      for (int i = left; i <= right; i++) {
        result.add(matrix[bottom][i]);
      }
    } else {
      for (int i = top; i <= bottom; i++) {
        result.add(matrix[i][left]);
      }
    }
    return result;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n)
