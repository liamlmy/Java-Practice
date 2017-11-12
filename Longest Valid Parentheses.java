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
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerFirst(i);
            } else {
                if (!stack.isEmpty()) {
                	if (s.charAt(stack.peekFirst()) == '(') {
                		stack.pollFirst();
                	} else {
                		stack.offerFirst(i);
                	}
                } else {
                	stack.offerFirst(i);
                }
            }
        }

        if (stack.isEmpty()) {
            return s.length();
        }
        int end = s.length();
        int start = 0;
        while (!stack.isEmpty()) {
            start = stack.pollFirst();
            max = Math.max(max, end - start - 1);
            end = start;
        }
        max = Math.max(max, end);
        return max;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
