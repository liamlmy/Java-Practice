// Determine if the characters of a given string are all unique.
//
// Assumptions
// We are using ASCII charset, the value of valid characters are from 0 to 255
// The given string is not null
//
// Examples
// all the characters in "abA+\8" are unique
// "abA+\a88" contains duplicate characters

public class Solution {
  public boolean allUnique(String word) {
    int[] vec = new int[8];
    char[] array = word.toCharArray();
    for (char c : array) {
      if ((vec[c / 32] >>> (c % 32) & 1) == 1) {
        return false;
      }
      vec[c / 32] |= 1 << (c % 32);
    }
    return true;
  }
}

// Time complexity: O(n)
// Space complexity: O(n)
