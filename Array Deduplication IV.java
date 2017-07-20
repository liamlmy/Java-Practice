// Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right.
// For each group of elements with the same value do not keep any of them.
// Do this in-place, using the left side of the original array. Return the array after deduplication.
//
// Assumptions
// The given array is not null
//
// Examples
// {1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}

public class Solution {
  public int[] dedup(int[] array) {
    // Corner check
    if (array.length <= 1) {
      return array;
    }
    // Use stack to deduplicate the array
    int slow = 0;
    int fast = 1;
    while (fast < array.length) {
      if (slow == -1 || array[slow] != array[fast]) {
        array[++slow] = array[fast++];
      } else if (array[slow] == array[fast]) {
        while (fast < array.length && array[fast] == array[slow]) {
          fast++;
        }
        slow--;
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}
