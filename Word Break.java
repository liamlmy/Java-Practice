// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
// determine if s can be segmented into a space-separated sequence of one or more dictionary words.
// You may assume the dictionary does not contain duplicate words.
//
// For example, given
// s = "leetcode",
// dict = ["leet", "code"].
//
// Return true because "leetcode" can be segmented as "leet code".
//
// UPDATE (2017/1/4):
// The wordDict parameter had been changed to a list of strings (instead of a set of strings).
// Please reload the code definition to get the latest changes.

public class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = getDict(wordDict);
        boolean[] M = new boolean[s.length() + 1];
        // Base case
        M[0] = true;
        // Induction rule
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] && dict.contains(s.substring(j, i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[s.length()];
    }

	private Set<String> getDict(List<String> wordList) {
		Set<String> dict = new HashSet<>();
		for (String str : wordList) {
			dict.add(str);
		}
		return dict;
	}
}
