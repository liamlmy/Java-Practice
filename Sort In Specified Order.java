// Given two integer arrays A1 and A2, sort A1 in such a way that the relative order among the elements will be
// same as those are in A2.
// For the elements that are not in A2, append them in the right end of the A1 in an ascending order.
//
// Assumptions:
// A1 and A2 are both not null.
// There are no duplicate elements in A2.
//
// Examples:
// A1 = {2, 1, 2, 5, 7, 1, 9, 3}, A2 = {2, 1, 3}, A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}

/*
 * Method 1
 */
/*
public class Solution {
  public int[] sortSpecial(int[] A1, int[] A2) {
    // Corner check
    if (A2.length == 0) {
      quickSort(A1, 0, A1.length - 1);
      return A1;
    }
		int end = 0;
		// Reoreder the same elements in the special order
		for (int i = 0; i < A2.length; i++) {
			for (int j = 0; j < A1.length; j++) {
				if (A1[j] == A2[i]) {
					swap(A1, end, j);
					end++;
				}
			}
		}
		// Reorder the rest elements in ascending order
		quickSort(A1, end, A1.length - 1);
		return A1;
	}

	private void quickSort(int[] array, int i, int j) {
		// Base case
		if (i >= j) {
			return;
		}
		// Recursion rule
		int piv = partition(array, i, j);
		int left = i;
		int right = j - 1;
		while (left <= right) {
			if (array[left] >= piv) {
				swap(array, left, right);
				right--;
			} else if (array[right] < piv) {
				swap(array, left, right);
				left++;
			} else {
				left++;
				right--;
			}
		}
		swap(array, left, j);
		quickSort(array, i, left - 1);
		quickSort(array, left + 1, j);
	}

	private int partition(int[] array, int i, int j) {
		int pivot = i + (int) (Math.random() * (j - i));
		swap(array, pivot, j);
		return array[j];
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
*/

/*
 * Method 2: Override the comparator of Arrays.sort()
 */
public class Solution {
  static class MyComparator implements Comparator<Integer> {
    private Map<Integer, Integer> map;
    public MyComparator(int[] array) {
      map = new HashMap<Integer, Integer>();
      for (int i = 0; i < array.length; i++) {
        map.put(array[i], i);
      }
    }
    
    @Override
    public int compare(Integer i1, Integer i2) {
      Integer i1Index = map.get(i1);
      Integer i2Index = map.get(i2);
      if (i1Index != null && i2Index != null) {
        return i1Index.compareTo(i2Index);
      } else if (i1Index == null && i2Index == null) {
        return i1.compareTo(i2);
      }
      return i1 != null ? -1 : 1;
    }
  }

  public int[] sortSpecial(int[] A1, int[] A2) {
    Integer[] array = intToInteger(A1);
    Arrays.sort(A1, new MyComparator(A2));
    integerToInt(array, A1);
    return A1;
  }
  
  private Integer[] intToInteger(int[] array) {
    Integer[] result = new Integer[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = array[i];
    }
    return result;
  }
  
  private void integerToInt(Integer[] array, int[] result) {
    for (int i = 0; i < array.length; i++) {
      result[i] = array[i];
    }
  }
}
