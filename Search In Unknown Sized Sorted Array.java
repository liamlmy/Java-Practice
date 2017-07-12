// Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order,
// determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.
//
// Assumptions
// dictionary A is not null
// dictionary.get(i) will return null(Java)/INT_MIN(C++) if index i is out of bounds
//
// Examples
// A = {1, 2, 5, 9, ......}, T = 5, return 2
// A = {1, 2, 5, 9, 12, ......}, T = 7, return -1

public class Solution {
  public int search(Dictionary dict, int target) {
    // Corner check
    if (dict == null) {
      return -1;
    }
    // Binary searching
    int left = 0;
    int right = 1;
    while (dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right = 2 * right;
    }
    return binarySearch(dict, left, right, target);
  }
  
  // Classic binary search
  private int binarySearch(Dictionary dict, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (dict.get(mid) == null || dict.get(mid) > target) {    // We should first judge whether right is out of bound
        right = mid - 1;
      } else if (dict.get(mid) < target) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
