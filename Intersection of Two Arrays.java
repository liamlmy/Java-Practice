// Given two arrays, write a function to compute their intersection.
//
// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
// Note:
// Each element in the result must be unique.
// The result can be in any order.

/*
 * Method 1: Use hashset
 */
public class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> numSet = new HashSet<>();
    Set<Integer> intersect = new HashSet<>();
    for (int num : nums1) {
      numSet.add(num);
    }
    for (int num : nums2) {
      if (numSet.contains(num)) {
        intersect.add(num);
      }
    }
    int[] result = new int[intersect.size()];
    int index = 0;
    for (int num : intersect) {
      result[index++] = num;
    }
    return result;
  }
}

// Time complexity: O(n) = O(n + m)
// Space complexity: O(n) = O(n)

/*
 * Method 2: sort and use two pointers
 */
public class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0;
    int j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        set.add(nums1[i]);
        i++;
        j++;
      }
    }
    int[] result = new int[set.size()];
    int k = 0;
    for (Integer num : set) {
      result[k++] = num;
    }
    return result;
  }
}

// Time complexity: O(n) = O(nlogn + mlogm)
// Space complexity: O(n) = O(n)
