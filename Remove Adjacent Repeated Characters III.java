// Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters.
// The characters in the string are sorted in ascending order.
//
// Assumptions
// Try to do it in place.
//
// Examples
// “aaaabbbc” is transferred to “c”
// Corner Cases
// If the given string is null, we do not need to do anything.

public class Solution {
  public String deDup(String input) {
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    int fast = 0;
    int slow = 0;
    while (fast < array.length) {
      char candidate = array[fast];
      int count = 0;
      while (fast < input.length() && array[fast] == candidate) {
        fast++;
        count++;
      }
      if (count == 1) {
        array[slow++] = candidate;
      }
    }
    return new String(array, 0, slow);
  }
}
