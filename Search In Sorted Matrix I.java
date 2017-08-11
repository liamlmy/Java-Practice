// Given a 2D matrix that contains integers only, which each row is sorted in an ascending order.
// The first element of next row is larger than (or equal to) the last element of previous row.
//
// Given a target number, returning the position that the target locates within the matrix.
// If the target number does not exist in the matrix, return {-1, -1}.
//
// Assumptions:
// The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
//
// Examples:
// matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
// target = 7, return {1, 2}
// target = 6, return {-1, -1} to represent the target number does not exist in the matrix.

public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Corner check
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[] {-1, -1};
    }
    // Binary search
    int m = matrix.length;
    int n = matrix[0].length;
    int start = 0;
    int end = m * n - 1;
    while (start <= end) {
      int mid =  start + (end - start) / 2;
      int row = mid / n;
      int col = mid % n;
      if (matrix[row][col] > target) {
        end = mid - 1;
      } else if (matrix[row][col] < target) {
        start = mid + 1;
      } else {
        return new int[] {row, col};
      }
    }
    return new int[] {-1, -1};
  }
}

// Time complexity O(n) = O(log(n))
// Space complexity O(n) O(1)
