// Given an integer array of length L, find the number that occurs more than 0.5 * L times.
//
// Assumptions
// The given array is not null or empty
// It is guaranteed there exists such a majority number
//
// Examples
// A = {1, 2, 1, 2, 1}, return 1

public class Solution {
  public int majority(int[] array) {
    int candidate = array[0];
    int count = 1;
    for (int i = 1; i < array.length; i++) {
      if (count == 0) {
        count++;
        candidate = array[i];
      } else if (candidate == array[i]) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }
}
