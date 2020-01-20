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

class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.add(x);
        min = Math.min(min, x);
        minStack.add(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
