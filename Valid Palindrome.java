// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.
//
// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.
// For the purpose of this problem, we define empty string as valid palindrome.

public class Solution {
  public boolean isPalindrome(String s) {
    if (s == null) {
      return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      char head = s.charAt(left);
      char tail = s.charAt(right);
      if (!Character.isLetterOrDigit(head)) {
        left++;
      } else if (!Character.isLetterOrDigit(tail)) {
        right--;
      } else if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
        return false;
      } else {
        left++;
        right--;
      }
    }
    return true;
  }
}
