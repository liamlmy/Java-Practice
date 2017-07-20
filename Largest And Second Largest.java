// Use the least number of comparisons to get the largest and 2nd largest number in the given integer array.
// Return the largest number and 2nd largest number.
//
// Assumptions
// The given array is not null and has length of at least 2
//
// Examples
// {2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.

public class Solution {
  // The Element class will be used to store the original value in the array and all the values compared to it.
  static class Element {
    int value;
    List<Integer> comparedValues;
    
    Element(int value) {
      this.value = value;
      this.comparedValues = new ArrayList<>();
    }
  }
  
  public int[] largestAndSecond(int[] array) {
    // Assumptions: array is not null, array.length >= 2.
    // Convert the original array to Element array.
    Element[] helper = convert(array);
    // n is the left partition's length containing the larger values after each round of comparison.
    // For each round, the comparison is still doing for each of the indices pairs (i, n - 1 - i).
    // So that the larger elements are always on the left side, and the n will be cut in half each round.
    // n is obviously initiated by the array's length.
    int n = array.length;
    // We will terminate when there is only one element left on the larger partition, and it has to be the largest value.
    // The second largest value is the largest value in its compared values.
    while (n > 1) {
      compareAndSwap(helper, n);
      n = (n + 1) / 2;
    }
    return new int[] {helper[0].value, largest(helper[0].comparedValues)};
  }
  
  private Element[] convert(int[] array) {
    Element[] result = new Element[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = new Element(array[i]);
    }
    return result;
  }
  
  // Compare each of the indices pairs (i, n - 1 - i), swap the larger values on the left side if necessary,
  // and put the smaller value into the larger value's compare values list.
  private void compareAndSwap(Element[] helper, int n) {
    for (int i = 0; i < n / 2; i++) {
      if (helper[i].value < helper[n - 1 - i].value) {
        swap(helper, i, n - 1 - i);
      }
      helper[i].comparedValues.add(helper[n - 1 - i].value);
    }
  }
  
  private void swap(Element[] helper, int i, int j) {
    Element temp = helper[i];
    helper[i] = helper[j];
    helper[j] = temp;
  }
  
  private int largest(List<Integer> list) {
    // This is guaranteed to be O(1).
    Integer largest = Integer.MIN_VALUE;
    // Using Iterator is guaranteed to be O(1) traversing each of the elements in the list.
    for (Integer number : list) {
      largest = Math.max(largest, number);
    }
    return largest;
  }
}
