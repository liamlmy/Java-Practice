// Use the least number of comparisons to get the largest and smallest number in the given integer array.
// Return the largest number and the smallest number.
//
// Assumptions
// The given array is not null and has length of at least 1
//
// Examples
// {2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].

public class Solution {
  public int[] largestAndSmallest(int[] array) {
    int n = array.length;
    for (int i = 0; i < n / 2; i++) {
      if (array[i] < array[n - 1 - i]) {
        swap(array, i, n - 1 - i);
      }
    }
    return new int[] {largest(array, 0, (n - 1) / 2), smallest(array, n / 2, n - 1)};
  }
  
  private int largest(int[] array, int i, int j) {
    int largest = array[i];
    while (i <= j) {
      largest = Math.max(largest, array[i]);
      i++;
    }
    return largest;
  }
  
  private int smallest(int[] array, int i, int j) {
    int smallest = array[i];
    while (i <= j) {
      smallest = Math.min(smallest, array[i]);
      i++;
    }
    return smallest;
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
