// Implement wildcard pattern matching with support for '?' and '*'.
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false

/* 
 * Method 1: use two pointers
 */
/*
public class Solution {
  public boolean isMatch(String s, String p) {
    int pIndex = 0;
    int sIndex = 0;
    int start = -1;
    int match = 0;
    while (sIndex < s.length()) {
      if (pIndex < p.length() && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '?')) {
        // advancing both pointers
        pIndex++;
        sIndex++;
      } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
        // advancing pIndex only
        start = pIndex;
        match = sIndex;
        pIndex++;
      } else if (start != -1) {
        // advancing sIndex only
        pIndex = start + 1;
        match++;
        sIndex = match;
      } else {
        // return false
        return false;
      }
    }
    while (pIndex < p.length() && p.charAt(pIndex) == '*') {
      pIndex++;
    }
    return pIndex == p.length();
  }
}

// Time complexity: O(n + m)
// Space complexity: O(1)
*/

/*
 * Method 2: DP
 */
public class Solution {
  public boolean isMatch(String s, String p) {
    boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
    // Base case
    match[s.length()][p.length()] = true;
    for (int i = p.length() - 1; i >= 0; i--) {
      if (p.charAt(i) != '*') {
        break;
      } else {
        match[s.length()][i] = true;
      }
    }
    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = p.length() - 1; j >= 0; j--) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
          match[i][j] = match[i + 1][j + 1];
        } else if (p.charAt(j) == '*') {
          match[i][j] = match[i + 1][j] || match[i][j + 1];
        } else {
          match[i][j] = false;
        }
      }
    }
    return match[0][0];
  }
}

// Time complexity: O(n + m)
// Space complexity: O(n * m)
