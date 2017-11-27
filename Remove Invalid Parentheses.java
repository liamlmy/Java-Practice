// Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//
// Note: The input string may contain letters other than the parentheses ( and ).
//
// Examples:
// "()())()" -> ["()()()", "(())()"]
// "(a)())()" -> ["(a)()()", "(a())()"]
// ")(" -> [""]

public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    List<String> result = new ArrayList<>();
    if (s == null) {
      return result;
    }
    Set<String> set = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    set.add(s);
    queue.offer(s);
    boolean flag = false;
    while (!queue.isEmpty()) {
      s = queue.poll();
      if (valid(s)) {
        result.add(s);
        flag = true;
      }
      if (flag) {
        continue;
      }
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != '(' && s.charAt(i) != ')') {
          continue;
        }
        String next = s.substring(0, i) + s.substring(i + 1);
        if (!set.contains(next)) {
          queue.offer(next);
          set.add(next);
        }
      }
    }
    return result;
  }
  
  private boolean valid(String input) {
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '(') {
        count++;
      }
      if (input.charAt(i) == ')') {
        if (count == 0) {
          return false;
        }
        count--;
      }
    }
    return count == 0;
  }
}
