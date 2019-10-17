// Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
//
// Example 1:
// Input: 5
// Output: True
// Explanation: 1 * 1 + 2 * 2 = 5
//
// Example 2:
// Input: 3
// Output: False

class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
        	int cur = a * a + b * b;
        	if (cur == c) {
        		return True;
        	} else if (cur > target) {
        		b--;
        	} else {
        		a++;
        	}
        }
        return False;
    }
}
