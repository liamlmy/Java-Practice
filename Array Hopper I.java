// Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
// A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
// Determine if you are able to reach the last index.
//
// Assumptions
// The given array is not null and has length of at least 1.
//
// Examples
// {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)
// {2, 1, 1, 0, 2}, we are not able to reach the end of array

public class Solution {
  public boolean canJump(int[] array) {
    // Corner check
    if (array.length == 1) {
      return true;
    }
    // Dynamic Programming
    boolean[] M = new boolean[array.length];
    M[array.length - 1] = true;
    for (int i = array.length - 2; i >= 0; i--) {
      for (int j = 0; j <= array[i]; j++) {
        if (M[i + j] == true) {
          M[i] = true;
          break;
        } else {
          M[i] = false;
        }
      }
    }
    return M[0];
  }
}
