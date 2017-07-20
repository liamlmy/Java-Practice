// Given a sorted integer array, remove duplicate elements.
// For each group of elements with the same value keep at most two of them.
// Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array.
// Return the array after deduplication.
//
// Assumptions
// The given array is not null
//
// Examples
// {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}

public class Solution {
  public int[] dedup(int[] array) {
    // Corner check
    if (array.length <= 2) {
      return array;
    }
    // Use two clapboards to deduplicate the array
    int slow = 1;
    int fast = 2;
    while (fast < array.length) {
      if (array[fast] == array[slow - 1]) {
        fast++;
      } else {
        array[++slow] = array[fast++];
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}
