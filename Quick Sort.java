// Given an array of integers, sort the elements in the array in ascending order.
// The quick sort algorithm should be used to solve this problem.
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
  public int[] quickSort(int[] array) {
    // Corner chekc
    if (array == null || array.length <= 1) {
      return array;
    }
    // Quick sorting
    quickSort(array, 0, array.length - 1);
    return array;
  }
  
  private void quickSort(int[] array, int left, int right) {
    // Base case
    if (left >= right) {
      return;
    }
    // Recursion rule
    int idx = partition(array, left, right);
    quickSort(array, left, idx - 1);
    quickSort(array, idx + 1, right);
  }
  
  private int partition(int[] array, int left, int right) {
    int pivot = findPivot(array, left, right);
    int i = left;
    int j = right - 1;
    // the compare processing is important and rigorous
    while (i <= j) {      // leftBound (i) = rightBound (j) should be considered
      if (array[i] >= pivot) {
        swap(array, i, j);
        j--;
      } else if (array[j] < pivot) {
        swap(array, i, j);
        i++;
      } else {
        i++;
        j--;
      }
    }
    swap(array, i, right);      // Put back the pivot to the position where leftBound (i) pointed now
    return i;
  }
  
  private int findPivot(int[] array, int left, int right) {
    // Randomly choose the pivot index of the array
    int pivotIndex = left + (int)((right - left) * Math.random());
    swap(array, pivotIndex, right);   // Put the pivot into the last position of the array
    return array[right];
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

// Time complexity O(n) = O(nlog(n))
// Space complexity O(n) = O(1)
