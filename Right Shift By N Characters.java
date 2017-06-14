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
    n = n % string.length;
    reverse(string, string.length - n, string.length - 1);
    reverse(string, 0, string.length - n - 1);
    reverse(string, 0, string.length - 1);
    return new String(string);
  }
  
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
