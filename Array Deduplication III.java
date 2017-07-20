// Given a sorted integer array, remove duplicate elements.
// For each group of elements with the same value do not keep any of them.
// Do this in-place, using the left side of the original array and and maintain the relative order of
// the elements of the array. Return the array after deduplication.
//
// Assumptions
// The given array is not null
//
// Examples
// {1, 2, 2, 3, 3, 3} → {1}

public class Solution {
  public int[] dedup(int[] array) {
    // Corner check
    if (array.length <= 1) {
      return array;
    }
    // Use two clapboards to deduplicate the array
    int slow = 0;
    int fast = 1;
    // Use flag to see if there is any duplicates of array[slow].
    boolean flag = false;
    while (fast < array.length) {
      if (array[slow] == array[fast]) {
        // If there is duplicates, set the flag and do nothing.
        fast++;
        flag = true;
      } else if (flag == true) {
        // If array[slow] != array[fast] and the flag is set, array[slow] should not be included in the valid subarray.
        // And we can just replace it with array[fast] since next we are going to check if there is any duplicates of
        // array[fast].
        array[slow] = array[fast++];
        // Reset the flag to false since we are processing another element now.
        flag = false;
      } else {
        // If array[fast] != array[slow] and flag is not set, it means there is no duplicate of array[slow] and it should
        // be included in the valid subarray.
        array[++slow] = array[fast++];
      }
    }
    return Arrays.copyOf(array, flag ? slow : slow + 1);
  }
}
