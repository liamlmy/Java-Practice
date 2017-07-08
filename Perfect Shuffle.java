// Given an array of integers (without any duplicates), shuffle the array such that all permutations
// are equally likely to be generated.
//
// Assumptions
// The given array is not null

public class Solution {
  public void shuffle(int[] array) {
    // Corner check
    if (array.length <= 1) {
      return;
    }
    
    // Shuffle the array
    for (int i = array.length; i > 0; i--) {
      int idx = (int) (Math.random() * i);
      swap(array, i - 1, idx);
    }
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
