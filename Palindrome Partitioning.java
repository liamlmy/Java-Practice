// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return all possible palindrome partitioning of s.
// For example, given s = "aab",
// Return
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]

public class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        List<List<String>>[] result = new List[s.length() + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    String str = s.substring(j, i + 1);
                    for (List<String> r : result[j]) {
                        List<String> cur = new ArrayList<String>(r);
                        cur.add(str);
                        result[i + 1].add(cur);
                    }
                }
            }
        }
        return result[result.length - 1];
    }
}
