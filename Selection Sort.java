// Given an array of integers, sort the elements in the array in ascending order.
// The selection sort algorithm should be used to solve this problem.
//
// Examples
// {1} is sorted to {1}
// {1, 2, 3} is sorted to {1, 2, 3}
// {3, 2, 1} is sorted to {1, 2, 3}
// {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
//
// Corner Cases
// What if the given array is null? In this case, we do not need to do anything.
// What if the given array is of length zero? In this case, we do not need to do anything.

public class Solution {
  public int[] solve(int[] array) {
    // Corner check
    if (array == null || array.length <= 0) {
      return array;
    }
    
    // Selection sorting
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i; j < array.length; j++) {
        minIndex = array[minIndex] > array[j] ? j : minIndex;
      }
      swap(array, i, minIndex);
    }
    return array;
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

// Time complexity O(n) = n + n - 1 + n - 2 + ... + 2 + 1 = O(n^2)
// Space complexity O(n) = O(1);
