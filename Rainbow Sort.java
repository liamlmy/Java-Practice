// Given an array of balls, where the color of the balls can only be Red, Green or Blue,
// sort the balls such that all the Red balls are grouped on the left side,
// all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side.
// (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).
//
// Examples
// {0} is sorted to {0}
// {1, 0} is sorted to {0, 1}
// {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
//
// Assumptions
// The input array is not null.
//
// Corner Cases
// What if the input array is of length zero? In this case, we should not do anything as well.

public class Solution {
  public int[] rainbowSort(int[] array) {
    // Corner case
    if (array == null || array.length <= 1) {
      return array;
    }
    // Rainbow sorting
    // All the numbers which are be left of r are < 0 (not including r).
    // All the numbers which are be right of b are > 0 (not including b).
    // All the numbers between r and g are == 0 (not including g, but including r).
    // All the numbers between g and b are undetermined numbers.
    int r = 0;
    int g = 0;
    int b = array.length - 1;
    while (g <= b) {
      if (array[g] < 0) {
        swap(array, r, g);
        r++;
        g++;
      } else if (array[g] == 0) {
        g++;
      } else {
        swap(array, g, b);
        b--;
      }
    }
    return array;
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
