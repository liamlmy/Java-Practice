// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
// Example 1:
// Input: [3,2,1,5,6,4] and k = 2
// Output: 5
//
// Example 2:
// Input: [3,2,3,1,2,4,5,5,6] and k = 4
// Output: 4
//
// Note:
// You may assume k is always valid, 1 ≤ k ≤ array's length.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
    	while (left <= right) {
    		int idx = partition(nums, left, right);
    		if (idx == k) {
    			return nums[idx];
    		} else if (idx > k) {
    			right = idx - 1;
    		} else {
    			left = idx + 1;
    		}
    	}
    	return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
    	int pivot = findPivot(nums, left, right);
    	int i = left;
    	int j = right - 1;
    	while (i <= j) {
    		if (nums[i] >= pivot) {
    			swap(nums, i, j);
    			j--;
    		} else if (nums[j] < pivot) {
    			swap(nums, i, j);
    			i++;
    		} else {
    			i++;
    			j--;
    		}
    	}
    	swap(nums, i, right);
    	return i;
    }

    private int findPivot(int[] nums, int left, int right) {
    	int pivotIndex = left + (int)((right - left) * Math.random());
    	swap(nums, pivotIndex, right);
    	return nums[right];
    }

    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}
