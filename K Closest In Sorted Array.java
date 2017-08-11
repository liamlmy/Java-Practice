// Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order,
// find the K closest numbers to T in A.
//
// Assumptions
// A is not null
// K is guranteed to be >= 0 and K is guranteed to be <= A.length
//
// Return
// A size K integer array containing the K closest numbers(not indices) in A,
// sorted in ascending order by the difference between the number and T. 
//
// Examples
// A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
// A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}

public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    // Corner check
    if (array == null || array.length == 0) {
      return array;
    }
    // Binary searching
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;      // In this case, if array[mid] == target, we can just put one pointer to the target
      }
    }
    // Find the k closest elements in the array
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      // If you first judge the left element, you should first consider if right
      //pointer is out of bound, then you should consider whether left pointer
      //is out of bound, lastly you should consider the absolute difference
      //value of the target between two pointed elements
      if (right >= array.length || left >= 0 && Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
        result[i] = array[left];
        left--;
      } else {
        result[i] = array[right];
        right++;
      }
    }
    return result;
  }
}

// Time complexity O(n) = O(log(n) + k)
// Space complexity O(n) = O(k)
