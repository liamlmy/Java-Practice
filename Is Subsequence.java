// Given a string s and a string t, check if s is subsequence of t.
// You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
//
// Example 1:
// s = "abc", t = "ahbgdc"
// Return true.
//
// Example 2:
// s = "axc", t = "ahbgdc"
// Return false.
//
// Follow up:
// If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

class Solution {
    public boolean isSubsequence(String s, String t) {
    	//pointers for both strings
    	int sp = 0, tp = 0;
    	//while there are chars in both strings
    	while (sp < s.length() && tp < t.length()) {
      		//compare chars, increment pointer for t in all cases
      		if (s.charAt(sp) == t.charAt(tp++)) {
        		//increment pointer for s in case there is match
        		sp++;
      		}
    	}
    	//only if we scanned all s chars we return true - meaning all chars
    	//from s has been met
    	return sp == s.length();
  	}
}
