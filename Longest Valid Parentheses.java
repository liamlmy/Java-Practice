// Given a string containing just the characters '(' and ')',
// find the length of the longest valid (well-formed) parentheses substring.
// For "(()", the longest valid parentheses substring is "()", which has length = 2.
// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

/*
 * Method 1: DP
 */
/*
public class Solution {
    public int longestValidParentheses(String s) {
        // Corner check
        if (s == null || s.length() <= 1) {
            return 0;
        }
        // DP
        int[][] dp = new int[s.length()][s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isValid(s, j, i)) {
                    dp[i][j] = Math.max(dp[i][j], i - j + 1);
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
    
    private boolean isValid(String s, int start, int end) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '(') {
                stack.offerFirst(s.charAt(i));
            } else {
                if (stack.isEmpty() || stack.peekFirst() != '(') {
                    return false;
                } else {
                    stack.pollFirst();
                }
            }
        }
        return stack.isEmpty();
    }
}

// Time complexity: O(n^3)
// Space complexity: O(n^2)
*/

/*
 * Method 2: Use stack
 */
public class Solution {
  public int longestValidParentheses(String s) {
    Deque<Integer> stack = new LinkedList<>();
    int result = 0;
    stack.offerFirst(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.offerFirst(i);
      } else {
        stack.pollFirst();
        if (stack.isEmpty()) {
          stack.offerFirst(i);
        } else {
          result = Math.max(result, i - stack.peekFirst());
        }
      }
    }
    return result;
  }
}

// Time complexity: O(n)
// Space complexity: O(n)

/*
 * Method 3: Scan from right to left and from left to right
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left < right) {
                left = 0;
                right = 0;
            } else if (left == right) {
                result = Math.max(result, left + right);
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                result = Math.max(result, left + right);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return result;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
