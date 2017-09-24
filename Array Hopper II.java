// Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
// A[i] means the maximum jump distance from index i (you can only jump towards the end of the array).
// Determine the minimum number of jumps you need to reach the end of array.
// If you can not reach the end of the array, return -1.
//
// Assumptions
// The given array is not null and has length of at least 1.
//
// Examples
// {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
// {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.

/*
 * Method 1: DP
 */
public class Solution {
  public int minJump(int[] array) {
    int length = array.length;
    // minJump record the min number of jumps from 0 to each of the indices
    int[] minJump = new int[length];
    // Firstly, we are in index 0
    minJump[0] = 0;
    for (int i = 1; i < length; i++) {
      minJump[i] = -1;      // Initialized as unreachable
      for (int j = 0; j < i; j++) {
        if (minJump[j] != -1 && array[j] + j >= i) {
          if (minJump[i] == -1 || minJump[j] + 1 < minJump[i]) {
            minJump[i] = minJump[j] + 1;
          }
        }
      }
    }
    return minJump[length - 1];
  }
}

// Time complexity: O(n ^ 2)
// Space complexity: O(n)

/*
 * Method 2: Greedy solution
 */
??????????
