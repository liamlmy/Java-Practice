// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
// Given "abcabcbb", the answer is "abc", which the length is 3.
// Given "bbbbb", the answer is "b", with the length of 1.
// Given "pwwkew", the answer is "wke", with the length of 3.
// Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    // Corner check
		if (s == null || s.length() == 0) {
			return 0;
		}
		// Sliding window
		int result = 1;
		int cur = 1;
		Set<Character> set = new HashSet<>();
		int start = 0;
		set.add(s.charAt(0));
		// Induction rule
		for (int i = 1; i < s.length(); i++) {
			if (!set.contains(s.charAt(i))) {
				cur = i - start + 1;
				result = Math.max(result, cur);
				set.add(s.charAt(i));
			} else {
				while (set.contains(s.charAt(i))) {
					set.remove(s.charAt(start));
					start++;
				}
				set.add(s.charAt(i));
			}
		}
		return result;
  }
}
