// Given N pairs of parentheses “()”, return a list with all the valid permutations.
//
// Assumptions
// N >= 0
//
// Examples
// N = 1, all valid permutations are ["()"]
// N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
// N = 0, all valid permutations are [""]

public class Solution {
  public List<String> validParentheses(int n) {
    List<String> result = new ArrayList<String>();
    StringBuilder subSet = new StringBuilder();
    DFS(n, result, subSet, 0, 0);
    return result;
  }
  
  private void DFS(int n, List<String> result, StringBuilder subSet, int left, int right) {
    // Base case
    if (right == n && left == n) {
      result.add(subSet.toString());
      return;
    }
    // Recursion rule
    if (left < n) {
      subSet.append('(');
      DFS(n, result, subSet, left + 1, right);
      subSet.deleteCharAt(subSet.length() - 1);
    }
    if (right < left) {
      subSet.append(')');
      DFS(n, result, subSet, left, right + 1);
      subSet.deleteCharAt(subSet.length() - 1);
    }
  }
}
