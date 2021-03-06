// Given a sorted integer array, remove duplicate elements.
// For each group of elements with the same value keep only one of them.
// Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array.
// Return the array after deduplication.
//
// Assumptions
// The array is not null
//
// Examples
// {1, 2, 2, 3, 3, 3} → {1, 2, 3}

public class Solution {
  public int[] dedup(int[] array) {
    // Corner check
    if (array.length <= 1) {
      return array;
    }
    // Use two clapboards to remove duplicate elements
    int slow = 0;
    int fast = 1;
    while (fast < array.length) {
      if (array[fast] != array[slow]) {
        array[++slow] = array[fast++];
      } else {
        fast++;
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}

// Time complexity: O(n)
// Space complexity: O(1)
