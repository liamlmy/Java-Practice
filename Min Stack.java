// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.

public class MinStack {
  int min;
  Deque<Integer> stack;
  
  public MinStack() {
    stack = new LinkedList<Integer>();
  }
  
  public void push(int x) {
    if (x <= min) {
      stack.offerFirst(min);
      stack.offerFirst(x);
      min = x;
    } else {
      stack.offerFirst(x);
    }
  }
  
  public void pop() {
    if (stack.pollFirst() == min) {
      min = stack.pollFirst();
    }
  }
  
  public int top() {
    return stack.peekFirst();
  }
  
  public int getMin() {
    return min;
  }
}
