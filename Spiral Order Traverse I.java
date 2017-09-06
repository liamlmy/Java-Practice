// Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner.
// Return the list of traversal sequence.
//
// Assumptions
// The 2D array is not null and has size of N * N where N >= 0
//
// Examples
// { {1,  2,  3},
//
//   {4,  5,  6},
//
//   {7,  8,  9} }
//
// the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]

public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Corner check
    if (matrix.length == 0) {
      return new ArrayList<Integer>();
    }
    
    // Traverse the matrix
    int N = matrix.length;
    int offset = 0;
    List<Integer> result = new ArrayList<Integer>();
    while (offset <= (N - 1) / 2) {
      traverse(matrix, offset, N, result);
      offset += 1;
    }
    return result;
  }
  
  private void traverse(int[][] matrix, int offset, int N, List<Integer> result) {
    /*
     * Top line
     */
    for (int i = offset; i < N - 1 - offset; i++) {
      result.add(matrix[offset][i]);
    }
    /*
     * Right line
     */
    for (int i = offset; i < N - 1 - offset; i++) {
      result.add(matrix[i][N - 1 - offset]);
    }
    /*
     * Bottom line
     */
    for (int i = N - 1 - offset; i >= offset; i--) {
      result.add(matrix[N - 1 - offset][i]);
    }
    /*
     * Left line
     */
    for (int i = N - 1 - offset - 1; i > offset; i--) {
      result.add(matrix[i][offset]);
    }
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n)
