// Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
//
// Assumptions
// A is not null
//
// Examples
// Input: A = {5, 2, 6, 3, 4, 7, 5}
// Output: 4
// Because [2, 3, 4, 5] is the longest ascending subsequence.

/*
 * Method 1: Dynamic Programming - O(n^2)
 */
/*
public class Solution {
  public int longest(int[] array) {
    // Corner check
    if (array.length == 0) {
      return 0;
    }
    // Dynamic Programming
    // dp[i] = the length of longest ascending subsequence ending at index i.
    int[] dp = new int[array.length];
    // Record the length of longest subsequence so far.
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      // Initialize dp[i] as 1, since the shortest one has length 1 (just array[i] itself).
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        // Only when array[j] < array[i], it is possible to use the longest ascending subsequence ending at index j
        // and array[i] to form a new ascending subsequence.
        if (array[j] < array[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
      // Possibly update the global longest one.
      result = Math.max(result, dp[i]);
    }
    return result;
  }
}
*/

/*
 * Method 2: Dynamic Programming - O(nlogn)
 */
public class Solution {
  public int longest(int[] array) {
    // Corner check
    if (array.length == 0) {
      return 0;
    }
    // Dynamic Programming
    // tbl[i]: the smallest ending value of all the ascending subsequences with length i.
    int[] tbl = new int[array.length + 1];
    // At the very beginning, the longest ascending subsequence we have has length 1 (array[0] itself).
    int result = 1;
    // Initialization: at the very beginning, we have a ascending subsequence, ending value as array[0].
    // While we traversing the array, we will update existing tbl[i] and find new longer ascending subsequence.
    tbl[1] = array[0];
    for (int i = 1; i < array.length; i++) {
      // tbl is guaranteed to be in ascending order - the key point.
      // From tbl, find the best(longest) ascending subsequence, which can concatenate array[i] to form a new one.
      // This new longer ascending subsequence.
      int index = find(tbl, 1, result, array[i]);
      // Two cases:
      // 1. we can possibly form a longer ascending subsequence than whatever we have before, if array[i] is larger than
      // all values in tbl.
      // 2. we may update tbl[index + 1] because we find a better ascending subsequence with length index + 1 (the ending
      // value is smaller or equal).
      if (index == result) {
        tbl[++result] = array[i];
      } else {
        tbl[index + 1] = array[i];
      }
    }
    return result;
  }
  
  // Find the index of the "largest smaller value" to target in the tbl,
  // tbl is sorted in ascending order.
  private int find(int[] tbl, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (tbl[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }
}

/*
 * Method 3: same to method 2
 */
public class Solution {
  public int longest(int[] array) {
    // Corner check
    if (array.length == 0) {
      return 0;
    }
    // Dynamic Programming
    int[] minLast = new int[array.length + 1];
    for (int i = 0; i < minLast.length; i++) {
      if (i == 0) {
        minLast[i] = Integer.MIN_VALUE;
      } else {
        minLast[i] = Integer.MAX_VALUE;
      }
    }
    for (int i = 0; i < array.length; i++) {
      // Find the smallest index that minLast[index] >= array[i]
      int index = binarySearch(minLast, array[i]);
      minLast[index] = array[i];
    }
    for (int i = minLast.length - 1; i > 0; i--) {
      if (minLast[i] != Integer.MAX_VALUE) {
        return i;
      }
    }
    return 0;
  }
  
  private int binarySearch(int[] minLast, int num) {
		int start = 0, end = minLast.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (minLast[mid] < num) {
				start = mid + 1;
			} else if (minLast[mid] > num) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (start == 0) {
			return 1;
		} else if (minLast[start] >= num) {
			return start;
		} else {
			return end;
		}
	}
}

/*
 * Method 4: same to method 2
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int index = findSmallestLarger(dp, 0, result, nums[i]);
            if (index == result) {
                dp[result++] = nums[i];
            } else {
                dp[index] = nums[i];
            }
        }
        return result;
    }

    private int findSmallestLarger(int[] dp, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
