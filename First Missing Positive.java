// Given an unsorted integer array, find the first missing positive integer.
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
// Your algorithm should run in O(n) time and uses constant space.

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 1;
        }
        int k = order(nums) + 1;
        int temp = 0;
        int firstMissingIndex = k;
        for (int i = 0; i < k; i++) {
            temp = Math.abs(nums[i]);
            if (temp <= k) {
                nums[temp - 1] = nums[temp - 1] < 0 ? nums[temp - 1] : -nums[temp - 1];
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                firstMissingIndex = i;
                break;
            }
        }
        return firstMissingIndex + 1;
    }
    
    private int order(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                index++;
                swap(nums, i, index);
            }
        }
        return index;
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
