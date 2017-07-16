// Repeatedly remove all adjacent, repeated characters in a given string from left to right.
// No adjacent characters should be identified in the final string.
//
// Examples
// "abbbaaccz" → "aaaccz" → "ccz" → "z"
// "aabccdc" → "bccdc" → "bdc"

public class Solution {
  public String deDup(String input) {
    // Corner chekc
    if (input == null || input.length() <= 1) {
      return input;
    }
    // Dedup the string
    // Instead of using a extra stack explicitly, we can actually reuse the left side of the original char[]
    // as the "stack", i is where the top of the stack is.
    int i = 0;
    int j = 1;
    char[] array = input.toCharArray();
    while (j < array.length) {
      // If the stack is empty (i == -1) or there is no duplicate chars,
      // we are able to push the character into the stack.
      if (i == -1 || array[i] != array[j]) {
        i++;
        array[i] = array[j];
      } else {
        // Otherwise, we need to pop the top character in the stack (i--) and ignore all the consecutive characters.
        i--;
        while (j < array.length - 1 && array[j] == array[j + 1]) {
          j++;
        }
      }
      j++;
    }
    return new String(array, 0, i + 1);
  }
}
