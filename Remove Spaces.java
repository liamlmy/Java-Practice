// Given a string, remove all leading/trailing/duplicated empty spaces.
//
// Assumptions:
// The given string is not null.
//
// Examples:
// “  a” --> “a”
// “   I     love MTV ” --> “I love MTV”

public class Solution {
  public String removeSpaces(String input) {
    char[] array = input.toCharArray();
    int i = 0;
    int j = 0;
    while (i < array.length) {
      // When we would ignore the current space character:
      // 1. we ignore all the space characters followed by another space character,
      // so that if there are another consecutive space characters, only the first one will be remained.
      // 2. we ignore also the space character if it is the first character of the input string.
      if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
        i++;
      } else {
        array[j] = array[i];
        j++;
        i++;
      }
    }
    // Post-processing: it is possible we still have one trailing space character at the end.
    if (j > 0 && array[j - 1] == ' ') {
      return new String(array, 0, j - 1);
    }
    return new String(array, 0, j);
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(1)
