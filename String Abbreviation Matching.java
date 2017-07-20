// Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation,
// return if the string matches the abbreviation.
//
// Assumptions:
// The original string only contains alphabetic characters.
// Both input and pattern are not null.
//
// Examples:
// pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.

/*
 * Method 1: Recursion way
 */
public class Solution{
  public boolean match(String input, String pattern) {
    return match(input, pattern, 0, 0);
  }
  
  private boolean match(String input, String pattern, int i, int j) {
    // Base case
    // if the whole input string and pattern string are matched, return true
    if (i == input.length() && j == pattern.length()) {
      return true;
    }
    // if we run out of the input and pattern, there is still some characters left for the other one,
    // return false
    if (i >= input.length() || j >= pattern.length()) {
      return false;
    }
    
    // Recursion rule
    // case 1: if the current character is not a digit
    if (pattern.charAt(j) < '0' || pattern.charAt(j) > '9') {
      if (pattern.charAt(j) == input.charAt(i)) {
        return match(input, pattern, i + 1, j + 1);
      }
      return false;
    }
    // case 2: if the current character is a digit
    // Find out the total number
    int count = 0;
    while (j < pattern.length() && pattern.charAt(j) >= '0' && pattern.charAt(j) <= '9') {
      count = count * 10 + (pattern.charAt(j) - '0');
      j++;
    }
    return match(input, pattern, i + count, j);
  }
}

/*
 * Method 2: Iteration way
 */
/*
public class Solution {
  public boolean match(String input, String pattern) {
    int i = 0;
    int j = 0;
    while (i < input.length() && j < pattern.length()) {
      if (pattern.charAt(j) < '0' || pattern.charAt(j) > '9') {
        if (pattern.charAt(j) != input.charAt(i)) {
          return false;
        }
        i++;
        j++;
      } else {
        int count = 0;
        while (j < pattern.length() && pattern.charAt(j) >= '0' && pattern.charAt(j) <= '9') {
          count = count * 10 + (pattern.charAt(j) - '0');
          j++;
        }
        i += count;
      }
    }
    return i == input.length() && j == pattern.length();
  }
}
*/
