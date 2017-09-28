// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example:
// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// Example:
// Input: "cbbd"
// Output: "bb"

/*
 * Method 1: DP
 */
/*
public class Solution {
  public String longestPalindrome(String s) {
		// Corner check
		if (s == null || s.length() <= 1) {
			return s;
		}
		// DP
		boolean[][] M = new boolean[s.length()][s.length()];
		Cell result = new Cell(0, 0);
		for (int j = 0; j < M.length; j++) {
			for (int i = j; i >= 0; i--) {
				if (i == j) {
					M[i][j] = true;
					if (j - i + 1 > result.len) {
						result = new Cell(i, j);
					}
				} else if (j == i + 1) {
					if (s.charAt(i) == s.charAt(j)) {
						M[i][j] = true;
						if (j - i + 1 > result.len) {
							result = new Cell(i, j);
						}
					}
				} else {
					M[i][j] = M[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
					if (M[i][j] && j - i + 1 > result.len) {
						result = new Cell(i, j);
					}
				}
			}
		}
		return s.substring(result.i, result.j + 1);
	}

	static class Cell {
		int i;
		int j;
		int len;

		public Cell(int i, int j) {
			this.i = i;
			this.j = j;
			this.len = j - i + 1;
		}
	}
}

// Time complexity: O(n ^ 2)
// Space complexity: O(n ^ 2)
*/

/*
 * Method 2: Expand around center
 */
public class Solution {
  public String longestPalindrome(String s) {
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
  }
}

// Time complexity: O(n ^ 2)
// Space complexity: O(1)
