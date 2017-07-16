// Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
//
// Assumptions
// In each of the two sorted arrays, there could be duplicate numbers.
// Both two arrays are not null.
//
// Examples
// A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]

/*
 * Method 1: two pointers
 */
/*
public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    List<Integer> result = new ArrayList<Integer>();
    int i = 0;
    int j = 0;
    while (i < A.size() && j < B.size()) {
      if (A.get(i) == B.get(j)) {
        result.add(A.get(i));
        i++;
        j++;
      } else if (A.get(i) > B.get(j)) {
        j++;
      } else {
        i++;
      }
    }
    return result;
  }
}
*/

/*
 * Method 2: use hashmap
 */
public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    List<Integer> result = new ArrayList<Integer>();
    Map<Integer, Integer> setA = new HashMap<Integer, Integer>();
    for (int number : A) {
      if (!setA.containsKey(number)) {
        setA.put(number, 1);
      } else {
        Integer value = setA.get(number);
        setA.put(number, value + 1);
      }
    }
    Map<Integer, Integer> setB = new HashMap<Integer, Integer>();
    for (int number : B) {
      if (!setB.containsKey(number)) {
        setB.put(number, 1);
      } else {
        Integer value = setB.get(number);
        setB.put(number, value + 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : setA.entrySet()) {
      Integer countB = setB.get(entry.getKey());
      if (countB != null) {
        int num = Math.min(countB, entry.getValue());
        for (int i = 0; i < num; i++) {
          result.add(entry.getKey());
        }
      }
    }
    return result;
  }
}
