// Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
//
// Assumptions
// The given array is not null, and N >= 1
//
// Examples
// A = {2, 1, 4}, the missing number is 3
// A = {1, 2, 3}, the missing number is 4
// A = {}, the missing number is 1

/*
 * Method 1: Use HashSet
 */
/*
public class Solution {
  public int missing(int[] array) {
    Set<Integer> set = new HashSet<Integer>();
    int n = array.length + 1;
    for (int number : array) {
      set.add(number);
    }
    for (int i = 1; i < n; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return n;
  }
}
*/

/*
 * Method 2: Use sum
 */
/*
public class Solution {
  public int missing(int[] array) {
    int start = 0;
    int end = array.length + 1;
    long target = (start + end) * (end - start + 1) / 2;
    long sum = 0L;
    for (int number : array) {
      sum += number;
    }
    return (int) (target - sum);
  }
}
*/

/*
 * Method 3: Bit operation - O(n)
 */
/*
public class Solution {
  public int missing(int[] array) {
    int n = array.length + 1;
    int xor = 0;
    for (int i = 1; i <= n; i++) {
      xor ^= i;
    }
    // After this operation, all the numbers from 1 to n are pair xor'ed except for the missing number.
    // Since x ^ x = 0, the remaining number is the result.
    for (int number : array) {
      xor ^= number;
    }
    return xor;
  }
}
*/

/*
 * Method 4: swap to the original position - O(n)
 */
public class Solution {
  public int missing(int[] array) {
    // Try to swap numbers to its corresponding position.
    // For the number of x, the corresponding position is x - 1.
    for (int i = 0; i < array.length; i++) {
      while (array[i] != i + 1 && array[i] != array.length + 1) {
        // While array[i] is not i + 1, swap array[i] to its correct position if it is possible.
        swap(array, i, array[i] - 1);
      }
    }
    // If the missing number is in the range of 1 to n - 1,
    // then we can find the missing number by checking the index i where array[i] != i + 1.
    for (int i = 0; i < array.length; i++) {
      if (array[i] != i + 1) {
        return i + 1;
      }
    }
    // If all numbers in range 1 to n - 1 are in correct position,
    // the missing number is n.
    return array.length + 1;
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
