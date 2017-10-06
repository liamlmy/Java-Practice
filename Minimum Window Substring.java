// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".
//
// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class Solution {
  public String minWindow(String s, String t) {
    // Corner check
    if (s == null || s.length() == 0 || t == null || t.length() == 0) {
      return "";
    }
    int[] sMap = new int[256];
    int[] tMap = new int[256];
    // Step 1: build the tMap
    for (int i = 0; i < t.length(); i++) {
      tMap[t.charAt(i)]++;
    }
    // Step 2: slide the window in s
    int i = 0;
    int j = 0;
    int found = 0;
    int length = Integer.MAX_VALUE;
    String result = "";
    while (j < s.length()) {
      if (found < t.length()) {
        if (tMap[s.charAt(j)] > 0) {
          sMap[s.charAt(j)]++;
          if (sMap[s.charAt(j)] <= tMap[s.charAt(j)]) {
            found++;
          }
        }
        j++;
      }
      while (found == t.length()) {
        if (j - i < length) {
          length = j - i;
          result = s.substring(i, j);
        }
        if (tMap[s.charAt(i)] > 0) {
          sMap[s.charAt(i)]--;
          if (sMap[s.charAt(i)] < tMap[s.charAt(i)]) {
            found--;
          }
        }
        i++;
      }
    }
    return result;
  }
}
