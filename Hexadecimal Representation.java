// Generate the hexadecimal representation for a given non-negative integer number as a string.
// The hex representation should start with "0x".
// There should not be extra zeros on the left side.
//
// Examples
// 0's hex representation is "0x0"
// 255's hex representation is "0xFF"

public class Solution {
  public String hex(int number) {
    String prefix = "0x";
    if (number == 0) {
      return prefix + "0";
    }
    StringBuilder sb = new StringBuilder();
    while (number > 0) {
      int rem = number % 16;
      if (rem < 10) {
        sb.append((char) (rem + '0'));
      } else {
        sb.append((char) (rem - 10 + 'A'));
      }
      number >>>= 4;
    }
    return prefix + sb.reverse().toString();  // reverse it at last, so in all complexity is O(n)
  }
}

// Time complexity: O(n)
// Space complexity: O(1)
