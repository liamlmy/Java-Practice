// Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
// Your algorithm's runtime complexity must be in the order of O(log n).
// If the target is not found in the array, return [-1, -1].
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            result[0] = left;
        } else if (nums[right] == target) {
            result[0] = right;
        } else {
            return result;
        }
        left = nums[left] == target ? left : right;
        right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[right] == target) {
            result[1] = right;
        } else if (nums[left] == target) {
            result[1] = left;
        }
        return result;
    }
}
