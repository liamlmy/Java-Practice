// Reverse the words in a sentence.
//
// Assumptions
// Words are separated by single space
// There are no heading or tailing white spaces
//
// Examples
// “I love Google” → “Google love I”
//
// Corner Cases
// If the given string is null, we do not need to do anything.

public class Solution {
  public String reverseWords(String input) {
    char[] array = input.toCharArray();
    // Step 1: reverse the whole array.
    reverse(array, 0, array.length - 1);
    int start = 0;
    // Step 2: reverse each of the word.
    for (int i = 0; i < array.length; i++) {
      // The start index of a word.
      if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
        start = i;
      }
      // The end index of a word.
      if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
        reverse(array, start, i);
      }
    }
    return new String(array);
  }
  
  private void reverse(char[] array, int i, int j) {
    while (i < j) {
      char temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      i++;
      j--;
    }
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n) --> char array
