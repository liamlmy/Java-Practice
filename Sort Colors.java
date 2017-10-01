// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
// with the colors in the order red, white and blue.
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

public class Solution {
  public void sortColors(int[] nums) {
    int i = 0;
    int j = 0;
    int k = nums.length - 1;
    while (j <= k) {
      if (nums[j] == 0) {
        swap(nums, i, j);
        i++;
        j++;
      } else if (nums[j] == 1) {
        j++;
      } else {
        swap(nums, j, k);
        k--;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
