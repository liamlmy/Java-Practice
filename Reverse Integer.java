// Given a 32-bit signed integer, reverse digits of an integer.
// Example 1:
// Input: 123
// Output:  321
// Example 2:
// Input: -123
// Output: -321
// Example 3:
// Input: 120
// Output: 21
// Note:
// Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

public class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean flag = true;
        if (x < 0) {
            flag = false;
            x = -x;
        }
        while (x != 0) {
            int cur = x % 10;
            int newResult = result * 10 + cur;
            if ((newResult - cur) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        if (flag) {
            return result;
        } else {
            return -result;
        }
    }
}
