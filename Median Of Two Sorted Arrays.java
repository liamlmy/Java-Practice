// Given two sorted arrays of integers in ascending order, find the median value.
//
// Assumptions
// The two given array are not null and at least one of them is not empty
// The two given array are guaranteed to be sorted
//
// Examples
// A = {1, 4, 6}, B = {2, 3}, median is 3
// A = {1, 4}, B = {2, 3}, median is 2.5

public class Solution {
  public double median(int[] a, int[] b) {
    if ((a.length + b.length) % 2 == 0) {
      return (kth(a, 0, b, 0, (a.length + b.length) / 2) + kth(a, 0, b, 0, (a.length + b.length) / 2 + 1)) / 2.0;
    } else {
      return (double) kth(a, 0, b, 0, (a.length + b.length) / 2 + 1);
    }
  }
  
  private int kth(int[] a, int aIndex, int[] b, int bIndex, int k) {
    //
    if (aIndex >= a.length) {
      return b[bIndex + k - 1];
    }
    if (bIndex >= b.length) {
      return a[aIndex + k - 1];
    }
    if (k == 1) {
      return Math.min(a[aIndex], b[bIndex]);
    }
    int aNext = aIndex + k / 2 - 1;
    int bNext = bIndex + k / 2 - 1;
    int aVal = aNext >= a.length ? Integer.MAX_VALUE : a[aNext];
    int bVal = bNext >= b.length ? Integer.MAX_VALUE : b[bNext];
    if (aVal <= bVal) {
      return kth(a, aNext + 1, b, bIndex, k - k / 2);
    } else {
      return kth(a, aIndex, b, bNext + 1, k - k / 2);
    }
  }
}
