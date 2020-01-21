// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
// This is case sensitive, for example "Aa" is not considered a palindrome here.
//
// Note:
// Assume the length of given string will not exceed 1,010.
//
// Example:
// Input:
// "abccccdd"
// Output:
// 7
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
        }
        if (ans < s.length()) { // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
            ans++;
        }
        return ans;
    }
}
