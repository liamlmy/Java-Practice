// Determine the number of bits that are different for two given integers.
//
// Examples
// 5(“0101”) and 8(“1000”) has 3 different bits

public class Solution {
  public int diffBits(int a, int b) {
    int count = 0;
    // Use exclusive or to find out how many different bits (1s)
    a ^= b;
    while (a != 0) {
      count += a & 1;
      a >>>= 1;
    }
    return count;
  }
}
