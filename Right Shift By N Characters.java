// Right shift a given string by n characters.
//
// Assumptions
// The given string is not null.
// n >= 0.

public class Solution {
  public String rightShift(String input, int n) {
    // Corner check
    if (input.length() <= 1) {
      return input;
    }
    
    // Right shift
    char[] string = input.toCharArray();
    n = n % string.length;                // Make sure that the how many characters we actually need to shift
    /*
     * This is a conclusion mathmatically
     * In order to right shift a string by n characters, we first reverse the last n characters of the string
     * Then we reverse the remaining characters
     * Lastly, we reverse the whole string
     */
    reverse(string, string.length - n, string.length - 1);
    reverse(string, 0, string.length - n - 1);
    reverse(string, 0, string.length - 1);
    return new String(string);
  }
  
  /*
   * This function reverse a char array in the given scope
   */
  private void reverse(char[] string, int i, int j) {
    while (i < j) {
      char temp = string[i];
      string[i] = string[j];
      string[j] = temp;
      i++;
      j--;
    }
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n)
