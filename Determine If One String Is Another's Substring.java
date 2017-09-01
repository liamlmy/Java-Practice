// Determine if a small string is a substring of another large string.
// Return the index of the first occurrence of the small string in the large string.
// Return -1 if the small string is not a substring of the large string.
//
// Assumptions
// Both large and small are not null
// If small is empty string, return 0
//
// Examples
// “ab” is a substring of “bcabc”, return 2
// “bcd” is not a substring of “bcabc”, return -1
// "" is substring of "abc", return 0

/*
 * Method 1: naive solution
 */
/*
public class Solution {
  public int strstr(String large, String small) {
    // Corner case
    if (small.length() > large.length()) {
      return -1;
    }
    if (small.length() == 0) {
      return 0;
    }
    // check
    char[] array = large.toCharArray();
    for (int i = 0; i <= array.length - small.length(); i++) {
      if (isSubString(array, small, i)) {
        return i;
      }
    }
    return -1;
  }
  
  private boolean isSubString(char[] array, String small, int i) {
    for (int j = 0; j < small.length(); j++) {
      if (small.charAt(j) != array[i + j]) {
        return false;
      }
    }
    return true;
  }
}

// Time complexity: O(n) = O(n + m)
// Space complexity: O(n) = O(1);
*/

/*
 * Method 2: rabin karp solution
 */
