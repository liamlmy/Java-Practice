// Given a target integer T and an integer array A sorted in ascending order,
// find the index i in A such that A[i] is closest to T.
//
// Assumptions
// There can be duplicate elements in the array, and we can return any of the indices with same value.
//
// Examples
// A = {1, 2, 3}, T = 2, return 1
// A = {1, 4, 6}, T = 3, return 1
// A = {1, 4, 6}, T = 5, return 1 or 2
// A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
//
// Corner Cases
// What if A is null or A is of zero length? We should return -1 in this case.

public class Solution {
  public int closest(int[] array, int target) {
    // Corner check
    if (array == null || array.length == 0) {
      return -1;
    }
    // Binary searching
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {      // To find the closest target, we may need to use the left number and the right number
                                    // of the target. So we need to remain two pointers when they are adjacent.
      int mid = left + (right - left) / 2;
      if (array[mid] > target) {
        right = mid;                //cannot be left = mid - 1, since maybe array[mid] is the closest element
      } else if (array[mid] < target) {
        left = mid;                 //cannot be right = mid + 1, since maybe array[mid] is the closest element
      } else {
        return mid;
      }
    }
    return Math.abs(array[left] - target) >= Math.abs(array[right] - target) ? right : left;
  }
}
