// Determine if there exists a set of four elements in a given array that sum to the given target number.
//
// Assumptions
// The given array is not null and has length of at least 4
//
// Examples
// A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 8)
// A = {1, 2, 2, 3, 4}, target = 12, return false

/*
 * Method 1: sort the array first
 */
/*
public class Solution {
  public boolean exist(int[] array, int target) {
    Arrays.sort(array);       // Quick sort, merge sort...
    for (int i = 0; i < array.length - 3; i++) {
      for (int j = i + 1; j < array.length - 2; j++) {
        int left = j + 1;
        int right = array.length - 1;
        int curTarget = target - array[i] - array[j];
        while (left < right) {
          int sum = array[left] + array[right];
          if (sum == curTarget) {
            return true;
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return false;
  }
}

// Time complexity: O(n ^ 4)
// Space complexity: O(1)
*/

/*
 * Method 2: get all pairs of numbers and apply 2 sum
 */
public class Solution {
  static class Element implements Comparable<Element> {
    int left;
    int right;
    int sum;
    
    Element(int left, int right, int sum) {
      this.left = left;
      this.right = right;
      this.sum = sum;
    }
    
    @Override
    public int compareTo(Element another) {
      if (this.sum != another.sum) {
        return this.sum < another.sum ? -1 : 1;
      } else if (this.right != another.right) {
        return this.right < another.right ? -1 : 1;
      } else if (this.left != another.left) {
        return this.left < another.left ? -1 : 1;
      }
      return 0;
    }
  }

  public boolean exist(int[] array, int target) {
    Arrays.sort(array);
    Element[] pairSum = getPairSum(array);
    Arrays.sort(pairSum);
    int left = 0;
    int right = pairSum.length - 1;
    while (left < right) {
      // Only return true if two pair sums' sum is target and the larger pair sum's left index > smaller pair sum's 
      // large index.
      if (pairSum[left].sum + pairSum[right].sum == target && pairSum[left].right < pairSum[right].left) {
        return true;
      } else if (pairSum[left].sum + pairSum[right].sum < target) {
        left++;
      } else {
        // When two pair sums' sum > target, right--
        // When two pair sums' sum == target but larger pair sum's left index <= smaller pair sum's right index, right--
        // because the only thing we can guarantee is that right now the smaller pair sum's right index is the smallest one
        // among all pairSums with the same sum, and it is possible we can find another pair with smaller right index.
        right--;
      }
    }
    return false;
  }
  
  private Element[] getPairSum(int[] array) {
    Element[] pairSum = new Element[array.length * (array.length - 1) / 2];
    int curIndex = 0;
    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        pairSum[curIndex++] = new Element(j, i, array[j] + array[i]);
      }
    }
    return pairSum;
  }
}

/*
 * Method 3: use hashmap
 */
/*
public class Solution {
  static class Pair {
    int left;
    int right;
    
    Pair(int left, int right) {
      this.left = left;
      this.right = right;
    }
  }

  public boolean exist(int[] array, int target) {
    Map<Integer, Pair> map = new HashMap<>();
    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        int pairSum = array[j] + array[i];
        if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {
          return true;
        }
        if (!map.containsKey(pairSum)) {
          map.put(pairSum, new Pair(j, i));
        }
      }
    }
    return false;
  }
}
*/
