// Evaluate a to the power of b, assuming both a and b are integers and b is non-negative. 
// 
// Examples
// power(2, 0) = 1
// power(2, 3) = 8
// power(0, 10) = 0
// power(-2, 5) = -32
//
// Corner Cases
// What if the result is overflowed? We can assume the result will not be overflowed
// when we solve this problem on this online judge.

public class Solution {
  public long power(int a, int b) {
    // Base case
    if (a == 0) {
      return (long) 0;
    }
    if (b == 0) {
      return (long) 1;
    }
    // Recursion rule
    long temp = power(a, b / 2);      // In java, 3 / 2 = 1, -3 / 2 = -1
    return b % 2 == 0 ? temp * temp : temp * temp * a;
  }
}
