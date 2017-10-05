// Given an array of integers, every element appears twice except for one. Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

/*
 * Method 1
 */
/*
public class Solution {
  public int singleNumber(int[] nums) {
    if (nums.length < 2) {
      return nums[0];
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i += 2) {
      if (nums[i] != nums[i + 1]) {
        return nums[i];
      }
    }
    return nums[nums.length - 1];
  }
}

// Time complexity: O(nlogn);
// Space complexity: O(1)
*/

/*
 *
 */
public class Solution {
  public int singleNumber(int[] nums) {
    int xor = nums[0];
    for (int i = 1; i < nums.length; i++) {
      xor ^= nums[i];
    }
    return xor;
  }
}

// Time complexity: O(n)
// Space complexity: O(1)
