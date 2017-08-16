// Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.
//
// Assumptions
// The given array is not null and has length of at least 2.
//
// Examples
// A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]
// A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    // key: number, value: list of possible indices.
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < array.length; i++) {
      List<Integer> indices = map.get(target - array[i]);
      // if target - array[i] is in the map, we can get all the pairs(j, i), with i as the larger index.
      if (indices != null) {
        for (int j : indices) {
          result.add(Arrays.asList(j, i));
        }
      }
      if (!map.containsKey(array[i])) {
        map.put(array[i], new ArrayList<Integer>());
      }
      map.get(array[i]).add(i);
    }
    return result;
  }
}
