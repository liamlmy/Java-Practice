// Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.
//
// Assumptions
// l, m, n >= 0
//
// Examples
// l = 1, m = 1, n = 0, all the valid permutations are ["()[]", "([])", "[()]", "[]()"]

public class Solution {
  private static final char[] PS = new char[] {'(', ')', '[', ']', '{', '}'};

  public List<String> validParentheses(int l, int m, int n) {
    int[] remian = new int[] {l, l, m, m, n, n};
    int targetLength = 2 * l + 2 * m + 2 * n;
    StringBuilder cur  = new StringBuilder();
    Deque<Character> stack = new LinkedList<Character>();
    List<String> result = new ArrayList<String>();
    DFS(cur, stack, result, remian, targetLength);
    return result;
  }
  
  private void DFS(StringBuilder cur, Deque<Character> stack, List<String> result, int[] remain, int targetLength) {
    // Base case
    if (cur.length() == targetLength) {
      result.add(cur.toString());
      return;
    }
    // Recursion rule
    for (int i = 0; i < remain.length; i++) {
      if (i % 2 == 0) {
        if (remain[i] > 0) {
          cur.append(PS[i]);
          stack.offerFirst(PS[i]);
          remain[i]--;
          DFS(cur, stack, result, remain, targetLength);
          cur.deleteCharAt(cur.length() - 1);
          stack.pollFirst();
          remain[i]++;
        }
      } else {
        if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
          cur.append(PS[i]);
          stack.pollFirst();
          remain[i]--;
          DFS(cur, stack, result, remain, targetLength);
          cur.deleteCharAt(cur.length() - 1);
          stack.offerFirst(PS[i - 1]);
          remain[i]++;
        }
      }
    }
  }
}
