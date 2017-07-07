// Given a matrix that contains integers, find the submatrix with the largest sum.
// Return the sum of the submatrix.
//
// Assumptions
// The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
//
// Examples
// { {1, -2, -1, 4},
//   {1, -1,  1, 1},
//   {0, -1, -1, 1},
//   {0,  0,  1, 1} }
//
// the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.

public class Solution {
  public int largest(int[][] matrix) {
    int M = matrix.length;
    int N = matrix[0].length;
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < M; i++) {
      int[] cur = new int[N];
      for (int j = i; j < M; j++) {
        // For each row i, we add the rows one by one for row j,
        // to make sure each time we only introduce O(n) time
        add(cur, matrix[j]);
        // For each possible pairs of i and j, we would like to know what is the largest submatrix sum
        // using top row as row i and bottom row as row j.
        // We "flatten" this area to a one dimensional array
        result = Math.max(result, max(cur));
      }
    }
    return result;
  }
  
  private void add(int[] cur, int[] matrix) {
    for (int i = 0; i < cur.length; i++) {
      cur[i] += matrix[i];
    }
  }
  
  // largest subarray sum
  private int max(int[] cur) {
    int result = cur[0];
    int temp = cur[0];
    for (int i = 1; i < cur.length; i++) {        // Important: it is started from 1 not 0!
      temp = Math.max(temp + cur[i], cur[i]);
      result = Math.max(result, temp);
    }
    return result;
  }
}
