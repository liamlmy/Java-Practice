// Given an array of integers, sort the elements in the array in ascending order.
// The merge sort algorithm should be used to solve this problem.
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
  public int[] mergeSort(int[] array) {
    // Corner check
    if (array == null || array.length <= 1) {
      return array;
    }
    
    // Merger sorting
    int[] helper = new int[array.length];             // !Important: Do not initialize the helper[] here.
    mergerSort(array, helper, 0, array.length - 1);
    return array;
  }
  
  private void mergerSort(int[] array, int[] helper, int left, int right) {
    // Base case
    if (left >= right) {
      return;
    }
    
    // Recursion rule
    int mid = left + (right - left) / 2;
    mergerSort(array, helper, left, mid);
    mergerSort(array, helper, mid + 1, right);
    merger(array, helper, left, right, mid);
  }
  
  private void merger(int[] array, int[] helper, int left, int right, int mid) {
    //initialize the helper array in the corresponding local range
    for (int i = left; i <= right; i++) {
      helper[i] = array[i];
    }
    
    int i = left;
    int j = mid + 1;
    while (i <= mid && j <= right) {
      if (helper[i] <= helper[j]) {
        array[left] = helper[i];
        left++;
        i++;
      } else {
        array[left] = helper[j];
        left++;
        j++;
      }
    }
    while (i <= mid) {           //there may left some unfinished part in the left subarray which need to put them in
                                 //to the correct place
                                 //the left right part needs no operate, since they are already in the correct place
      array[left++] = helper[i++];
    }
  }
}

// Time complexity O(n) = O(n + log(n) * n) = O(nlog(n))
// Time complexity O(n) = O(n) (It is not O(log(n)) which is the level of the recursion tree!)
