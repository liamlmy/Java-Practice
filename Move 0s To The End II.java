// Given an array of integers, move all the 0s to the right end of the array.
// The relative order of the elements in the original array need to be maintained.
//
// Assumptions:
// The given array is not null.
//
// Examples:
// {1} --> {1}
// {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}

public class Solution {
  public int[] moveZero(int[] array) {
    // Corner check
    if (array.length <= 1) {
      return array;
    }
    // Use two clapboards to move 0s to the end
    int fast = 0;
    int slow = 0;
    while (fast < array.length) {
      if (array[fast] != 0) {
        array[slow] = array[fast];
        slow++;
        fast++;
      } else {
        fast++;
      }
    }
    while (slow < array.length) {
      array[slow++] = 0;
    }
    return array;
  }
}
