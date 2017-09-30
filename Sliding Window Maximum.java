// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
// You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Therefore, return the max sliding window as [3,3,5,5,6,7].
//
// Note: 
// You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
//
// Follow up:
// Could you solve it in linear time?

public class Solution {
  public int[] maxSlidingWindow(int[] a, int k) {
    // Corner check
    if (a == null || k <= 0) {
      return new int[0];
    }
    // Use deque
    int n = a.length;
    int[] result = new int[n - k + 1];
    int index = 0;
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < a.length; i++) {
      while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      if (i >= k - 1) {
        result[index] = a[deque.peekFirst()];
        index++;
      }
    }
    return result;
  }
}
