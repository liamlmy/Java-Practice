// Reverse a given string.
//
// Assumptions
// The given string is not null.

public class Solution {
  public String reverse(String input) {
    char[] array = input.toCharArray();
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      char temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      i++;
      j--;
    }
    return new String(array);
  }
}

// Time complexity: O(n)
// Space complexity: O(n)
