// Given two sorted arrays of integers, find the Kth smallest number.
//
// Assumptions
// The two given arrays are not null and at least one of them is not empty
// K >= 1, K <= total lengths of the two sorted arrays
//
// Examples
// A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
// A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.

public class Solution {
  public int kth(int[] a, int[] b, int k) {
    return kth(a, 0, b, 0, k);
  }
  
  // In the subarray of a starting from index aleft, and subarray of b starting from index bleft,
  // find the kth smallest element among these two subarrays.
  private int kth(int[] a, int aleft, int[] b, int bleft, int k) {
    // Three basic cases:
    // 1. we already eliminate all the elements in a.
    // 2. we already eliminate all the elements in b.
    // 3. when k is reduced to 1, don't miss this base case.
    // The reason why we have this as base case is in the following logic we need k >= 2 to make it work.
    if (aleft >= a.length) {
      return b[bleft + k - 1];
    }
    if (bleft >= b.length) {
      return a[aleft + k - 1];
    }
    if (k == 1) {
      return Math.min(a[aleft], b[bleft]);
    }
    // We compare the k/2-th element in a's subarray and the k/2-th element in b's subarray,
    // to determine which k/2 partition canbe surely included in the smallest k elements.
    int amid = aleft + k / 2 - 1;
    int bmid = bleft + k / 2 - 1;
    int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
    int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
    if (aval <= bval) {
      return kth(a, amid + 1, b, bleft, k - k / 2);
    } else {
      return kth(a, aleft, b, bmid + 1, k - k / 2);
    }
  }
}
