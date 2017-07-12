// Enhance the stack implementation to support min() operation.
// min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.
//
// pop() - remove and return the top element, if the stack is empty, return -1
// push(int element) - push the element to top
// top() - return the top element without remove it, if the stack is empty, return -1
// min() - return the current min value in the stack.

public class Solution {
  private Deque<Integer> stack;
  private Deque<Integer> min;
  
  public Solution() {
    stack = new LinkedList<Integer>();
    min = new LinkedList<Integer>();
  }
  
  public Integer min() {
    if (stack.isEmpty()) {
      return -1;
    }
    return min.peekFirst();
  }
  
  public Integer top() {
    return stack.isEmpty() ? -1 : stack.peekFirst();
  }
  
  public void push(int element) {
    if (stack.isEmpty()) {
      stack.offerFirst(element);
      min.offerFirst(element);
    } else {
      stack.offerFirst(element);
      if (min.peekFirst() >= element) {
        min.offerFirst(element);
      }
    }
  }
  
  public Integer pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    Integer value = stack.pollFirst();
    if (value == min.peekFirst()) {
      min.pollFirst();
    }
    return value;
  }
}
