// Find the length of longest common subsequence of two given strings.
//
// Assumptions
// The two given strings are not null
//
// Examples
// S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.

public class Solution {
  public int longest(String s, String t) {
    // Dynamic Programming
    char[] sa = s.toCharArray();
    char[] ta = t.toCharArray();
    // Using trick of "add 1" index will make the base case easier to handle
    // e.g. all the 0th row and 0th column will be 0
    int[][] common = new int[sa.length + 1][ta.length + 1];
    for (int i = 1; i <= sa.length; i++) {
      for (int j = 1; j <= ta.length; j++) {
        if (sa[i] == ta[j]) {
          common[i][j] = common[i - 1][j - 1] + 1;
        } else {
          common[i][j] = Math.max(common[i - 1][j], common[i][j - 1]);
        }
      }
    }
    return common[sa.length][ta.length];
  }
}
