// Find the longest common substring of two given strings.
//
// Assumptions
// The two given strings are not null
//
// Examples
// S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”

public class Solution {
  public String longestCommon(String s, String t) {
    // Dynamic Programming
    char[] sa = s.toCharArray();
    char[] ta = t.toCharArray();
    // common[i][j] represents the longest common substring from head to sa[i] and ta[j]
    int[][] common = new int[sa.length][ta.length];
    // Record the longest substring's length
    int longest = 0;
    // Record the longest substring's start position in s
    int start = 0;
    for (int i = 0; i < sa.length; i++) {
      for (int j = 0; j < ta.length; j++) {
        if (sa[i] == ta[j]) {
          if (i == 0 || j == 0) {
            common[i][j] = 1;
          } else {
            common[i][j] = common[i - 1][j - 1] + 1;
          }
          if (common[i][j] > longest) {
            longest = common[i][j];
            start = i - longest + 1;
          }
        }
      }
    }
    return s.substring(start, start + longest);
  }
}
