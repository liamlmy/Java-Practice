// Given three strings A, B and C. Determine if C can be created by merging A and B in a way that maintains
// the relative order of the characters in A and B.
//
// Assumptions
// none of A, B, C is null
//
// Examples
// C = "abcde", A = "acd", B = "be", return true
// C = "abcde", A = "adc", B = "be", return false

public class Solution {
  public boolean canMerge(String a, String b, String c) {
    int alen = a.length();
    int blen = b.length();
    int clen = c.length();
    if (alen + blen != clen) {
      return false;
    }
    // A common trick is to use i to represent ith character in a,
    // the 1st character is actually a.charAt(0).
    // The benefit is we can eliminate some base cases.
    boolean[][] canMerge = new boolean[alen + 1][blen + 1];
    for (int i = 0; i <= alen; i++) {
      for (int j = 0; j <= blen; j++) {
        // Base case
        if (i == 0 && j == 0) {
          canMerge[i][j] = true;
        }
        // Two possible ways of matching the characters in c.
        if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
          canMerge[i][j] |= canMerge[i - 1][j];
        }
        if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
          canMerge[i][j] |= canMerge[i][j - 1];
        }
      }
    }
    return canMerge[alen][blen];
  }
}
