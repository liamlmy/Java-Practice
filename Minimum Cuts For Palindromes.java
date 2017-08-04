// Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition
// is a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string.
//
// Assumptions
// The given string is not null
//
// Examples
// “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.
// The minimum number of cuts needed is 3.

public class Solution {
  public int minCuts(String input) {
    // Corner check
    if (input.length() <= 1) {
      return 0;
    }
    // Dynamic Programming
    char[] array = input.toCharArray();
    int length = array.length;
    // isP[i][j] represents if array[i - 1] to array[j - 1[ is palidrome
    boolean[][] isP = new boolean[length + 1][length + 1];
    // minCuts[i] represents the min cuts from 0 to i - 1
    int[] minCuts = new int[length + 1];
    for (int end = 1; end <= length; end++) {
      minCuts[end] = end;         // Initialize the minCuts
      for (int start = end; start >= 1; start--) {
        if (array[end - 1] == array[start - 1]) {
          isP[start][end] = end - start < 2 || isP[start + 1][end - 1];
        }
        if (isP[start][end]) {
          minCuts[end] = Math.min(minCuts[end], minCuts[start - 1] + 1);
        }
      }
    }
    return minCuts[length] - 1;
  }
}
