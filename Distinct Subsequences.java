// Given a string S and a string T, count the number of distinct subsequences of S which equals T.
// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
// the characters without disturbing the relative positions of the remaining characters.
// (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
// Here is an example:
// S = "rabbbit", T = "rabbit"
// Return 3.

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        // Any string have one method to become a empty string
        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }
        // if the current character in S doesn't equal to current character T, 
        // then we have the same number of distinct subsequences as we had without the new character.
        // if the current character in S equal to the current character T, then the distinct number of subsequences: 
        // the number we had before plus the distinct number of subsequences we had with less longer T and less longer S.
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    // for the s.charAt(j), we can use it and we can also not use it
                    // so the dp[i][j] = dp[i - 1][j - 1] (use it) + dp[i][j - 1] (not use it)
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
