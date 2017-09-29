// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class Solution {
  public boolean isValid(String s) {
    Deque<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.offerFirst(')');
      } else if (s.charAt(i) == '[') {
        stack.offerFirst(']');
      } else if (s.charAt(i) == '{') {
        stack.offerFirst('}');
      } else {
        if (stack.isEmpty() || stack.pollFirst() != s.charAt(i)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
