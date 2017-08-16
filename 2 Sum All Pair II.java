// Find all pairs of elements in a given array that sum to the pair the given target number.
// Return all the distinct pairs of values.
//
// Assumptions
// The given array is not null and has length of at least 2
// The order of the values in the pair does not matter
//
// Examples
// A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]

/*
 * Method 1: sort the array and use two pointers
 */
/*
public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(array);         // Quick sort, merge sort
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      if (left > 0 && array[left] == array[left - 1]) {
        left++;
        continue;
      }
      int sum = array[left] + array[right];
      if (sum == target) {
        result.add(Arrays.asList(array[left], array[right]));
        left++;
        right--;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return result;
  }
}
*/

/*
 * Method 2: use hashset
 */
public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int num : array) {
      Integer count = map.get(num);
      if (num * 2 == target && count != null && count == 1) {
        result.add(Arrays.asList(num, num));
      } else if (map.containsKey(target - num) && count == null) {
        result.add(Arrays.asList(target - num, num));
      }
      if (count == null) {
        map.put(num, 1);
      } else {
        map.put(num, count + 1);
      }
    }
    return result;
  }
}
