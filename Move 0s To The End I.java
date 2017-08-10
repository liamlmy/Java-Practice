// Given an array of integers, move all the 0s to the right end of the array.
// The relative order of the elements in the original array does not need to be maintained.
//
// Assumptions:
// The given array is not null.
//
// Examples:
// {1} --> {1}
// {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}

public class Solution {
  public int[] moveZero(int[] array) {
    // Corner check
    if (array.length <= 1) {
      return array;
    }
    
    // Move all zeros to the right end of the array
    int left = 0;
    int right = array.length - 1;
    /*
     * Swap all the zeros from the left point to the right point
     */
    while (left < right) {
      if (array[left] == 0) {
        swap(array, left, right);
        right--;
      } else {
        left++;
      }
    }
    
    return array;
  }
  
  /*
   * Swap function
   */
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

// Time complexity O(n) = O(n)
// Space complexity O(n) = 1
