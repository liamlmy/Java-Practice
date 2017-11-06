// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
// find the area of largest rectangle in the histogram.

public class Solution {
  public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new LinkedList<>();
    int length = heights.length;
    int area = 0;
    for (int i = 0; i <= length; i++) {
      int h = (i == length ? 0 : heights[i]);
      while (!stack.isEmpty() && stack.peekFirst() > heights[i]) {
        int top = heights[stack.pollFirst()];
        int left = (stack.isEmpty() ? 0 : stack.peekFirst() + 1);
        area = Math.max(area, top * (i - left));
      }
      stack.offerFirst(i);
    }
    return area;
  }
}
