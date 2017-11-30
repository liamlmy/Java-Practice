// Implement int sqrt(int x).
// Compute and return the square root of x.
// x is guaranteed to be a non-negative integer.
//
// Example 1:
// Input: 4
// Output: 2
//
// Example 2:
// Input: 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we want to return an integer,
// the decimal part will be truncated.

/*
 * Method 1: Binary Search
 */
public class Solution {
  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    int left = 1;
    int right = Integer.MAX_VALUE;
    while (true) {
      int mid = left + (right - left) / 2;
      if (mid > x / mid) {
        right = mid - 1;
      } else {
        if (mid + 1 > x / (mid + 1)) {
          return mid;
        }
        left = mid + 1;
      }
    }
  }
}

/*
 * Method 2: NewTon
 */
public class Solution {
  public double mySqrt(double x) {
    if (x == 0.0) {
      return 0.0;
    }
    double last = 0.0;
    double result = 1.0;
    while (result != last) {
      last = result;
      result = (result + x / result) / 2.0;
    }
    return result;
  }
}
