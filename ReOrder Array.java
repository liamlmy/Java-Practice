// Given an array of elements, reorder it as follow:
// { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
// { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
// Try to do it in place.
//
// Assumptions
// The given array is not null
//
// Examples
// { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
// { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
// { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }

public class Solution {
  public int[] reorder(int[] array) {
    // Corner check
    if (array == null || array.length <= 1) {
      return array;
    }
    // Reorder the array
    int[] result = new int[array.length];
    int i = 0;
    int j = array.length / 2;
    int index = 0;
    while (i < array.length / 2) {
      result[index++] = array[i++];
      result[index++] = array[j++];
    }
    while (j < array.length) {
      result[index++] = array[j++];
    }
    return result;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n)
