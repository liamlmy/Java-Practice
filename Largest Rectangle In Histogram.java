// Given a non-negative integer array representing the heights of a list of adjacent bars.
// Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.
//
// Assumptions
// The given array is not null or empty
//
// Examples
// { 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)

public class Solution {
  public int largest(int[] array) {
    int result = 0;
    // Note that the stack contains the "index", not the "value" of the array.
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i <= array.length; i++) {
      // Way need a way of popping out all the elements in the stack at last,
      // so that we explicitly add a bar of height 0.
      int cur = i == array.length ? 0 : array[i];
      while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
        int height = array[stack.pollFirst()];
        // Determine the left boundary of the largest rectangle with height array[i].
        int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
        // Determine the right boundary of the largest rectangle with height of the popped element.
        result = Math.max(result, height * (i - left));
      }
      stack.offerFirst(i);
    }
    return result;
  }
}
