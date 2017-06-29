// Determine if a given integer is power of 2.
//
// Examples
// 16 is power of 2 (2 ^ 4)
// 3 is not
// 0 is not
// -1 is not

/*
 * Method 1
 */
public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Corner check
    if (number <= 0) {
      return false;
    }
    
    // Ignore all the trailing 0s
    while ((number & 1) == 0) {
      number >>>= 1;
    }
    // Check if the number is 1 at the end
    return number == 1;
  }
}

/*
 * Method 2
 */
/*
public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Corner check
    if (number <= 0) {
      return false;
    }
    
    // Count the number of 1s
    int count = 0;
    while (number > 0) {
      count += (number & 1);
      number >>>= 1;
    }
    return count == 1;
  }
}
*/

/*
 * Method 3
 */
/*
public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Use the trick that number & (number - 1) will remove the rightmost 1
    return number > 0 && (number & (number - 1)) == 0;
  }
}
*/
