// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
// Given two integers x and y, calculate the Hamming distance.
//
// Note:
// 0 ≤ x, y < 231.

public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int last = 1 & xor;
            if (last == 1) {
                count++;
            }
            xor >>= 1;
        }
        return count;
    }
}
