// 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)

public class Solution {
  public long maxProduct(int[] array) {
    int max1 = 0;
    int max2 = 0;
    int max3 = 0;
    int min1 = 0;
    int min2 = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != 0) {
        if (array[i] > max1) {
          max3 = max2;
          max2 = max1;
          max1 = array[i];
        } else if (array[i] > max2) {
          max3 = max2;
          max2 = array[i];
        } else if (array[i] > max3) {
          max3 = array[i];
        } else if (array[i] < min1) {
          min2 = min1;
          min1 = array[i];
        } else if (array[i] < min2) {
          min2 = array[i];
        }
      }
    }
    long result = Math.max(max1 * max2 * max3, max1 * min1 * min2);
    return result;
  }
}
