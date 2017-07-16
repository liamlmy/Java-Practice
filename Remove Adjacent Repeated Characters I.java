// Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
//
// Assumptions
// Try to do it in place.
//
// Examples
// “aaaabbbc” is transferred to “abc”
//
// Corner Cases
// If the given string is null, we do not need to do anything.

public class Solution {
  public String deDup(String input) {
    // Corner check
    if (input == null || input.length() <= 1) {
      return input;
    }
    // Dedup the input string
    char[] array = input.toCharArray();
    int i = 0;
    int j = 1;
    while (j < array.length) {
      if (array[i] == array[j]) {
        j++;
      } else {
        i++;
        array[i] = array[j];
        j++;
      }
    }
    return new String(array, 0, i + 1);
  }
}
