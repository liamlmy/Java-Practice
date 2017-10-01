// A message containing letters from A-Z is being encoded to numbers using the following mapping:
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.
//
// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
// The number of ways decoding "12" is 2.

public class Solution {
  public int numDecodings(String s) {
    // Corner check
    if (s == null || s.length() == 0) {
      return 0;
    }
    // DP
    int[] M = new int[s.length() + 1];
    // Base case
    M[s.length()] = 1;
    M[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
    // Induction rule
    for (int i = s.length() - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        continue;
      } else {
        int num = Integer.parseInt(s.substring(i, i + 2));
        M[i] = num <= 26 ? M[i + 1] + M[i + 2] : M[i + 1];
      }
    }
    return M[0];
  }
}
