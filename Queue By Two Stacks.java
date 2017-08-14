// Java: Implement a queue by using two stacks.
// The queue should provide size(), isEmpty(), offer(), poll() and peek() operations.
// When the queue is empty, poll() and peek() should return null.
//
// C++: Implement a queue by using two stacks.
// The queue should provide size(), isEmpty(), push(), front() and pop() operations.
// When the queue is empty, front() should return -1.
//
// Assumptions
// The elements in the queue are all Integers.
// size() should return the number of elements buffered in the queue.
// isEmpty() should return true if there is no element buffered in the queue, false otherwise.

public class Solution {
  private Deque<Integer> stackIn;
  private Deque<Integer> stackOut;
  
  public Solution() {
    stackIn = new LinkedList<Integer>();
    stackOut = new LinkedList<Integer>();
  }
  
  public int size() {
    return stackIn.size() + stackOut.size();
  }
  
  public boolean isEmpty() {
    return stackIn.isEmpty() && stackOut.isEmpty();
  }
  
  public void offer(int element) {
    stackIn.offerFirst(element);          // Use offerFirst() to let time complexity is O(1)
  }
  
  public Integer poll() {
    move();
    return stackOut.isEmpty() ? null : stackOut.pollFirst();    // Use pollFirst() to let time complexity is O(1)
  }
  
  public Integer peek() {
    move();
    return stackOut.isEmpty() ? null : stackOut.peekFirst();    // Use peekFirst() to let time complexity is O(1)
  }
  
  private void move() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.offerFirst(stackIn.pollFirst());     // !Important: offerFirst and pollFirst can achieve the goal and
                                                      // the time complexity is less than offerLast and pollLast
      }
    }
  }
}

// Time complexity: O(n) = O(n); Amortized time complexity: O(n) = O(1)
// Space complexity: O(n) = O(n)
